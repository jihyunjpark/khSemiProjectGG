package admin.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import admin.notice.model.dao.NoticeDao;
import admin.notice.model.vo.NoticeVo;
import common.JDBCTemplate;

public class NoticeService {
	public List<NoticeVo> getNoticeList(){
		Connection con = JDBCTemplate.getConnection();
		ArrayList<NoticeVo> list = new NoticeDao().selectNoticeList(con);
		JDBCTemplate.close(con);
		return list;
	}
	public NoticeVo getNotice(int notice_no){
		Connection con = JDBCTemplate.getConnection();
		NoticeVo notice = new NoticeDao().selectNotice(con, notice_no);
		
		return notice;
	}
	public int writeNotice(NoticeVo notice){
		Connection con = JDBCTemplate.getConnection();
		int result = new NoticeDao().insertNotice(con, notice);
		JDBCTemplate.close(con);
		return result;
	}
	public int removeNotice(int noticeNo) {
		Connection con = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(con, noticeNo);
		if(result>0){
			JDBCTemplate.commit(con);
		}else{
			JDBCTemplate.rollback(con);
		}
		return result;
	}

}
