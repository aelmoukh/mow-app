package com.mowitmow.model;

import java.util.Map;

import com.mowitmow.model.tendeuse.Tendeuse;

public class Pelouse {
    private Map<Coordonnees, Tendeuse> tendeusesDeployees;
    private Coordonnees coordonneesCoinInfGauche;
    private Coordonnees coordonneesCoinSupDroit;

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
}