package mvc.step1.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mvc.step1.vo.ZipCodeVO;

public class ZipcodeDao {
	
	private Connection connSetting() {
		String url = "jdbc:oracle:thin:@localhost:1521/root";
		Properties props = new Properties();
		props.setProperty("user", "c##scott");
		props.setProperty("password", "tiger");

		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,props);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public String mybatisGetDate() {
		SqlSessionFactory sqlMapper = null;
		SqlSession sqlSession = null;
		Reader reader = null;
		String s = null;
		
		try {
			//String resource = "mvc/src/mvc/step1/src/mybatis/mybatis-config.xml";
			String resource = "mvc/step1/mybatis/mybatis-config.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlMapper.openSession();
			
			s = sqlSession.selectOne("today");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	//mybatis 연동하기
	public List<ZipCodeVO> mybatisGetZipcodeList(int uid_no){
		List<ZipCodeVO> zipcode = new ArrayList<ZipCodeVO>();
		SqlSessionFactory sqlMapper = null;
		SqlSession sqlSession = null;
		Reader reader = null;
		
		try {
			//String resource = "mvc/src/mvc/step1/src/mybatis/mybatis-config.xml";
			String resource = "mvc/step1/mybatis/mybatis-config.xml";
			reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlMapper.openSession();
			
			ZipCodeVO zVO = new ZipCodeVO();
			zVO.setUid_no(50);
			zipcode = sqlSession.selectList("zipdoeList", zVO);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return zipcode;
	}
	
	public List<ZipCodeVO> getZipcodeList(int uid_no){
		List<ZipCodeVO> zipcode = new ArrayList<ZipCodeVO>();
		Connection conn = connSetting();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from zipcode_t where UID_NO = ?";
		
		try {
			stmt= conn.prepareStatement(sql);
			stmt.setInt(1, uid_no);
			rs = stmt.executeQuery();
			while (rs.next()) {
				ZipCodeVO zipCodeVO = new ZipCodeVO();
				zipCodeVO.setUid_no(rs.getInt("uid_no"));
				
				zipcode.add(zipCodeVO);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			allQuit(conn,stmt,rs);
		}

		return zipcode;
	}

	public static void main(String[] args) {
		ZipcodeDao zipcodeDao = new ZipcodeDao();
		//List<ZipCodeVO> list = zipcodeDao.mybatisGetZipcodeList(10);
		//for (ZipCodeVO zipCodeVO : list) {
			//System.out.println(zipCodeVO.getUid_no());
		//}
		System.out.println(zipcodeDao.mybatisGetDate());
	}
	

	private void allQuit(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
}

