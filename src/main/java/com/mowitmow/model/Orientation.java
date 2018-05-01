package com.mowitmow.model;

public enum Orientation {
	N, E, S, W;
	private static Orientation[] values = values();

	public Orientation getNext() {
		return values[(this.ordinal() + 1) % values.length];
	}

	public Orientation getPrevious() {
		return values[(values.length + (this.ordinal() - 1)) % values.length];
	}

}
