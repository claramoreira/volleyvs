package model.entities;

import java.util.Objects;

public class Player {

	private Long id;

	private String name;

	private Integer overall;

	private Condition condition;

	private Position position;

	private Double height;

	private Double serverPower;

	private Double attackPower;

	private Double blockPower;

	private Double receptionPower;

	private Double avgAttacksPointsByMatch;

	private Double avgBlockPointsByMatch;

	private Double avgServerPointsByMatch;

	public Player() {

	}

	public Player(Long id, String name, Integer overall, Condition condition, Position position, Double height,
			Double serverPower, Double attackPower, Double blockPower, Double receptionPower,
			Double avgAttacksPointsByMatch, Double avgBlockPointsByMatch, Double avgServerPointsByMatch) {
		super();
		this.id = id;
		this.name = name;
		this.overall = overall;
		this.condition = condition;
		this.position = position;
		this.height = height;
		this.serverPower = serverPower;
		this.attackPower = attackPower;
		this.blockPower = blockPower;
		this.receptionPower = receptionPower;
		this.avgAttacksPointsByMatch = avgAttacksPointsByMatch;
		this.avgBlockPointsByMatch = avgBlockPointsByMatch;
		this.avgServerPointsByMatch = avgServerPointsByMatch;
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

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getServerPower() {
		return serverPower;
	}

	public void setServerPower(Double serverPower) {
		this.serverPower = serverPower;
	}

	public Double getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(Double attackPower) {
		this.attackPower = attackPower;
	}

	public Double getBlockPower() {
		return blockPower;
	}

	public void setBlockPower(Double blockPower) {
		this.blockPower = blockPower;
	}

	public Double getReceptionPower() {
		return receptionPower;
	}

	public void setReceptionPower(Double receptionPower) {
		this.receptionPower = receptionPower;
	}

	public Double getAvgAttacksPointsByMatch() {
		return avgAttacksPointsByMatch;
	}

	public void setAvgAttacksPointsByMatch(Double avgAttacksPointsByMatch) {
		this.avgAttacksPointsByMatch = avgAttacksPointsByMatch;
	}

	public Double getAvgBlockPointsByMatch() {
		return avgBlockPointsByMatch;
	}

	public void setAvgBlockPointsByMatch(Double avgBlockPointsByMatch) {
		this.avgBlockPointsByMatch = avgBlockPointsByMatch;
	}

	public Double getAvgServerPointsByMatch() {
		return avgServerPointsByMatch;
	}

	public void setAvgServerPointsByMatch(Double avgServerPointsByMatch) {
		this.avgServerPointsByMatch = avgServerPointsByMatch;
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
