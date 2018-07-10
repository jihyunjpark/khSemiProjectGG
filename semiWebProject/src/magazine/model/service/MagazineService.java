package magazine.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import magazine.model.dao.MagazineDao;
import magazine.model.vo.AttachmentVo;

public class MagazineService {
	
	public ArrayList<AttachmentVo> selectMagazineList(){
		Connection con = JDBCTemplate.getConnection();
		ArrayList<AttachmentVo> list = new MagazineDao().selectMagazineList(con);
		JDBCTemplate.close(con);
		return list;
	}

}
