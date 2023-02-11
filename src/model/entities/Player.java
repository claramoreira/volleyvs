package model.entities;

import java.util.Objects;

public class Player {

	private Long id;

	private String name;

	private Integer overall;

	private Condition condition;

	private Position position;

	private Double height;

	private Double attackHeight;

	private Double blockHeight;

	private Double serverPower;

	private Double attackPower;

	private Double blockPower;

	private Double receptionPower;

	private Double avgServerPointsPerMatch;

	private Double avgAttackPointsPerMatch;

	private Double avgBlockPointsPerMatch;

	private Double avgReceptionsPerMatch;

	public Player() {

	}

	public Player(Long id, String name, Integer overall, Condition condition, Position position, Double height,
			Double attackHeight, Double blockHeight, Double serverPower, Double attackPower, Double blockPower,
			Double receptionPower, Double avgServerPointsPerMatch, Double avgAttackPointsPerMatch,
			Double avgBlockPointsPerMatch, Double avgReceptionsPerMatch) {
		super();
		this.id = id;
		this.name = name;
		this.overall = overall;
		this.condition = condition;
		this.position = position;
		this.height = height;
		this.attackHeight = attackHeight;
		this.blockHeight = blockHeight;
		this.serverPower = serverPower;
		this.attackPower = attackPower;
		this.blockPower = blockPower;
		this.receptionPower = receptionPower;
		this.avgServerPointsPerMatch = avgServerPointsPerMatch;
		this.avgAttackPointsPerMatch = avgAttackPointsPerMatch;
		this.avgBlockPointsPerMatch = avgBlockPointsPerMatch;
		this.avgReceptionsPerMatch = avgReceptionsPerMatch;
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

	public Double getAttackHeight() {
		return attackHeight;
	}

	public void setAttackHeight(Double attackHeight) {
		this.attackHeight = attackHeight;
	}

	public Double getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(Double blockHeight) {
		this.blockHeight = blockHeight;
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

	public Double getAvgAttackPointsPerMatch() {
		return avgAttackPointsPerMatch;
	}

	public void setAvgAttackPointsPerMatch(Double avgAttackPointsPerMatch) {
		this.avgAttackPointsPerMatch = avgAttackPointsPerMatch;
	}

	public Double getAvgBlockPointsPerMatch() {
		return avgBlockPointsPerMatch;
	}

	public void setAvgBlockPointsPerMatch(Double avgBlockPointsPerMatch) {
		this.avgBlockPointsPerMatch = avgBlockPointsPerMatch;
	}

	public Double getAvgServerPointsPerMatch() {
		return avgServerPointsPerMatch;
	}

	public void setAvgServerPointsPerMatch(Double avgServerPointsPerMatch) {
		this.avgServerPointsPerMatch = avgServerPointsPerMatch;
	}

	public Double getAvgReceptionsPerMatch() {
		return avgReceptionsPerMatch;
	}

	public void setAvgReceptionsPerMatch(Double avgReceptionsPerMatch) {
		this.avgReceptionsPerMatch = avgReceptionsPerMatch;
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

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", condition=" + condition + ", position=" + position + "]";
	}

}
