package board.free.model.dao;

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
import board.free.model.vo.FreeVo;
import common.JDBCTemplate;

public class FreeDao {
	Properties prop = new Properties();
	
	public FreeDao(){
		String filename = FreeDao.class
				.getResource("/community/free.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<FreeVo> selectFreeList(Connection con, int currentPage, int limit){
		List<FreeVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//2. 쿼리 작성
			query = prop.getProperty("selectFreeList");
			//1. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<FreeVo>();
			FreeVo temp = null;
			while(rs.next()){
				temp = new FreeVo();
				temp.setBoard_no(rs.getInt("BOARD_NO"));
				temp.setNickname(rs.getString("NICKNAME"));
				temp.setTitle(rs.getString("LISTTITLE"));
				temp.setBoard_count(rs.getInt("BOARD_COUNT"));
				temp.setBoard_date(rs.getDate("BOARD_DATE"));
				
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

	public int selectFreeTotalCount(Connection con) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = prop.getProperty("selectFreeTotalCount");
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

	public FreeVo selectFree(Connection con, int boardNo) {
		FreeVo board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		//1. 쿼리 작성
		query = prop.getProperty("selectFree");
		try {
			//2. 쿼리 실행 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 파라미터 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultset)
			while(rs.next()){
				board = new FreeVo();
				board.setBoard_no(rs.getInt("BOARD_NO"));
				board.setNickname(rs.getString("NICKNAME"));
				board.setTitle(rs.getString("TITLE"));
				board.setBoard_count(rs.getInt("BOARD_COUNT") + 1);
				board.setBoard_date(rs.getDate("BOARD_DATE"));
				board.setBoard_content(rs.getString("BOARD_CONTENT"));
				board.setMember_id(rs.getString("MEMBER_ID"));
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

	public int updateReadCount(Connection con, int boardNo) {
		int result = -1;
		PreparedStatement pstmt = null;
		String query = "";
		query = prop.getProperty("updateReadCount");
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

	public int insertComment(Connection con, FreeReplyVo reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("insertReply");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, reply.getBoard_no());
			pstmt.setString(2, reply.getMember_id());
			pstmt.setString(3, reply.getReply_content());
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

	public ArrayList<FreeReplyVo> selectReplyList(Connection con, FreeReplyVo reply) {
		ArrayList<FreeReplyVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("selectReplyList");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, reply.getBoard_no());
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultSet-list parsing)
			list = new ArrayList<FreeReplyVo>();
			FreeReplyVo temp = null;
			while(rs.next()){
				temp = new FreeReplyVo();
				temp.setReply_no(rs.getInt("REPLY_NO"));
				temp.setBoard_no(rs.getInt("BOARD_NO"));
				temp.setReply_content(rs.getString("REPLY_CONTENT"));
				temp.setNickname(rs.getString("NICKNAME"));
				temp.setMember_id(rs.getString("MEMBER_ID"));
				temp.setReply_date_str(rs.getString("REPLY_DATE_STR"));
				temp.setReply_date(rs.getDate("REPLY_DATE"));
				
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

	public int deleteComment(Connection con, FreeReplyVo reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("deleteReply");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, reply.getReply_no());
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

	public int updateComment(Connection con, FreeReplyVo reply) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("updateComment");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setString(1, reply.getReply_content());
			pstmt.setInt(2, reply.getReply_no());
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

	public ArrayList<FreeReplyVo> selectReplyList(Connection con, int boardNo) {
		ArrayList<FreeReplyVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("selectReplyList");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, boardNo);
			//4. 쿼리 실행
			rs = pstmt.executeQuery();
			//5. 결과 처리(resultSet-list parsing)
			list = new ArrayList<FreeReplyVo>();
			FreeReplyVo temp = null;
			while(rs.next()){
				temp = new FreeReplyVo();
				temp.setReply_no(rs.getInt("REPLY_NO"));
				temp.setBoard_no(rs.getInt("BOARD_NO"));
				temp.setReply_content(rs.getString("REPLY_CONTENT"));
				temp.setNickname(rs.getString("NICKNAME"));
				temp.setMember_id(rs.getString("MEMBER_ID"));
				temp.setReply_date_str(rs.getString("REPLY_DATE_STR"));
				temp.setReply_date(rs.getDate("REPLY_DATE"));
				
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

	public int deleteBoard(Connection con, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("deleteBoard");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, boardNo);
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

	public int deleteBoardReply(Connection con, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("deleteBoardReply");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setInt(1, boardNo);
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

	public int insertFree(Connection con, FreeVo free) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("insertFree");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setString(1, free.getMember_id());
			pstmt.setString(2, free.getTitle());
			pstmt.setString(3, free.getBoard_content());
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

	public int updateFree(Connection con, FreeVo free) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		try {
			//1. 쿼리 작성
			query = prop.getProperty("updateFree");
			//2. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			//3. 전달 값 설정
			pstmt.setString(1, free.getTitle());
			pstmt.setString(2, free.getBoard_content());
			pstmt.setInt(3, free.getBoard_no());
			
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

	public int selectSearchFreeTotalCount(Connection con, int condition, String keyword) {
		int result = -1;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = prop.getProperty("selectFreeSearchTotalCount");
			switch(condition){
			case 1:
				query += " AND TITLE LIKE '%" + keyword + "%'";
				break;
			case 2:
				query += " AND BOARD_CONTENT LIKE '%" + keyword + "%'";
				break;
			case 3:
				query += " AND NICKNAME LIKE '%" + keyword + "%'";
				break;
			}
			
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

	public List<FreeVo> selectSearchFreeList(Connection con, int currentPage, int limit, int condition, String keyword) {
		List<FreeVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			//2. 쿼리 작성
			query = prop.getProperty("selectFreeListPre");
			switch(condition){
			case 1:
				query += " AND TITLE LIKE '%" + keyword + "%'";
				break;
			case 2:
				query += " AND BOARD_CONTENT LIKE '%" + keyword + "%'";
				break;
			case 3:
				query += " AND NICKNAME LIKE '%" + keyword + "%'";
				break;
			}
			query += prop.getProperty("selectFreeListEnd");
			//1. 쿼리 전송 객체 생성
			pstmt = con.prepareStatement(query);
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<FreeVo>();
			FreeVo temp = null;
			while(rs.next()){
				temp = new FreeVo();
				temp.setBoard_no(rs.getInt("BOARD_NO"));
				temp.setNickname(rs.getString("NICKNAME"));
				temp.setTitle(rs.getString("LISTTITLE"));
				temp.setBoard_count(rs.getInt("BOARD_COUNT"));
				temp.setBoard_date(rs.getDate("BOARD_DATE"));
				
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


}






