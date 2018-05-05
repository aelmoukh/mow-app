package com.mowitmow.model;

public class Coordonnees {
    private int x;
    private int y;

    public Coordonnees() {
        super();
    }

    public Coordonnees(int positionX, int positionY) {
        super();
        this.x = positionX;
        this.y = positionY;
    }

    public Coordonnees(Coordonnees coordonnees) {
        super();
        this.x = coordonnees.x;
        this.y = coordonnees.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int positionX) {
        this.x = positionX;
    }

    public int getY() {
        return y;
    }

    public void setY(int positionY) {
        this.y = positionY;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        if (x != other.x)
            return false;
        return (y == other.y);
    }

    @Override
    public String toString() {
        return "X=" + x + " Y=" + y;
    }
}
