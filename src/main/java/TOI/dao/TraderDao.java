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

public class TraderDao implements ParameterizedRowMapper<SenderOrder> {
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
		bean.setTid(rs.getString("tid"));
		bean.setPayTime(rs.getTimestamp("pay_time"));
		bean.setSellerMemo(rs.getString("trade_memo"));
		bean.setExpressNum(rs.getString("express_number"));
		bean.setReceiverMobile(rs.getString("receiver_phone"));
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

	public int insert(final SenderOrder trade) {
		final String sql = "insert into user_sendorder (tid,pay_time,buyer_nick,receiver_name, receiver_state, receiver_city, receiver_address, receiver_mobile, receiver_phone,seller_flag,trade_memo) values (?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		ikeaTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, trade.getTid() + "");
				ps.setTimestamp(2, new Timestamp(trade.getPayTime().getTime()));
                ps.setString(3, trade.getBuyerNIck());
                ps.setString(4, trade.getReceiverName());
                ps.setString(5, trade.getRecerverState());
                ps.setString(6, trade.getReceiverCity());
                ps.setString(7, trade.getReceiverAddress());
                ps.setString(8, trade.getReceiverMobile());
                ps.setString(9, trade.getReceiverPhone());
                ps.setInt(10, trade.getSellerFlag());
                ps.setString(11, trade.getSellerMemo());
				return ps;
			}
		}, keyHolder);

		int generatedId = keyHolder.getKey().intValue();
		return generatedId;
	}

	public int find(String tid) {
		int id = 0;
		try {
			id = ikeaTemplate.queryForInt("SELECT id FROM user_sendorder WHERE tid = " + tid);
		} catch (Exception e) {
		}
		return id > 0 ? id : 0;
	}
}
