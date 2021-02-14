package common.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardVO {
	private int prevBtnPage;
	private int nextBtnPage;
	private Map<String, String> searchMap;
	private final int PAGENUM = 5; //pageNum = 왼쪽 오른쪽 안에 있는 page갯수
	private final int ITEMNUM = 10; //itemNum = 1페이지당 글 갯수
	private List<Integer> pageS = null;
	private int nowPage = 1;
	private String searchKind = "";
	private String searchString = "";
	
	
	public int getPAGENUM() {
		return PAGENUM;
	}

	public int getITEMNUM() {
		return ITEMNUM;
	}

	public int getPrevBtnPage() {
		return prevBtnPage;
	}

	public void setPrevBtnPage(int prevBtnPage) {
		this.prevBtnPage = prevBtnPage;
	}

	public int getNextBtnPage() {
		return nextBtnPage;
	}

	public void setNextBtnPage(int nextBtnPage) {
		this.nextBtnPage = nextBtnPage;
	}

	public List<Integer> getPageS() {
		return pageS;
	}

	public void setPageS(List<Integer> pageS) {
		this.pageS = pageS;
	}
	
	

	public String getSearchKind() {
		return searchKind;
	}

	public void setSearchKind(String searchKind) {
		this.searchKind = searchKind;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public Map<String, String> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, String> searchMap) {
		this.searchMap = searchMap;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	
	

	
	
	
	
	
}
