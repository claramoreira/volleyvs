package model.entities;

public class Score {

	private Long firstTeamScore;

	private Long secondTeamScore;

	public Score() {
	}

	public Score(Long firstTeamScore, Long secondTeamScore) {
		super();
		this.firstTeamScore = firstTeamScore;
		this.secondTeamScore = secondTeamScore;
	}

	public Long getFirstTeamScore() {
		return firstTeamScore;
	}

	public void setFirstTeamScore(Long firstTeamScore) {
		this.firstTeamScore = firstTeamScore;
	}

	public Long getSecondTeamScore() {
		return secondTeamScore;
	}

	public void setSecondTeamScore(Long secondTeamScore) {
		this.secondTeamScore = secondTeamScore;
	}

}
