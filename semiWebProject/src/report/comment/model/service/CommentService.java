package report.comment.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import report.comment.model.dao.CommentDao;
import report.comment.model.vo.CommentVo;
import common.JDBCTemplate;

public class CommentService {
	public ArrayList<CommentVo> selectCommentList(int boardNo){
		//connection 생성
		Connection con = JDBCTemplate.getConnection();
		//기능 호출
		ArrayList<CommentVo> list 
							= new CommentDao().selectCommentList(con, boardNo);
		//트랜젝션 처리
		JDBCTemplate.close(con);
		//결과 반환
		return list;
	}
	
	
	
	public int selectCommentTotalCount() {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new CommentDao().selectCommentTotalCount(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<CommentVo> selectCommentListPage(int currentPage, int limit) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<CommentVo> list 
				= new CommentDao().selectCommentListPage(con, currentPage, limit);
		JDBCTemplate.close(con);
		return list;
	}
	
	public int deleteComment(CommentVo comment) {
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//로직 호출
		int result = new CommentDao().deleteComment(con, comment);
		//결과 처리(트랜젝션)
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		//자원 반납
		JDBCTemplate.close(con);
		//결과 return
		return result;
	}
}
















