package report.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import report.review.model.dao.ReportDao;
import report.review.model.vo.ReportVo;
import common.JDBCTemplate;

public class ReportService {
	public ArrayList<ReportVo> selectReportList(){
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		ArrayList<ReportVo> list = new ReportDao().selectReportList(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return list;
	}

	public ReportVo selectReportForm(int reviewNo) {
		Connection con = JDBCTemplate.getConnection();
		ReportVo board = new ReportDao().selectReport(con, reviewNo);
		JDBCTemplate.close(con);
		return board;
	}

	
	

	public int selectReportTotalCount() {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new ReportDao().selectReportTotalCount(con);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<ReportVo> selectReportListPage(int currentPage, int limit) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReportVo> list 
				= new ReportDao().selectReportListPage(con, currentPage, limit);
		JDBCTemplate.close(con);
		return list;
	}

	public int selectReportTotalCountSearch(int condition, String keyword) {
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection();
		//2. dao 메소드 호출
		int listCount = new ReportDao().selectReportTotalCountSearch(con, condition, keyword);
		//3. 자원 반납(close)
		JDBCTemplate.close(con);
		//4. 해당 결과 리턴
		return listCount;
	}

	public ArrayList<ReportVo> selectReportListPageSearch(int currentPage, int limit, int condition, String keyword) {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ReportVo> list 
				= new ReportDao().selectReportListPageSearch(con, currentPage, limit, condition, keyword);
		JDBCTemplate.close(con);
		return list;
	}

	public int deleteReport(int reviewNo) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new ReportDao().deleteReport(con, reviewNo);
		
		if(0 < result){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		return result;
		
	}
}










