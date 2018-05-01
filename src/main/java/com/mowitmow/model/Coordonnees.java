package com.mowitmow.model;

public class Coordonnees {
    private int positionX;
    private int positionY;

    public Coordonnees(int positionX, int positionY) {
        super();
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + positionX;
        result = prime * result + positionY;
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
        Coordonnees other = (Coordonnees) obj;
        if (positionX != other.positionX)
            return false;
        return (positionY == other.positionY);
    }

    @Override
    public String toString() {
        return "X=" + positionX + " Y=" + positionY;
    }
}
