package admin.notice.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import admin.notice.model.vo.NoticeVo;
import common.JDBCTemplate;

public class NoticeDao {

	public ArrayList<NoticeVo> selectNoticeList(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<NoticeVo> result = new ArrayList<NoticeVo>();

		try {
			stmt = con.createStatement();
			String query = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE FROM NOTICEBOARD";
			rs = stmt.executeQuery(query);

			NoticeVo temp = null;
			while (rs.next()) {
				int noticeNo = rs.getInt("notice_no");
				String noticeTitle = rs.getString("notice_title");
				String noticeContent = rs.getString("notice_content");
				Date noticeDate = rs.getDate("notice_date");

				temp = new NoticeVo(noticeNo, noticeTitle, noticeContent, noticeDate);
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public NoticeVo selectNotice(Connection con, int notice_no) {
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		NoticeVo result = null;

		try {
			stmt = con.createStatement();
			query = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE "
					+ "FROM NOTICEBOARD WHERE NOTICE_NO = " + notice_no;
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int noticeNo = rs.getInt("notice_no");
				String noticeTitle = rs.getString("notice_title");
				String noticeContent = rs.getString("notice_content");
				Date noticeDate = rs.getDate("notice_date");

				result = new NoticeVo(noticeNo, noticeTitle, noticeContent, noticeDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public int insertNotice(Connection con, NoticeVo notice) {
		int result = 0;
		Statement stmt = null;
		String query = "";

		try {
			stmt = con.createStatement();
			query = "INSERT INTO NOTICEBOARD VALUES (SEQ_NOTICE_NO.NEXTVAL, '" + notice.getNotice_title() + "', '"
					+ notice.getNotice_content() + "' , SYSDATE)";
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public int deleteNotice(Connection con, int noticeNo) {
		int result = 0;
		Statement stmt = null;
		String query = "";
		try {
			stmt = con.createStatement();
			query = "DELETE FROM NOTICEBOARD WHERE NOTICE_NO = " + noticeNo;
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		return result;
	}

}
