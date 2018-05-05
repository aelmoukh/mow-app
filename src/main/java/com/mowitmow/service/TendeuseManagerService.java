package com.mowitmow.service;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.mowitmow.model.Coordonnees;
import com.mowitmow.model.Orientation;
import com.mowitmow.model.Pelouse;
import com.mowitmow.model.exception.ExceptionMessage;
import com.mowitmow.model.exception.FunctionnalException;
import com.mowitmow.model.instruction.Iinstruction;
import com.mowitmow.model.instruction.InstructionDeplacement;
import com.mowitmow.model.instruction.InstructionRotation;
import com.mowitmow.model.tendeuse.Tendeuse;
import com.mowitmow.model.tendeuse.TendeusePosition;

public class TendeuseManagerService {
    public Pelouse lancer(String instructions) throws FunctionnalException {
        // validation input
        this.validateInstructions(instructions);
        // extract instructions
        String[] lines = instructions.split("\\r?\\n");
        // init pelouse
        Pelouse pelouse = this.initPelouse(lines[0]);
        // pilote tendeuses
        for (int i = 1; i < lines.length - 1; i += 2) {
            this.piloterTendeuse(lines[i], lines[i + 1], pelouse);
        }
        return pelouse;
    }

    private void validateInstructions(String instructions) throws FunctionnalException {
        if (StringUtils.isEmpty(instructions))
            throw new FunctionnalException(ExceptionMessage.MSG_INPUT_INCOHERENT);
    }

    private TendeusePosition piloterTendeuse(String valInitTendeuse, String instructionsTendeuse, Pelouse pelouse) {
        TendeusePosition positionFinale = null;
        if (!StringUtils.isEmpty(valInitTendeuse) && !StringUtils.isEmpty(instructionsTendeuse) && pelouse != null) {
            // init tendeuse
            Tendeuse tendeuse = this.initTendeuse(valInitTendeuse, pelouse);
            // executer instructions
            positionFinale = this.excuterInstructions(pelouse, tendeuse, instructionsTendeuse);
            // mettre a jour la pelouse
            pelouse.getTendeusesDeployees().put(tendeuse.getPosition().getCoordonnees(), tendeuse);
        }
        return positionFinale;
    }

    private TendeusePosition excuterInstructions(Pelouse pelouse, Tendeuse tendeuse, String instructionsMouvement) {
        TendeusePosition positionFinale = null;
        if (!StringUtils.isEmpty(instructionsMouvement)) {
            char[] instructions = instructionsMouvement.toCharArray();
            for (char c : instructions) {
                Iinstruction instruction = interpretInstructionDeplacemnt(c);
                if (instruction != null) {
                    this.deplacerTendeuseSurPelouse(pelouse, tendeuse, (InstructionDeplacement) instruction);
                } else {
                    tendeuse.tourner(calculerOrientation(tendeuse.getOrientation(), interpretInstructionRotation(c)));
                }
            }
            positionFinale = tendeuse.getPosition();
        }
        return positionFinale;
    }

    private void deplacerTendeuseSurPelouse(Pelouse pelouse, Tendeuse tendeuse, InstructionDeplacement instruction) {
        // claculer cordonnees finaux
        Coordonnees coordonnees = this.calculerPosition(tendeuse.getPosition(), instruction);
        // tester si case authorisee
        if (this.isCaseAthorisee(pelouse, coordonnees)) {
            tendeuse.seDeplacer(coordonnees);
        }
    }

    private boolean isCaseAthorisee(Pelouse pelouse, Coordonnees coordonnees) {
        int xInf = pelouse.getCoordonneesCoinInfGauche().getX();
        int xSupp = pelouse.getCoordonneesCoinSupDroit().getX();
        int yInf = pelouse.getCoordonneesCoinInfGauche().getY();
        int ySupp = pelouse.getCoordonneesCoinSupDroit().getY();
        int x = coordonnees.getX();
        int y = coordonnees.getY();
        return (xInf <= x) && (x <= xSupp) && (yInf <= y) && (y <= ySupp);
    }

    private Coordonnees calculerPosition(TendeusePosition position, InstructionDeplacement instruction) {
        Orientation orientation = position.getOrientation();
        Coordonnees coordonnees = new Coordonnees(position.getCoordonnees());
        if (InstructionDeplacement.A == instruction) {
            switch (orientation) {
            case N:
                coordonnees.setY(coordonnees.getY() + 1);
                break;
            case W:
                coordonnees.setX(coordonnees.getX() - 1);
                break;
            case S:
                coordonnees.setY(coordonnees.getY() - 1);
                break;
            case E:
                coordonnees.setX(coordonnees.getX() + 1);
                break;
            default:
                break;
            }
        }
        return coordonnees;
    }

    private Orientation calculerOrientation(Orientation orientation, InstructionRotation instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException(ExceptionMessage.MSG_INSTR_NON_NULL);
        }
        switch (instruction) {
        case D:
            orientation = orientation.getNext();
            break;
        case G:
            orientation = orientation.getPrevious();
            break;
        default:
            break;
        }
        return orientation;
    }

    private InstructionDeplacement interpretInstructionDeplacemnt(char instructionDeplacement) {
        return Arrays.stream(InstructionDeplacement.values())
                .filter(m -> m.toString().equals(String.valueOf(instructionDeplacement))).findAny().orElse(null);
    }

    private InstructionRotation interpretInstructionRotation(char instructionRotation) {
        return Arrays.stream(InstructionRotation.values())
                .filter(m -> m.toString().equals(String.valueOf(instructionRotation))).findAny().orElse(null);
    }

    private Pelouse initPelouse(String pelouseInitInstruction) {
        return new Pelouse(Character.getNumericValue(pelouseInitInstruction.charAt(0)),
                Character.getNumericValue(pelouseInitInstruction.charAt(2)));
    }

    private Tendeuse initTendeuse(String tendeuseInitInstruction, Pelouse pelouse) {
        Coordonnees coordonnees = new Coordonnees(Character.getNumericValue(tendeuseInitInstruction.charAt(0)),
                Character.getNumericValue(tendeuseInitInstruction.charAt(2)));
        Map<Coordonnees, Tendeuse> tendeusesDeployees = pelouse.getTendeusesDeployees();
        Tendeuse tendeuse = null;
        if (tendeusesDeployees.containsKey(coordonnees)) {
            tendeuse = tendeusesDeployees.get(coordonnees);
            tendeusesDeployees.remove(coordonnees);
        } else {
            tendeuse = new Tendeuse(coordonnees,
                    Orientation.valueOf(String.valueOf(tendeuseInitInstruction.charAt(4))));
            // add put
        }
        return tendeuse;
    }
}
