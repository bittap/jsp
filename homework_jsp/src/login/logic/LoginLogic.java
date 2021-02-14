package login.logic;

import java.util.List;

import javax.websocket.Session;

import org.apache.log4j.Logger;

import common.vo.BoardVO;
import login.dao.LoginDAO;
import login.vo.LoginVO;
import zipcode.dao.ZipcodeDAO;
import zipcode.vo.ZipCodeVO;

public class LoginLogic {
	
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private LoginDAO dao = null;
	private LoginVO loginVO;
	
	public LoginLogic(LoginVO loginVO) {
		this.loginVO = loginVO;
		dao = new LoginDAO(loginVO);
	}
	
	
	/**
	  * @Method Name : login
	  * @작성일 : 2019. 12. 18.
	  * @작성자 : jmp17
	  * @변경이력 : 
	  * @Method 설명 :
	  * @return // 01 => 아이디 존재 x, 02 => 비밀번호 일치 x, 03 => 성공
	*/
	public String login() {
		return dao.login();
	}
	
	
	
	
}
