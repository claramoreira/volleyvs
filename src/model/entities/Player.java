package model.entities;

import java.util.Objects;

public class Player {

	private Long id;

	private String name;

	private Integer overall;

	private String condition;

	public Player() {

	}

	public Player(Long id, String name, Integer overall, String condition) {
		super();
		this.id = id;
		this.name = name;
		this.overall = overall;
		this.condition = condition;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOverall() {
		return overall;
	}

	public void setOverall(Integer overall) {
		this.overall = overall;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(id, other.id);
	}

}
