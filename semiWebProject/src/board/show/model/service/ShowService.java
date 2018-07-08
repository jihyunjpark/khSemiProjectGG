package board.show.model.service;

import java.sql.Connection;
import java.util.List;

import board.show.model.dao.ShowDao;
import board.show.model.vo.ShowVo;
import common.JDBCTemplate;

public class ShowService {
	public List<ShowVo> selectShowList() {
		Connection con = JDBCTemplate.getConnection();

		List<ShowVo> list = new ShowDao().selectShowList(con);

		JDBCTemplate.close(con);

		return list;
	}

	public List<ShowVo> selectShowMenuList(String category) {
		Connection con = JDBCTemplate.getConnection();

		List<ShowVo> list = new ShowDao().selectShowMenuList(con, category);

		JDBCTemplate.close(con);

		return list;
	}

	public ShowVo selectShow(int showCode) {
		Connection con = JDBCTemplate.getConnection();

		ShowVo show = new ShowDao().selectShow(con, showCode);

		JDBCTemplate.close(con);

		return show;

	}

	public int getPointgrade(String showId) {
		Connection con = JDBCTemplate.getConnection();

		int point = new ShowDao().getPointgrade(con, showId);

		JDBCTemplate.close(con);

		return point;
	}

	public int getShowReviewCount(String showId) {
		Connection con = JDBCTemplate.getConnection();

		int count = new ShowDao().getShowReviewCount(con, showId);

		JDBCTemplate.close(con);

		return count;
		
	}
}
