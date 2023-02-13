package model.entities;

public enum Condition {
	INJURED(0.0), AWFUL(1.0), BAD(3.0), NEUTRAL(5.0), GOOD(7.0), EXCELLENT(9.0);

	private final double value;

	Condition(double value) {
		this.value = value;
	}

	public double value() {
		return value;
	}
}
