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

//	public int insertBoard(Connection con, FreeVo board) {
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String query = "";
//		//0. 쿼리 작성(쿼리 틀)
//		query = "INSERT INTO BOARD "
//					+ "VALUES (SEQ_BOARD.NEXTVAL, ?, ?, ?, DEFAULT, "
//					+ " ?, DEFAULT, DEFAULT)";
//		try {
//			//1. 쿼리 전송 객체 생성(preparedstmt)
//			pstmt = con.prepareStatement(query);
//			//2. 쿼리 파라미터 설정
//			pstmt.setString(1, board.getTitle());
//			pstmt.setString(2, board.getContent());
//			pstmt.setString(3, board.getWriter());
//			pstmt.setString(4, board.getAttachFile());
//			//3. 쿼리 실행
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			//4. 자원 반납
//			JDBCTemplate.close(pstmt);
//		}
//		//5. 결과 리턴
//		return result;
//	}
//
//	public FreeVo selectBoard(Connection con, int boardNo) {
//		FreeVo board = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String query = "";
//		//1. 쿼리 작성
//		query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
//					+ "FROM BOARD B, MEMBER M "
//					+ "WHERE B.BWRITER = M.USERID "
//					+ " AND BNO = ?";
//		try {
//			//2. 쿼리 실행 객체 생성
//			pstmt = con.prepareStatement(query);
//			//3. 파라미터 설정
//			pstmt.setInt(1, boardNo);
//			//4. 쿼리 실행
//			rs = pstmt.executeQuery();
//			//5. 결과 처리(resultset)
//			while(rs.next()){
//				board = new FreeVo();
//				board.setTitle(rs.getString("BTITLE"));
//				board.setContent(rs.getString("BCONTENT"));
//				board.setNo(boardNo);
//				board.setCount(rs.getInt("BCOUNT"));
//				board.setWriter(rs.getString("BWRITER"));
//				board.setWriterName(rs.getString("USERNAME"));
//				board.setWriteDate(rs.getDate("BDATE"));
//				board.setAttachFile(rs.getString("BOARDFILE"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			//6. 자원 반납
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		}
//		//7. 결과 값 return
//		return board;
//	}
//
//	public int updateBoard(Connection con, FreeVo board) {
//		int result = -1;
//		PreparedStatement pstmt = null;
//		String query = "";
//		query = "UPDATE BOARD "
//					+ "SET BTITLE = ?, BCONTENT = ?, BOARDFILE = ? "
//					+ "WHERE BNO = ?";
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setString(1, board.getTitle());
//			pstmt.setString(2, board.getContent());
//			pstmt.setString(3, board.getAttachFile());
//			pstmt.setInt(4, board.getNo());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			JDBCTemplate.close(pstmt);
//		}
//		return result;
//	}
//
//	public int updateBoardCount(Connection con, int boardNo) {
//		int result = -1;
//		PreparedStatement pstmt = null;
//		String query = "";
//		query = "UPDATE BOARD "
//					+ "SET BCOUNT = BCOUNT + 1 "
//					+ "WHERE BNO = ?";
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, boardNo);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			JDBCTemplate.close(pstmt);
//		}
//		return result;
//	}
//
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
//
//	public ArrayList<FreeVo> selectBoardListPage(Connection con, int currentPage, int limit) {
//		ArrayList<FreeVo> list = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String query = "";
//		try {
//			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
//					+ "FROM ( SELECT ROWNUM RNUM, P.* "
//					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
//					+						"   FROM BOARD B, MEMBER M "
//					+						"   WHERE B.BWRITER = M.USERID "
//					+						"   	AND B.DELFLAG = 'N' "
//					+ 						"   ORDER BY BNO DESC) P) "
//					+ "WHERE RNUM BETWEEN ? AND ? ";
//
//			pstmt = con.prepareStatement(query);
//			
//			int startRow = (currentPage - 1) * limit + 1; 
//			int endRow = startRow + limit - 1;
//			
//			pstmt.setInt(1, startRow);
//			pstmt.setInt(2, endRow);
//			
//			//3. 쿼리 실행
//			rs = pstmt.executeQuery();
//			//4. 결과 처리(resultSet-list parsing)
//			list = new ArrayList<FreeVo>();
//			FreeVo temp = null;
//			while(rs.next()){
//				temp = new FreeVo();
//				temp.setNo(rs.getInt("bno"));
//				temp.setTitle(rs.getString("btitle"));
//				temp.setContent(rs.getString("bcontent"));
//				temp.setWriter(rs.getString("bwriter"));
//				temp.setWriterName(rs.getString("username"));
//				temp.setCount(rs.getInt("bcount"));
//				temp.setWriteDate(rs.getDate("bdate"));
//				temp.setAttachFile(rs.getString("boardfile"));
//				
//				list.add(temp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			//5. 자원 반납(close)
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		}
//		//6. 결과 리턴
//		return list;
//	}
//
//	public int selectBoardTotalCountSearch(Connection con, int condition, String keyword) {
//		int result = -1;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = "";
//		try {
//			stmt = con.createStatement();
//			query = "SELECT COUNT(*) AS LISTCOUNT "
//						+ "FROM BOARD "
//						+ "WHERE DELFLAG != 'Y' "
//						+ " AND BTITLE LIKE '%" + keyword + "%'";
//			rs = stmt.executeQuery(query);
//			
//			while(rs.next()){
//				result = rs.getInt("listcount");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(stmt);
//		}
//		return result;
//	}
//
//	public ArrayList<FreeVo> selectBoardListPageSearch(Connection con, int currentPage, int limit, int condition,
//			String keyword) {
//		ArrayList<FreeVo> list = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String query = "";
//		try {
//			query = "SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
//					+ "FROM ( SELECT ROWNUM RNUM, P.* "
//					+				"FROM (SELECT BNO, BTITLE, BCONTENT, BWRITER, BCOUNT, BDATE, DELFLAG, BOARDFILE, USERNAME "
//					+						"   FROM BOARD B, MEMBER M "
//					+						"   WHERE B.BWRITER = M.USERID "
//					+						"		AND B.BTITLE LIKE '%' || ? || '%' "	
//					+ 						"   ORDER BY BNO DESC) P) "
//					+ "WHERE RNUM BETWEEN ? AND ? ";
//
//			pstmt = con.prepareStatement(query);
//			
//			int startRow = (currentPage - 1) * limit + 1; 
//			int endRow = startRow + limit - 1;
//			
//			pstmt.setString(1, keyword);
//			pstmt.setInt(2, startRow);
//			pstmt.setInt(3, endRow);
//			
//			//3. 쿼리 실행
//			rs = pstmt.executeQuery();
//			//4. 결과 처리(resultSet-list parsing)
//			list = new ArrayList<FreeVo>();
//			FreeVo temp = null;
//			while(rs.next()){
//				temp = new FreeVo();
//				temp.setNo(rs.getInt("bno"));
//				temp.setTitle(rs.getString("btitle"));
//				temp.setContent(rs.getString("bcontent"));
//				temp.setWriter(rs.getString("bwriter"));
//				temp.setWriterName(rs.getString("username"));
//				temp.setCount(rs.getInt("bcount"));
//				temp.setWriteDate(rs.getDate("bdate"));
//				temp.setAttachFile(rs.getString("boardfile"));
//				
//				list.add(temp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			//5. 자원 반납(close)
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
//		}
//		//6. 결과 리턴
//		return list;
//	}
//
//	public int deleteBoard(Connection con, int boardNo) {
//		int result = -1;
//		PreparedStatement pstmt = null;
//		String query = "";
//		query = "UPDATE BOARD "
//					+ "SET DELFLAG = 'Y' "
//					+ "WHERE BNO = ?";
//		try {
//			pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, boardNo);
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			JDBCTemplate.close(pstmt);
//		}
//		return result;
//	}

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
	
	
}






