package report.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import report.review.model.vo.ReportVo;
import common.JDBCTemplate;

public class ReportDao {
	public ArrayList<ReportVo> selectReportList(Connection con){
		ArrayList<ReportVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 전송 객체 생성
			stmt = con.createStatement();
			//2. 쿼리 작성
			query = "SELECT REVIEW_NO, MEMBER_ID, M.NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE "
						+ " FROM REVIEW R, MEMBER M "
						+ " WHERE R.MEMBER_ID = M.MEMBER_ID "
						+ " ORDER BY REPORT_COUNT DESC ";
			//3. 쿼리 실행
			rs = stmt.executeQuery(query);
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ReportVo>();
			ReportVo temp = null;
			while(rs.next()){
				temp = new ReportVo();
				temp.setNo(rs.getInt("REVIEW_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setPoint(rs.getInt("POINTGRADE"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setWriteDate(rs.getDate("REVIEW_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				String wish = rs.getString("WISH_BOOL");
				temp.setShowCode(rs.getInt("SHOWCODE"));
				
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

	public ReportVo selectReport(Connection con, int boardNo) {
		ReportVo report = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = "SELECT REVIEW_NO, MEMBER_ID, M.NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE"
				+ " FROM REVIEW R, MEMBER M "
				+ " WHERE R.MEMBER_ID = M.MEMBER_ID "
				+ " AND R.REPORT_COUNT != 0";
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				report = new ReportVo();
				report.setNo(rs.getInt("REVIEW_NO"));
				report.setWriter(rs.getString("MEMBER_ID"));
				report.setWriterName(rs.getString("NICKNAME"));
				report.setPoint(rs.getInt("POINTGRADE"));
				report.setContent(rs.getString("CONTENT"));
				report.setWriteDate(rs.getDate("REVIEW_DATE"));
				report.setRcount(rs.getInt("REPORT_COUNT"));
				String wish = rs.getString("WISH_BOOL");
				report.setShowCode(rs.getInt("SHOWCODE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 값 return
		return report;
	}
	public int selectReportTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ " FROM REVIEW "
						+ " WHERE REPORT_COUNT != 0 ";
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
	
	public int selectReportTotalCountSearch(Connection con, int condition, String keyword) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT "
						+ "FROM REVIEW "
						+ "WHERE REPORT_COUNT != 0 "
						+ " AND CONTENT LIKE '%" + keyword + "%'";
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

	public ArrayList<ReportVo> selectReportListPage(Connection con, int currentPage, int limit) {
		ArrayList<ReportVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT REVIEW_NO, MEMBER_ID, NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE "
					+"FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT REVIEW_NO, R.MEMBER_ID, M.NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE"
                    +                      " FROM REVIEW R, MEMBER M "
                    +               	   " WHERE R.MEMBER_ID = M.MEMBER_ID" 
                    +                      " AND R.REPORT_COUNT != 0" 
                 	+					   " ORDER BY R.REPORT_COUNT DESC) P)" 
					+ " WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ReportVo>();
			ReportVo temp = null;
			while(rs.next()){
				temp = new ReportVo();
				temp.setNo(rs.getInt("REVIEW_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setPoint(rs.getInt("POINTGRADE"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setWriteDate(rs.getDate("REVIEW_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				String wish = rs.getString("WISH_BOOL");
				temp.setShowCode(rs.getInt("SHOWCODE"));
				
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

	public ArrayList<ReportVo> selectReportListPageSearch(Connection con, int currentPage, int limit, int condition,
			String keyword) {
		ArrayList<ReportVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT REVIEW_NO, MEMBER_ID, NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE "
					+"FROM ( SELECT ROWNUM RNUM, P.* "
					+				"FROM (SELECT REVIEW_NO, MEMBER_ID, M.NICKNAME, POINTGRADE ,CONTENT, REVIEW_DATE,  REPORT_COUNT, WISH_BOOL, SHOWCODE "
                    +                       "FROM REVIEW R, MEMBER M "
                    +               	    "WHERE R.MEMBER_ID = M.MEMBER_ID" 
                    +						" AND R.REPORT_COUNT != 0 "
                    +						"AND R.CONTENT '%' || ? || '%' "	
                 	+					    "ORDER BY R.REPORT_COUNT DESC) P)"
					+ "WHERE RNUM BETWEEN ? AND ? ";

			pstmt = con.prepareStatement(query);
			
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ReportVo>();
			ReportVo temp = null;
			while(rs.next()){
				temp = new ReportVo();
				temp.setNo(rs.getInt("REVIEW_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setPoint(rs.getInt("POINTGRADE"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setWriteDate(rs.getDate("REVIEW_DATE"));
				temp.setRcount(rs.getInt("REPORT_COUNT"));
				String wish = rs.getString("WISH_BOOL");
				temp.setShowCode(rs.getInt("SHOWCODE"));
				
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

	public int deleteReport(Connection con, int reviewNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = "DELETE FROM REVIEW "
					+ " WHERE REVIEW_NO = ?"
					+ " AND REPORT_COUNT != 0 ";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	
}











