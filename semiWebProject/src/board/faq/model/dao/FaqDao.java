package board.faq.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import board.faq.model.vo.FaqVo;

public class FaqDao {

	public ArrayList<FaqVo> selectFaqList(Connection con) {
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<FaqVo> result = new ArrayList<FaqVo>();
		
		try {
			stmt=con.createStatement();
			String query = "SELECT FAQ_NO, FAQ_TITLE, FAQ_CONTENT, FAQ_DATE FROM FAQBOARD";
			rs = stmt.executeQuery(query);
			
			FaqVo temp = null;
			while(rs.next()){
				int faqNo = rs.getInt("faq_no");
				String faqTitle = rs.getString("faq_title");
				String faqContent = rs.getString("faq_content");
				Date faqDate = rs.getDate("faq_date");
				
				temp = new FaqVo(faqNo, faqTitle, faqContent, faqDate);
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

}
