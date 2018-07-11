package board.free.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import board.free.model.dao.FreeDao;
import board.free.model.vo.FreeReplyVo;
import board.free.model.vo.FreeVo;
import common.JDBCTemplate;

public class FreeService {
	public int selectFreeTotalCount() {
		// 1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		// 2. dao 메소드 호출
		int listCount = new FreeDao().selectFreeTotalCount(con);
		// 3. 자원 반납(close)
		JDBCTemplate.close(con);
		// 4. 해당 결과 리턴
		return listCount;
	}
	

	public List<FreeVo> selectFreeList(int currentPage, int limit) {
		Connection con = JDBCTemplate.getConnection();
		List<FreeVo> list = new FreeDao().selectFreeList(con, currentPage, limit);
		JDBCTemplate.close(con);
		return list;
	}
	

	public FreeVo selectFree(int boardNo) {
		Connection con = JDBCTemplate.getConnection();

		FreeVo board = new FreeDao().selectFree(con, boardNo);
		// 조회 수 조회수 1증가
		if (null != board) {
			int result = new FreeDao().updateReadCount(con, boardNo);
			if (0 < result) {
				JDBCTemplate.commit(con);
			} else {
				JDBCTemplate.rollback(con);
			}
		}
		JDBCTemplate.close(con);
		return board;
	}

	public ArrayList<FreeReplyVo> insertComment(FreeReplyVo reply) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().insertComment(con, reply);
		System.out.println("result : " + result);
		ArrayList<FreeReplyVo> list = new FreeDao().selectReplyList(con, reply);
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return list;
	}

	public ArrayList<FreeReplyVo> deleteComment(FreeReplyVo reply) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().deleteComment(con, reply);

		ArrayList<FreeReplyVo> list = new FreeDao().selectReplyList(con, reply);
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return list;
	}

	public ArrayList<FreeReplyVo> updateComment(FreeReplyVo reply) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().updateComment(con, reply);
		System.out.println("result : " + result);
		ArrayList<FreeReplyVo> list = new FreeDao().selectReplyList(con, reply);
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return list;
	}

	public ArrayList<FreeReplyVo> selectCommentList(int boardNo) {
		Connection con = JDBCTemplate.getConnection();

		ArrayList<FreeReplyVo> list = new FreeDao().selectReplyList(con, boardNo);

		return list;
	}

	public int deleteBoard(int boardNo) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().deleteBoardReply(con, boardNo);
		result = new FreeDao().deleteBoard(con, boardNo);
		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return result;
	}

	public int insertFree(FreeVo free) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().insertFree(con, free);

		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return result;
	}

	public int updateFree(FreeVo free) {
		Connection con = JDBCTemplate.getConnection();

		int result = new FreeDao().updateFree(con, free);

		if (result > 0) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}

		return result;
	}

	public int selectSearchFreeTotalCount(int condition, String keyword) {
		// 1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		// 2. dao 메소드 호출
		int listCount = new FreeDao().selectSearchFreeTotalCount(con, condition, keyword);
		// 3. 자원 반납(close)
		JDBCTemplate.close(con);
		// 4. 해당 결과 리턴
		return listCount;
	}

	public List<FreeVo> selectSearchFreeList(int currentPage, int limit, int condition, String keyword) {
		Connection con = JDBCTemplate.getConnection();
		List<FreeVo> list = new FreeDao().selectSearchFreeList(con, currentPage, limit, condition, keyword);
		JDBCTemplate.close(con);
		return list;
	}

}
