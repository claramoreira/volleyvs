package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PlayerDao;
import model.entities.Condition;
import model.entities.Player;
import model.entities.Position;

public class PlayerDaoJDBC implements PlayerDao {

	private Connection conn;

	public PlayerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Player s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Player s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Player findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findByTeam(Integer team) {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Player> list = new ArrayList<Player>();
		try {
			st = conn.prepareStatement("SELECT players.* " + "FROM players " + "WHERE teamId = ? " + "ORDER BY id");
			st.setInt(1, team);
			rs = st.executeQuery();
			while (rs.next()) {
				Player player = instantiatePlayer(rs);
				list.add(player);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Player instantiatePlayer(ResultSet rs) throws SQLException {
		Player player = new Player();
		player.setId(rs.getLong("id"));
		player.setName(rs.getString("Name"));
		player.setOverall(rs.getInt("overall"));
		player.setCondition(Condition.getConditionForId(rs.getInt("condition")));
		player.setPosition(Position.getPositionForId(rs.getInt("position")));
		player.setHeight(rs.getDouble("height"));
		player.setAttackHeight(rs.getDouble("attackHeight"));
		player.setBlockHeight(rs.getDouble("blockHeight"));
		player.setServerPower(rs.getDouble("serverPower"));
		player.setAttackPower(rs.getDouble("attackPower"));
		player.setBlockPower(rs.getDouble("blockPower"));
		player.setReceptionPower(rs.getDouble("receptionPower"));
		player.setAvgServerPointsPerMatch(rs.getDouble("avgServerPointsPerMatch"));
		player.setAvgAttackPointsPerMatch(rs.getDouble("avgAttackPointsPerMatch"));
		player.setAvgBlockPointsPerMatch(rs.getDouble("avgBlockPointsPerMatch"));
		player.setAvgReceptionsPerMatch(rs.getDouble("avgReceptionsPerMatch"));
		return player;
	}
}
