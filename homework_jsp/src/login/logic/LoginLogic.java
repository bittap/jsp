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
	  * @�ۼ��� : 2019. 12. 18.
	  * @�ۼ��� : jmp17
	  * @�����̷� : 
	  * @Method ���� :
	  * @return // 01 => ���̵� ���� x, 02 => ��й�ȣ ��ġ x, 03 => ����
	*/
	public String login() {
		return dao.login();
	}
	
	
	
	
}
