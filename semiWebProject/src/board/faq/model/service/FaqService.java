package board.faq.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import board.faq.model.dao.FaqDao;
import board.faq.model.vo.FaqVo;
import common.JDBCTemplate;


public class FaqService {
	public ArrayList<FaqVo> getFaqList() {
		Connection con = JDBCTemplate.getConnection();
		ArrayList<FaqVo> list = new FaqDao().selectFaqList(con);
		JDBCTemplate.close(con);
		return list;
	}

}
