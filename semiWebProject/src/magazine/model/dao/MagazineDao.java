package magazine.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.JDBCTemplate;
import magazine.model.vo.AttachmentVo;

public class MagazineDao {

	Properties prop = new Properties();

	public MagazineDao() {

		String filename = MagazineDao.class.getResource("/magazine_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<AttachmentVo> selectMagazineList(Connection con) {
		ArrayList<AttachmentVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";

		try {
			stmt = con.createStatement();
			query = prop.getProperty("selectMagazineList");
			rs = stmt.executeQuery(query);

			list = new ArrayList<AttachmentVo>();
			AttachmentVo temp = null;
			while (rs.next()) {
				temp = new AttachmentVo();
				temp.setFno(rs.getInt("fno"));
				temp.setBno(rs.getInt("bno"));
				temp.setOrigin_name(rs.getString("origin_name"));
				temp.setChange_name(rs.getString("change_name"));
				temp.setFile_path(rs.getString("file_path"));

//				temp.setTitle(rs.getString("title"));
//				temp.setContent(rs.getString("content"));
//				temp.setWriteDate(rs.getDate("writeDate"));

				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		return list;

	}

}
