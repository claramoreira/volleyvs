package model.entities;

public enum Condition {
	INJURED(0.0, 6), AWFUL(1.0, 1), BAD(3.0, 2), NEUTRAL(5.0, 3), GOOD(7.0, 4), EXCELLENT(9.0, 5);

	private final double value;
	private final double id;

	Condition(double value, int id) {
		this.value = value;
		this.id = id;
	}

	public double id() {
		return id;
	}

	public double value() {
		return value;
	}

	public static Condition getConditionForId(final int id) {
		for (final Condition cond : values())
			if (cond.id == id)
				return cond;
		return null;
	}
}
