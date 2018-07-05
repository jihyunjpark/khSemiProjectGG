package board.show.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.show.model.vo.ShowVo;
import common.JDBCTemplate;

public class ShowDao {
	Properties prop = new Properties();
	
	public ShowDao(){
		String filename = ShowDao.class
				.getResource("/show/show.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<ShowVo> selectShowList(Connection con){
		List<ShowVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShowList");
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<ShowVo>();
			ShowVo temp = null;
			while(rs.next()){
				temp = new ShowVo();
				temp.setShow_image(rs.getString("SHOW_IMAGE"));
				temp.setShow_code(rs.getInt("SHOW_CODE"));
				temp.setShow_grade(rs.getInt("SHOW_GRADE"));
				temp.setShow_name(rs.getString("SHOW_NAME"));
				temp.setGenre(rs.getString("GENRE"));
				temp.setGuest(rs.getString("GUEST"));
				temp.setTheater_no(rs.getInt("THEATER_NO"));
				temp.setReview_count(rs.getInt("REVIEW_COUNT"));
				temp.setSeen_count(rs.getInt("SEEN_COUNT"));
				temp.setWish_count(rs.getInt("WISH_COUNT"));
				temp.setLocation(rs.getString("LOCATION"));
				temp.setCategory(rs.getString("CATEGORY"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public List<ShowVo> selectShowMenuList(Connection con, String category) {
		List<ShowVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShowList");
		query += " WHERE CATEGORY = '" + category + "'";
		System.out.println(query);
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<ShowVo>();
			ShowVo temp = null;
			while(rs.next()){
				temp = new ShowVo();
				temp.setShow_image(rs.getString("SHOW_IMAGE"));
				temp.setShow_code(rs.getInt("SHOW_CODE"));
				temp.setShow_grade(rs.getInt("SHOW_GRADE"));
				temp.setShow_name(rs.getString("SHOW_NAME"));
				temp.setGenre(rs.getString("GENRE"));
				temp.setGuest(rs.getString("GUEST"));
				temp.setTheater_no(rs.getInt("THEATER_NO"));
				temp.setReview_count(rs.getInt("REVIEW_COUNT"));
				temp.setSeen_count(rs.getInt("SEEN_COUNT"));
				temp.setWish_count(rs.getInt("WISH_COUNT"));
				temp.setLocation(rs.getString("LOCATION"));
				temp.setCategory(rs.getString("CATEGORY"));
				temp.setPeriod(rs.getString("PERIOD"));
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}


	public ShowVo selectShow(Connection con, int showCode) {
		ShowVo show = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		
		query = prop.getProperty("selectShow");
		System.out.println(query);
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, showCode);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				show = new ShowVo();
				show.setShow_image(rs.getString("SHOW_IMAGE"));
				show.setShow_code(rs.getInt("SHOW_CODE"));
				show.setShow_grade(rs.getInt("SHOW_GRADE"));
				show.setShow_name(rs.getString("SHOW_NAME"));
				show.setGenre(rs.getString("GENRE"));
				show.setGuest(rs.getString("GUEST"));
				show.setTheater_no(rs.getInt("THEATER_NO"));
				show.setReview_count(rs.getInt("REVIEW_COUNT"));
				show.setSeen_count(rs.getInt("SEEN_COUNT"));
				show.setWish_count(rs.getInt("WISH_COUNT"));
				show.setLocation(rs.getString("LOCATION"));
				show.setCategory(rs.getString("CATEGORY"));
				show.setPeriod(rs.getString("PERIOD"));
				show.setShow_runtime(rs.getString("SHOW_RUNTIME"));
				show.setSub_image(rs.getString("SUB_IMAGE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return show;
	}
}
