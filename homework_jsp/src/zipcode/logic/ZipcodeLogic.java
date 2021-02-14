package zipcode.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import common.vo.BoardVO;
import zipcode.dao.ZipcodeDAO;
import zipcode.vo.ZipCodeVO;

public class ZipcodeLogic {
	
	private Logger logger = Logger.getLogger(this.getClass().toString());
	private ZipcodeDAO dao = null;
	private BoardVO boardVO;
	
	public ZipcodeLogic(BoardVO boardVO) {
		this.boardVO = boardVO;
		dao = new ZipcodeDAO(boardVO);
	}
	
	public List<ZipCodeVO> select() {
		logger.info("select 함수호출");
		
		return dao.select();
	}
	
	public BoardVO getPaingBoardVO() {
		return dao.getPaingBoardVO();
	}

	public void delete(int num) {
		dao.delete(num);
	}

	public ZipCodeVO detail(int num) {
		return dao.detail(num);
	}

	public void update(ZipCodeVO zipCodeVO) {
		dao.update(zipCodeVO);
	}

	public void insert(ZipCodeVO zipCodeVO) {
		dao.insert(zipCodeVO);
	}

	

}
