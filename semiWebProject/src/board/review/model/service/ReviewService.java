package board.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.review.model.dao.ReviewDao;
import board.review.model.vo.ReviewVo;
import common.JDBCTemplate;


public class ReviewService {

	public int selectReviewTotalCount(String showId) {
		//1. 커넥션 연결
				Connection con = JDBCTemplate.getConnection();
				//2. dao 메소드 호출
				int listCount = new ReviewDao().selectReviewTotalCount(con, showId);
				//3. 자원 반납(close)
				JDBCTemplate.close(con);
				//4. 해당 결과 리턴
				return listCount;
	}

	public ArrayList<ReviewVo> selectReviewListPage(int currentPage, int limit, String showId) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReviewVo> list 
				= new ReviewDao().selectReviewListPage(con, currentPage, limit, showId);
		JDBCTemplate.close(con);
		return list;
	}

}
