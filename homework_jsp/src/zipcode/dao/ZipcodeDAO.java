package zipcode.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import common.vo.BoardVO;
import dao.ConnDAO;
import zipcode.vo.ZipCodeVO;

public class ZipcodeDAO extends ConnDAO {

	Logger logger = Logger.getLogger(this.getClass().toString());
	BoardVO boardVO = null;
	
	public ZipcodeDAO(BoardVO boardVO) {
		this.boardVO = boardVO;
	}

	public List<ZipCodeVO> select() {
		logger.info("select 함수호출");

		SqlSession sqlSession = conn();
		List<ZipCodeVO> zipCodeVOs = sqlSession.selectList("zipdoeList", boardVO);
		sqlSession.close();
		
		return zipCodeVOs;
	}
	
	private String getQuery(String mapperId, Object object) {
		String sql = conn().getConfiguration().getMappedStatement(mapperId).getBoundSql(object).getSql();
		
		return sql;
	}
	
	private int getAllPageNumber() {
		SqlSession sqlSession = conn();
		int allPage = sqlSession.selectOne("count", boardVO);
		sqlSession.close();
		
		return allPage;
	}
	
	public BoardVO getPaingBoardVO() {
		int allPage = getAllPageNumber();
		
		boardVO.setPrevBtnPage(getPrevBtnPage());
		boardVO.setNextBtnPage(getNextBtnPage(allPage));
		boardVO.setPageS(pageS(allPage));
		
		return boardVO;
	}

	private int getPrevBtnPage() {
		int prevResult = 0;
		
		int mok = (int) Math.ceil((double)boardVO.getNowPage()/boardVO.getPAGENUM());
		
		if(mok == 1) prevResult = 0;
		else prevResult = (mok-2)*boardVO.getPAGENUM()+1;

		return prevResult;
	}

	private int getNextBtnPage(int allPage) {
		int nextResult = 0;
		
		int mok = (int) Math.ceil((double)boardVO.getNowPage()/boardVO.getPAGENUM());
		
		nextResult = (mok)*boardVO.getPAGENUM()+1;
		if(nextResult > allPage) nextResult = 0;
		
		return nextResult;
	}

	private List<Integer> pageS(int allPage) {

		List<Integer> list = new ArrayList<Integer>();
		
		int mok = (int) Math.ceil((double)boardVO.getNowPage()/boardVO.getPAGENUM());
		
		int start = ((mok-1)*boardVO.getPAGENUM())+1;
		for (int i = start; i <= start+boardVO.getPAGENUM()-1; i++) {
			if(i > allPage) break;
			list.add(i);
		}
		return list;
	}
	
	public static void main(String[] args) {
		ZipcodeDAO zipcodeDAO =new ZipcodeDAO(new BoardVO());
		/*
		BoardVO vo = zipcodeDAO.getPaingBoardVO();
		System.out.println("이전 페이지 = " + vo.getPrevBtnPage());
		System.out.println("다음 페이지 = " + vo.getNextBtnPage());
		for (int iterable_element : vo.getPageS()) {
			System.out.println("페이지s"+iterable_element);
		}
		*/
		zipcodeDAO.detail(52);
	}

	public void delete(int num) {
		SqlSession sqlSession = conn();
		sqlSession.delete("zipcode.mybatis.zipcode.delete",num);
		sqlSession.commit();
		sqlSession.close();
	}

	public ZipCodeVO detail(int num) {
		SqlSession sqlSession = conn();
		return sqlSession.selectOne("zipcode.mybatis.zipcode.zipcode",num);
	}

	public void update(ZipCodeVO zipCodeVO) {
		SqlSession sqlSession = conn();
		sqlSession.update("zipcode.mybatis.zipcode.update",zipCodeVO);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void insert(ZipCodeVO zipCodeVO) {
		SqlSession sqlSession = conn();
		sqlSession.update("zipcode.mybatis.zipcode.insert",zipCodeVO);
		sqlSession.commit();
		sqlSession.close();
	}

}
