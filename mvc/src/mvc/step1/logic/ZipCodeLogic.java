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
	  * @작성일 : 2019. 12. 10.
	  * @작성자 : jmp17
	  * @변경이력 : 
	  * @Method 설명 :
	  * @param dong
	  * @return
	*/
	public List<ZipCodeVO> getZipCodeList(String dong){
		logger.info("getZipCodeList 호출 성공");
		
		List<ZipCodeVO> zipList = new ArrayList<ZipCodeVO>();
		ZipCodeVO zVO = new ZipCodeVO();
		zVO.setZipcode(11);
		zVO.setAddress("대구광역시 북구");
		ZipCodeVO zVO1 = new ZipCodeVO();
		zVO1.setZipcode(123);
		zVO1.setAddress("대구광역시 북구1");
		ZipCodeVO zVO2 = new ZipCodeVO();
		zVO2.setZipcode(124);
		zVO2.setAddress("대구광역시 북구2");
		
		zipList.add(zVO);
		zipList.add(zVO1);
		zipList.add(zVO2);
		
		return zipList;
	}
}