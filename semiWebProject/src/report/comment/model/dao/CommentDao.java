package report.comment.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import report.comment.model.vo.CommentVo;
import common.JDBCTemplate;

public class CommentDao { 

	public ArrayList<CommentVo> selectCommentList(Connection con, int boardNo) {
		ArrayList<CommentVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 작성
			query = "SELECT REPLY_NO,  BOARD_NO, C.MEMBER_ID, REPLY_CONTENT,  M.NICKNAME , DEL_FLAG , REPLY_DATE, REPORT_COUNT "
						+ "FROM COMM_REPLY C, MEMBER M "
						+ "WHERE C.MEMBER_ID = M.MEMBER_ID "
						+ "AND REPORT_COUNT != 0 ";
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultSet-list parsing)
			list = new ArrayList<CommentVo>();
			CommentVo temp = null;
			while(rs.next()){
				temp = new CommentVo();
				temp.setCno(rs.getInt("REPLY_NO"));
				temp.setBno(rs.getInt("BOARD_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setContent(rs.getString("REPLY_CONTENT"));
				temp.setWriterName(rs.getString("NICKNAME"));
				String delFlag = rs.getString("DEL_FLAG");
				temp.setWriteDate(rs.getDate("REPLY_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 리턴
		return list;
	}
	
	public int selectCommentTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM COMM_REPLY "
						+ "WHERE REPORT_COUNT != 0 ";
			rs = stmt.executeQuery(query);
			
			while(rs.next()){
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e);
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}
	
	public ArrayList<CommentVo> selectCommentListPage(Connection con, int currentPage, int limit) {
		ArrayList<CommentVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT REPLY_NO,  BOARD_NO, MEMBER_ID, REPLY_CONTENT,  NICKNAME , DEL_FLAG , REPLY_DATE, REPORT_COUNT "
					+ "FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM ( SELECT REPLY_NO,  BOARD_NO, C.MEMBER_ID, REPLY_CONTENT,  M.NICKNAME , DEL_FLAG , REPLY_DATE, REPORT_COUNT "
					+						"   FROM COMM_REPLY C, MEMBER M  "
					+						"   WHERE C.MEMBER_ID = M.MEMBER_ID "
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
			list = new ArrayList<CommentVo>();
			CommentVo temp = null;
			while(rs.next()){
				temp = new CommentVo();
				temp.setCno(rs.getInt("REPLY_NO"));
				temp.setBno(rs.getInt("BOARD_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setContent(rs.getString("REPLY_CONTENT"));
				temp.setWriterName(rs.getString("NICKNAME"));
				String delFlag = rs.getString("DEL_FLAG");
				temp.setWriteDate(rs.getDate("REPLY_DATE"));
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
	
	public int deleteComment(Connection con, CommentVo comment) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "";
		//0. 쿼리 작성(쿼리 틀)
		query = "DELETE FROM COMM_REPLY "
					+ "SET CCONTENT = ? "
					+ "WHERE REPORT_COUNT != 0";
		try {
			//1. 쿼리 전송 객체 생성(preparedstmt)
			pstmt = con.prepareStatement(query);
			//2. 쿼리 파라미터 설정
			pstmt.setString(1, comment.getContent());
			//3. 쿼리 실행
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//4. 자원 반납
			JDBCTemplate.close(pstmt);
		}
		//5. 결과 리턴
		return result;
	}
}
