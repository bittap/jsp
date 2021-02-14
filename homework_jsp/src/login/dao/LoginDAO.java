package login.dao;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import common.vo.BoardVO;
import dao.ConnDAO;
import login.vo.LoginVO;
import zipcode.vo.ZipCodeVO;

public class LoginDAO extends ConnDAO {

	Logger logger = Logger.getLogger(this.getClass().toString());
	LoginVO loginVO = null;
	
	public LoginDAO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

	private String getQuery(String mapperId, Object object) {
		String sql = conn().getConfiguration().getMappedStatement(mapperId).getBoundSql(object).getSql();
		
		return sql;
	}
	
	public static void main(String[] args) {
		
	}

	public String login() {
		SqlSession sqlSession = conn();
		
		if((int)sqlSession.selectOne("login.mybatis.login.idExist", loginVO) < 1)
		{
			// 아이디 불일치
			return "01";
		}
		else
		{
			// 비번 불일치
			if((int)sqlSession.selectOne("login.mybatis.login.login", loginVO) < 1) return "02";
			// 성공
			else return "03";
		}
	}

}
