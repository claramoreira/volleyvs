package model.entities;

public enum Condition {
	INJURED(0.0),
	AWFUL(10.0),
	BAD(30.0),
	NEUTRAL(50.0),
	GOOD(80.0),
	EXCELLENT(70.0);
	
	private final double value;
	
	Condition(double value) {
		this.value = value;
	}
	
	private double value() { return value; }
}
