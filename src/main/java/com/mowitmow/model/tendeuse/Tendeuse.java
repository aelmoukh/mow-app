package com.mowitmow.model.tendeuse;

import com.mowitmow.model.Coordonnees;
import com.mowitmow.model.Orientation;
import com.mowitmow.model.instruction.InstructionDeplacement;
import com.mowitmow.model.instruction.InstructionRotation;

public class Tendeuse {
    private TendeusePosition position;
    private TendeuseStatus status;

    public Tendeuse() {
        super();
    }

    public Tendeuse(TendeusePosition position, TendeuseStatus status) {
        super();
        this.position = position;
        this.status = status;
    }

    public Tendeuse(int positionX, int positionY, Orientation orientation) {
        super();
        this.position = new TendeusePosition(orientation, new Coordonnees(positionX, positionY));
    }

    public TendeusePosition getPosition() {
        return position;
    }

    public TendeuseStatus getStatus() {
        return status;
    }

    public void setPosition(TendeusePosition position) {
        this.position = position;
    }

    public void setStatus(TendeuseStatus status) {
        this.status = status;
    }

    public void setOrientation(Orientation orientation) {
        position.setOrientation(orientation);
    }

    public Orientation getOrientation() {
        return position.getOrientation();
    }

    public void seDeplacer(InstructionDeplacement instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("instruction de deplacement ne peut pas etre null");
        }
        Orientation orientation = position.getOrientation();
        Coordonnees coordonnees = position.getCoordonnees();
        if (InstructionDeplacement.A == instruction) {
            switch (orientation) {
            case N:
                coordonnees.setPositionY(coordonnees.getPositionY() + 1);
                break;
            case W:
                coordonnees.setPositionX(coordonnees.getPositionX() + 1);
                break;
            case S:
                coordonnees.setPositionY(coordonnees.getPositionY() - 1);
                break;
            case E:
                coordonnees.setPositionX(coordonnees.getPositionX() - 1);
                break;
            default:
                break;
            }
        }
    }

    public void tourner(InstructionRotation instruction) {
        if (instruction == null) {
            throw new IllegalArgumentException("instruction de rotation ne peut pas etre null");
        }
        Orientation orientation = position.getOrientation();
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
        position.setOrientation(orientation);
    }
}
