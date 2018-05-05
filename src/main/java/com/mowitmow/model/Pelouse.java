package com.mowitmow.model;

import java.util.HashMap;
import java.util.Map;

import com.mowitmow.model.tendeuse.Tendeuse;

public class Pelouse {
    private Map<Coordonnees, Tendeuse> tendeusesDeployees;
    private Coordonnees coordonneesCoinInfGauche;
    private Coordonnees coordonneesCoinSupDroit;

    public Pelouse() {
        super();
    }

    public Pelouse(Map<Coordonnees, Tendeuse> tendeusesDeployees, Coordonnees coordonneesCoinInfGauche,
            Coordonnees coordonneesCoinSupDroit) {
        super();
        this.tendeusesDeployees = tendeusesDeployees;
        this.coordonneesCoinInfGauche = coordonneesCoinInfGauche;
        this.coordonneesCoinSupDroit = coordonneesCoinSupDroit;
    }

    public Pelouse(int xCoinSupDroit, int yCoinSupDroit) {
        super();
        this.tendeusesDeployees = new HashMap<>();
        this.coordonneesCoinInfGauche = new Coordonnees(0, 0);
        this.coordonneesCoinSupDroit = new Coordonnees(xCoinSupDroit, yCoinSupDroit);
    }

    public Map<Coordonnees, Tendeuse> getTendeusesDeployees() {
        return tendeusesDeployees;
    }

    public Coordonnees getCoordonneesCoinInfGauche() {
        return coordonneesCoinInfGauche;
    }

    public Coordonnees getCoordonneesCoinSupDroit() {
        return coordonneesCoinSupDroit;
    }

    public void setTendeusesDeployees(Map<Coordonnees, Tendeuse> tendeusesDeployees) {
        this.tendeusesDeployees = tendeusesDeployees;
    }

    public void setCoordonneesCoinInfGauche(Coordonnees coordonneesCoinInfGauche) {
        this.coordonneesCoinInfGauche = coordonneesCoinInfGauche;
    }

    public void setCoordonneesCoinSupDroit(Coordonnees coordonneesCoinSupDroit) {
        this.coordonneesCoinSupDroit = coordonneesCoinSupDroit;
    }

    @Override
    public String toString() {
        return "Pelouse [tendeusesDeployees=" + tendeusesDeployees + ", coordonneesCoinInfGauche="
                + coordonneesCoinInfGauche + ", coordonneesCoinSupDroit=" + coordonneesCoinSupDroit + "]";
    }
}