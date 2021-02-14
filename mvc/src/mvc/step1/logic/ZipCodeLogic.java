package mvc.step1.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import mvc.step1.dao.ZipcodeDao;
import mvc.step1.vo.ZipCodeVO;

public class ZipCodeLogic {
	Logger logger = Logger.getLogger(this.getClass().toString());
	ZipcodeDao zcDAO = new ZipcodeDao();
	
	/**
	  * @Method Name : getZipCodeList
	  * @�ۼ��� : 2019. 12. 10.
	  * @�ۼ��� : jmp17
	  * @�����̷� : 
	  * @Method ���� :
	  * @param dong
	  * @return
	*/
	public List<ZipCodeVO> getZipCodeList(String dong){
		logger.info("getZipCodeList ȣ�� ����");
		
		List<ZipCodeVO> zipList = new ArrayList<ZipCodeVO>();
		ZipCodeVO zVO = new ZipCodeVO();
		zVO.setZipcode(11);
		zVO.setAddress("�뱸������ �ϱ�");
		ZipCodeVO zVO1 = new ZipCodeVO();
		zVO1.setZipcode(123);
		zVO1.setAddress("�뱸������ �ϱ�1");
		ZipCodeVO zVO2 = new ZipCodeVO();
		zVO2.setZipcode(124);
		zVO2.setAddress("�뱸������ �ϱ�2");
		
		zipList.add(zVO);
		zipList.add(zVO1);
		zipList.add(zVO2);
		
		return zipList;
	}
}