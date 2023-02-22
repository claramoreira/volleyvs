package model.entities;

public enum Position {

	LEVANTADORA(1), CENTRAL(2), PONTEIRA(3), OPOSTA(4), LIBERO(5);

	private final int id;

	private Position(final int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}

	public static Position getPositionForId(final int id) {
		for (final Position pos : values())
			if (pos.id == id)
				return pos;
		return null;
	}
}
