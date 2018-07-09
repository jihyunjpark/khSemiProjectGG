package report.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import report.board.model.vo.BoardVo;
import common.JDBCTemplate;

public class BoardDao {
	public ArrayList<BoardVo> selectBoardList(Connection con){
		ArrayList<BoardVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			//2. 쿼리 작성
			query = "SELECT BOARD_NO, TITLE, BOARD_CONTENT,B.MEMBER_ID, NICKNAME, BOARD_COUNT,BOARD_DATE,REPORT_COUNT"
						+ "FROM COMMUNITY B, MEMBER M "
						+ "WHERE B.MEMBER_ID = M.MEMBER_ID "
						+ "AND REPORT_COUNT != 0 "
						+ "ORDER BY REPORT_COUNT DESC ";
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("BOARD_NO"));
				temp.setTitle(rs.getString("TITLE"));
				temp.setContent(rs.getString("BOARD_CONTENT"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setCount(rs.getInt("BOARD_COUNT"));
				temp.setWriteDate(rs.getDate("BOARD_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		//6. 결과 리턴
		return list;
	}

	public BoardVo selectBoard(Connection con, int boardNo) {
		BoardVo board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = "SELECT BOARD_NO, TITLE, BOARD_CONTENT, B.MEMBER_ID, NICKNAME, BOARD_COUNT, BOARD_DATE, REPORT_COUNT"
					+ "FROM COMMUNITY B, MEMBER M "
					+ "WHERE B.MEMBER_ID = M.MEMBER_ID "
					+ "AND REPORT_COUNT != 0 "
					+ " AND BOARD_NO = ?";
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				board = new BoardVo();
				board.setNo(rs.getInt("BOARD_NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("BOARD_CONTENT"));
				board.setWriter(rs.getString("MEMBER_ID"));
				board.setWriterName(rs.getString("NICKNAME"));
				board.setCount(rs.getInt("BOARD_COUNT"));
				board.setWriteDate(rs.getDate("BOARD_DATE"));
				board.setRcount(rs.getInt("REPORT_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 값 return
		return board;
	}

	public int selectBoardTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM COMMUNITY "
						+ "WHERE REPORT_COUNT != 0 ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public ArrayList<BoardVo> selectBoardListPage(Connection con, int currentPage, int limit) {
		ArrayList<BoardVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT BOARD_NO, TITLE, BOARD_CONTENT, MEMBER_ID, NICKNAME, BOARD_COUNT, BOARD_DATE, REPORT_COUNT "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM ( SELECT BOARD_NO, TITLE, BOARD_CONTENT, B.MEMBER_ID, NICKNAME, BOARD_COUNT, BOARD_DATE, REPORT_COUNT "
					+						"   FROM COMMUNITY B, MEMBER M "
					+						"   WHERE B.MEMBER_ID = M.MEMBER_ID "
					+ 						"	AND REPORT_COUNT != 0 "
					+ 						"   ORDER BY REPORT_COUNT DESC) P) "
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<BoardVo>();
			BoardVo temp = null;
			while(rs.next()){
				temp = new BoardVo();
				temp.setNo(rs.getInt("BOARD_NO"));
				temp.setTitle(rs.getString("TITLE"));
				temp.setContent(rs.getString("BOARD_CONTENT"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setCount(rs.getInt("BOARD_COUNT"));
				temp.setWriteDate(rs.getDate("BOARD_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴
		return list;
	}

	public int selectBoardTotalCountSearch(Connection con, int condition, String keyword) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM COMMUNITY "
						+ "WHERE BOARD_TITLE LIKE '%" + keyword + "%'"
						+ "AND REPORT_COUNT != 0 ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}


	public int deleteBoard(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "DELETE FROM COMMUNITY"
					+ " WHERE BOARD_NO = ?"
					+ " AND REPORT_COUNT != 0 ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
}











