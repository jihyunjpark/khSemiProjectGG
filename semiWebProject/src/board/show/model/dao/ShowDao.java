package board.show.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.free.model.vo.FreeReplyVo;
import board.show.model.vo.ShowVo;
import common.JDBCTemplate;
import report.review.model.vo.ReportVo;
import report.review.model.vo.ReportVo2;

public class ShowDao {
	Properties prop = new Properties();
	
	public ShowDao(){
		String filename = ShowDao.class
				.getResource("/show/show.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<ShowVo> selectShowList(Connection con){
		List<ShowVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShowList");
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<ShowVo>();
			ShowVo temp = null;
			while(rs.next()){
				temp = new ShowVo();
				temp.setShow_image(rs.getString("SHOW_IMAGE"));
				temp.setShow_code(rs.getInt("SHOW_CODE"));
				temp.setShow_grade(rs.getInt("SHOW_GRADE"));
				temp.setShow_name(rs.getString("SHOW_NAME"));
				temp.setGenre(rs.getString("GENRE"));
				temp.setGuest(rs.getString("GUEST"));
				temp.setTheater_no(rs.getInt("THEATER_NO"));
				temp.setReview_count(rs.getInt("REVIEW_COUNT"));
				temp.setSeen_count(rs.getInt("SEEN_COUNT"));
				temp.setWish_count(rs.getInt("WISH_COUNT"));
				temp.setLocation(rs.getString("LOCATION"));
				temp.setCategory(rs.getString("CATEGORY"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public List<ShowVo> selectShowMenuList(Connection con, String category) {
		List<ShowVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShowList");
		query += " WHERE CATEGORY = '" + category + "'";
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<ShowVo>();
			ShowVo temp = null;
			while(rs.next()){
				temp = new ShowVo();
				temp.setShow_image(rs.getString("SHOW_IMAGE"));
				temp.setShow_code(rs.getInt("SHOW_CODE"));
				temp.setShow_grade(rs.getInt("SHOW_GRADE"));
				temp.setShow_name(rs.getString("SHOW_NAME"));
				temp.setGenre(rs.getString("GENRE"));
				temp.setGuest(rs.getString("GUEST"));
				temp.setTheater_no(rs.getInt("THEATER_NO"));
				temp.setReview_count(rs.getInt("REVIEW_COUNT"));
				temp.setSeen_count(rs.getInt("SEEN_COUNT"));
				temp.setWish_count(rs.getInt("WISH_COUNT"));
				temp.setLocation(rs.getString("LOCATION"));
				temp.setCategory(rs.getString("CATEGORY"));
				temp.setPeriod(rs.getString("PERIOD"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public ShowVo selectShow(Connection con, int showCode) {
		ShowVo show = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShow");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, showCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				show = new ShowVo();
				show.setShow_image(rs.getString("SHOW_IMAGE"));
				show.setShow_code(rs.getInt("SHOW_CODE"));
				show.setShow_grade(rs.getInt("SHOW_GRADE"));
				show.setShow_name(rs.getString("SHOW_NAME"));
				show.setGenre(rs.getString("GENRE"));
				show.setGuest(rs.getString("GUEST"));
				show.setTheater_no(rs.getInt("THEATER_NO"));
				show.setReview_count(rs.getInt("REVIEW_COUNT"));
				show.setSeen_count(rs.getInt("SEEN_COUNT"));
				show.setWish_count(rs.getInt("WISH_COUNT"));
				show.setLocation(rs.getString("LOCATION"));
				show.setCategory(rs.getString("CATEGORY"));
				show.setPeriod(rs.getString("PERIOD"));
				show.setShow_runtime(rs.getString("SHOW_RUNTIME"));
				show.setSub_image(rs.getString("SUB_IMAGE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return show;
	}


	public int getPointgrade(Connection con, String showId) {
		int point = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT TRUNC(SUM(POINTGRADE)/count(POINTGRADE)) AS POINT FROM REVIEW WHERE SHOWCODE=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, showId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				point = rs.getInt("POINT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return point;
	}


	public int getShowReviewCount(Connection con, String showId) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT COUNT(*) AS REVIEWCOUNT FROM REVIEW WHERE SHOWCODE=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, showId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt("REVIEWCOUNT");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}


	public int insertComment(Connection con, ReportVo2 reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
//			query = prop.getProperty("insertReply");
			query = "MERGE INTO REVIEW "
						+"USING DUAL ON (MEMBER_ID=? AND SHOWCODE=?) "
						+"WHEN MATCHED THEN "
					    +"UPDATE SET CONTENT = ? "
					    +"WHEN NOT MATCHED THEN "
					    +"INSERT (REVIEW_NO, MEMBER_ID, POINTGRADE, CONTENT, REVIEW_DATE, SHOWCODE, REPORT_COUNT) "
					    + "VALUES (SEQ_COMM_REPLY_NO.NEXTVAL, ?, 0, ?, SYSDATE, ?, 0)";
			
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setString(1, reply.getWriter());
			pstmt.setString(2, reply.getShowCode());
			pstmt.setString(3, reply.getContent());
			pstmt.setString(4, reply.getWriter());
			pstmt.setString(5, reply.getContent());
			pstmt.setString(6, reply.getShowCode());
			
			//4. 쿼리 실행
			result = pstmt.executeUpdate();
			//5. 결과 처리(resultSet-list parsing)
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6. 자원 반납(close)
			JDBCTemplate.close(pstmt);
		}
		//7. 결과 리턴
		return result;
	}


	public ArrayList<ReportVo2> selectReplyList(Connection con, ReportVo2 reply) {
		ArrayList<ReportVo2> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 작성
			//query = prop.getProperty("selectReplyList");
			query = "SELECT REVIEW_NO, SHOWCODE, POINTGRADE, CONTENT, M.MEMBER_ID, NICKNAME, REVIEW_DATE, " 
						+ "case when (sysdate - REVIEW_DATE) * 24 * 60 * 60 < 60 then trunc((sysdate - REVIEW_DATE) * 24 * 60 * 60) || '\uCD08 \uC804'     when (sysdate - REVIEW_DATE) * 24 * 60 < 60 then         trunc((sysdate - REVIEW_DATE) * 24 * 60 ) || '\uBD84 \uC804'     when (sysdate - REVIEW_DATE) * 24 < 12 then         trunc((sysdate - REVIEW_DATE) * 24) || '\uC2DC\uAC04 \uC804'     when (sysdate - REVIEW_DATE) * 24 > 12 then         to_char(REVIEW_DATE, 'yy/mm/dd') end AS REPLY_DATE_STR "
						+ "FROM REVIEW V "
						+ "JOIN MEMBER M ON (V.MEMBER_ID = M.MEMBER_ID) "
						+ "WHERE SHOWCODE = ? "
						+ "ORDER BY REVIEW_NO ";	
			
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setString(1, reply.getShowCode());
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ReportVo2>();
			ReportVo2 temp = null;
			while(rs.next()){
				temp = new ReportVo2();
				temp.setNo(rs.getInt("REVIEW_NO"));
				temp.setWriter(rs.getString("MEMBER_ID"));
				temp.setWriterName(rs.getString("NICKNAME"));
				temp.setPoint(rs.getInt("POINTGRADE"));
				temp.setContent(rs.getString("CONTENT"));
				temp.setWriteDateStr(rs.getString("REPLY_DATE_STR"));
				
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
