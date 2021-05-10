package com.koreait.board4.user;

import java.sql.Connection;
import java.sql.ResultSet;

import com.koreait.board4.DBUtils;

import java.sql.PreparedStatement;
public class UserDAO {
	public static int joinUser(UserVO param) {
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql="insert into t_user(uid, upw, unm, gender)"
				+" values(?, ?, ?, ?)";
		
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	//로그인 성공:1 아이디없음:2 비밀번호 틀림:3 에러:0
	public static int loginUser(UserVO param) {
		Connection con=null;
		ResultSet rs= null;
		PreparedStatement ps= null;
		String sql="select * from t_user where uid=?";
		try {
			con=DBUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,param.getUid());
			rs=ps.executeQuery();
			while(rs.next()) {
				String dbPw=rs.getString("upw");
				if(dbPw.equals(param.getUpw())) {
					return 1;
				}
				else {return 3;}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 2;
	}
}
