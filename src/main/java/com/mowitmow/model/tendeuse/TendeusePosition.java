package com.mowitmow.model.tendeuse;

import com.mowitmow.model.Coordonnees;
import com.mowitmow.model.Orientation;

public class TendeusePosition {
    private Orientation orientation;
    private Coordonnees coordonnees;

    public TendeusePosition(Orientation orientation, Coordonnees coordonnees) {
        super();
        this.orientation = orientation;
        this.coordonnees = coordonnees;
    }

    public TendeusePosition() {
        super();
    }

    public TendeusePosition(int x, int y, Orientation orientation) {
        this.coordonnees = new Coordonnees(x, y);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordonnees == null) ? 0 : coordonnees.hashCode());
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TendeusePosition other = (TendeusePosition) obj;
        if (coordonnees == null) {
            if (other.coordonnees != null)
                return false;
        } else if (!coordonnees.equals(other.coordonnees))
            return false;
        return (orientation == other.orientation);
    }

    @Override
    public String toString() {
        return coordonnees + " " + orientation;
    }
}
