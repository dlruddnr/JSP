package com.koreait.board;
import java.util.*;
import java.sql.*;
public class BoardDAO {
	public static List<BoardVO> getListDb(){
		List<BoardVO> list=new ArrayList<>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from t_board2";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				list.add(vo);
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps,rs);
		}
		
		
		return list;
	}
	
	public static int insertDb(BoardVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="insert into t_board2 "+"(title,tcnt) "
		+"values(?,?)";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getTcnt());
			System.out.println("삽입");
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps);
		}
		return 0;
	}
	
	public static BoardVO selOne(int iboard) {
		BoardVO vo=new BoardVO();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from t_board2 where iboard=?";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1,iboard);
			rs=ps.executeQuery();
			while(rs.next()) {
				vo.setIboard(rs.getInt("iboard"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setTcnt(rs.getString("tcnt"));
				vo.setTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con,ps,rs);
		}
		return vo;
	}
	
	public static int updateDb(BoardVO vo) {
		Connection con=null;
		PreparedStatement ps= null;
		String sql="update t_board2 set title=?, tcnt=?, regdt=now() where iboard=?";
		
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,vo.getTitle());
			ps.setString(2,vo.getTcnt());
			ps.setInt(3,vo.getIboard());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int deleteDb(int iboard) {
		Connection con=null;
		PreparedStatement ps= null;
		String sql="delete from t_board2 where iboard=?";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	public static List<BoardVO> selComeList(int iboard) {
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BoardVO> list= new ArrayList();
		String sql="select iboard, tcnt, regdt from t_board3 where iboard=?";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setTcnt(rs.getString("tcnt"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static int insertDbCome(BoardVO vo) {
		Connection con =null;
		PreparedStatement ps=null;
		String sql="insert into t_board3 (iboard,tcnt)"+
					" values(?,?)";
		try {
			con=DbUtils.getCon();
			ps=con.prepareStatement(sql);
			ps.setInt(1,vo.getIboard());
			ps.setString(2,vo.getTcnt());
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
}
