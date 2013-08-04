package TOI.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import TOI.model.SenderOrder;

public class SenderOrderDao implements ParameterizedRowMapper<SenderOrder> {
	public JdbcTemplate ikeaTemplate;

	public JdbcTemplate getIkeaTemplate() {
		return ikeaTemplate;
	}

	public void setIkeaTemplate(JdbcTemplate ikeaTemplate) {
		this.ikeaTemplate = ikeaTemplate;
	}

	@Override
	public SenderOrder mapRow(ResultSet rs, int i) throws SQLException {
		SenderOrder bean = new SenderOrder();
		bean.setId(rs.getInt("id"));
		bean.setCtime(rs.getTimestamp("ctime"));
		bean.setExpressNum(rs.getString("express_number"));
		bean.setRevTele(rs.getString("revTele"));
		return bean;
	}

	public List<SenderOrder> getSenderOrderByStatus(int status) {
		String sql = "select  * from  user_sendorder where status=? ";
		List<SenderOrder> mediaUserScopeList = ikeaTemplate.query(sql, new Object[] { status }, this);
		if (mediaUserScopeList != null && mediaUserScopeList.size() > 0) {
			return mediaUserScopeList;
		}
		return null;
	}

	public int insert(final SenderOrder info) {
		final String sql = "insert into user_sendorder (tb_orderId,status,ctime,price) values (?, ?,?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		ikeaTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, info.getTbOrderId());
				ps.setInt(2, info.getStatus());
				ps.setTimestamp(3, new Timestamp(info.getCtime().getTime()));
				ps.setDouble(4, info.getPrice());
				return ps;
			}
		}, keyHolder);

		int generatedId = keyHolder.getKey().intValue();
		return generatedId;
	}

	public int find(String tbOrderId) {
		int id = 0;
		try {
			id = ikeaTemplate.queryForInt("SELECT id FROM user_sendorder WHERE tb_orderId = " + tbOrderId);
		} catch (Exception e) {
		}
		return id > 0 ? id : 0;
	}
}
