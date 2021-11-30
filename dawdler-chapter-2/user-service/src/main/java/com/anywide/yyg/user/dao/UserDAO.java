package com.anywide.yyg.user.dao;

import java.sql.SQLException;
import java.util.List;

import com.anywide.dawdler.serverplug.db.dao.SuperDAO;
import com.anywide.dawdler.serverplug.load.bean.Page;
import com.anywide.yyg.user.entity.User;

public class UserDAO extends SuperDAO {
	/**
	 * 
	 * <p>
	 * Title: selectUserList
	 * </p>
	 * 
	 * @author jackson.song
	 * @date 2020年12月16日
	 * @return List<User>
	 *         <p>
	 *         Description: 查询用户列表
	 *         </p>
	 * @param pageOn
	 * @param row
	 * @param page
	 * @return
	 * @throws SQLException
	 *
	 * 
	 */
	public List<User> selectUserList(int pageOn, int row, Page page) throws SQLException {
		String countSql = "select count(1) from t_user";
		String sql = "select * from t_user";// 只是例子 不建议生产环境下用* 遵循最小化api原则
		return queryListPagePrepare(countSql, sql, pageOn, row, page, User.class);
	}

	/**
	 * 
	 * <p>
	 * Title: insertUser
	 * </p>
	 * 
	 * @author jackson.song
	 * @date 2020年12月16日
	 * @return int
	 *         <p>
	 *         Description:插入用户
	 *         </p>
	 * @param user
	 * @return
	 * @throws SQLException
	 *
	 * 
	 */
	public int insertUser(User user) throws SQLException {
		return insertPrepare("insert into t_user(username,`password`,age)", user.getUsername(), user.getPassword(),
				user.getAge());
	}

}
