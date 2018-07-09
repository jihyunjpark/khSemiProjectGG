package report.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import report.board.model.dao.BoardDao;
import report.board.model.vo.BoardVo;
import common.JDBCTemplate;

public class BoardService {
	public ArrayList<BoardVo> selectBoardList(){
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		ArrayList<BoardVo> list = new BoardDao().selectBoardList(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return list;
	}

	public BoardVo selectBoardForm(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardVo board = new BoardDao().selectBoard(con, boardNo);
		JDBCTemplate.close(con);
		return board;
	}
	
	public BoardVo selectBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		BoardVo board = new BoardDao().selectBoard(con, boardNo);
		JDBCTemplate.close(con);
		return board;
	}
	
	public int selectBoardTotalCount() {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new BoardDao().selectBoardTotalCount(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<BoardVo> selectBoardListPage(int currentPage, int limit) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<BoardVo> list 
				= new BoardDao().selectBoardListPage(con, currentPage, limit);
		JDBCTemplate.close(con);
		return list;
	}

	public int selectBoardTotalCountSearch(int condition, String keyword) {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new BoardDao().selectBoardTotalCountSearch(con, condition, keyword);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public int deleteBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new BoardDao().deleteBoard(con, boardNo);
		
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
		
	}
}










