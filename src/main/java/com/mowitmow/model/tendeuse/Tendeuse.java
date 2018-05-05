package com.mowitmow.model.tendeuse;

import com.mowitmow.model.Coordonnees;
import com.mowitmow.model.Orientation;

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

    public Tendeuse(Coordonnees coordonnees, Orientation orientation) {
        super();
        this.position = new TendeusePosition(orientation, coordonnees);
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

    public void seDeplacer(Coordonnees coordonnees) {
        if (this.position == null) {
            this.position = new TendeusePosition();
        }
        this.position.setCoordonnees(coordonnees);
    }

    public void tourner(Orientation orientation) {
        if (this.position == null) {
            this.position = new TendeusePosition();
        }
        position.setOrientation(orientation);
    }

    @Override
    public String toString() {
        return "Tendeuse [position=" + position + ", status=" + status + "]";
    }
}
