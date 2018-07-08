package board.review.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.review.model.vo.ReviewVo;
import common.JDBCTemplate;

public class ReviewDao {

	public int selectReviewTotalCount(Connection con, String showId) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "SELECT COUNT(*) AS LISTCOUNT " + "FROM REVIEW " + "WHERE SHOWCODE = '" + showId + "'";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				result = rs.getInt("listcount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;

	}

	public ArrayList<ReviewVo> selectReviewListPage(Connection con, int currentPage, int limit, String showId) {
		ArrayList<ReviewVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			query = "SELECT B.RNUM, B.REVIEW_NO, B.MEMBER_ID, B.POINTGRADE, B.CONTENT, B.REVIEW_DATE, B.SHOWCODE, B.REPORT_COUNT, B.WISH_BOOL "
					+ "FROM ("
					+ "SELECT ROWNUM AS RNUM, A.REVIEW_NO, A.MEMBER_ID, A.POINTGRADE, A.CONTENT, A.REVIEW_DATE, A.SHOWCODE, A.REPORT_COUNT, A.WISH_BOOL "
					+ "FROM ("
					+ "SELECT REVIEW_NO, MEMBER_ID, POINTGRADE, CONTENT, REVIEW_DATE, SHOWCODE, REPORT_COUNT, WISH_BOOL "
					+ "FROM REVIEW WHERE SHOWCODE = ? ORDER BY REVIEW_DATE) A " + "WHERE ROWNUM <= ?) B "
					+ "WHERE B.rnum >= ?";

			pstmt = con.prepareStatement(query);

			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;

			
			pstmt.setString(1, showId);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);

			// 3. 쿼리 실행
			rs = pstmt.executeQuery();
			// 4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ReviewVo>();
			ReviewVo temp = null;
			while (rs.next()) {
				temp = new ReviewVo();
				temp.setReviewNo(rs.getInt("REVIEW_NO"));
				temp.setMemberId(rs.getString("MEMBER_ID"));
				temp.setPointgrade(rs.getInt("POINTGRADE"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setReviewDate(rs.getDate("REVIEW_DATE"));
				temp.setShowcode(rs.getString("SHOWCODE"));
				temp.setReportCount(rs.getInt("REPORT_COUNT"));
				temp.setWishbool(rs.getBoolean("WISH_BOOL"));
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		// 6. 결과 리턴
		return list;

	}

}
