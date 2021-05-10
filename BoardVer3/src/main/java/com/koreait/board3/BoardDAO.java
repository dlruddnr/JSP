package com.koreait.board3;

//DATA Access Object(DB담당)
import java.sql.*;
import java.util.*;

public class BoardDAO {
	public static int insertBoard(BoardVO vo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " Insert INTO t_board " + " (title,ctnt) " + " values (?,?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			return ps.executeUpdate();
			// insert, update, delete
			// 영향받은 행의 수 반환
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}

	public static List<BoardVO> selBoardList() {
		List<BoardVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select iboard, title, regdt from t_board" + " order by iboard DESC";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			// rs.next() 레코드 가르키기, 리턴 불린형
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				list.add(vo);
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				vo.setIboard(iboard);
				vo.setRegdt(regdt);
				vo.setTitle(title);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return list;
	}

	public static BoardVO selBoard(int iboard) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = new BoardVO();
		String sql = "select iboard, title, regdt,ctnt from t_board"
				+" where iboard=?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,iboard);
			rs = ps.executeQuery();
			// rs.next() 레코드 가르키기, 리턴 불린형
			while (rs.next()) {
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String ctnt=rs.getString("ctnt");
				vo.setIboard(rs.getInt("iboard"));
				System.out.println(vo.getIboard());
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setCtnt(ctnt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return vo;
	}

	public static int delBoard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "delete from t_board where iboard=?";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,iboard);
			return ps.executeUpdate();
			// insert, update, delete
			// 영향받은 행의 수 반환
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;

	}
	public static int updBoard(BoardVO param) {
		Connection con=null;
		PreparedStatement ps =null;
		String sql="update t_board set title = ?, "+
					"ctnt=? "+"where iboard=? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			return ps.executeUpdate();
			// insert, update, delete
			// 영향받은 행의 수 반환
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
}

//커넥션 풀???
//preparedStatement는 쿼리문 완성 및 실행