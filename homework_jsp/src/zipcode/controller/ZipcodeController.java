package zipcode.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import common.vo.BoardVO;
import controller.AbstractAction;
import controller.Action;
import controller.ActionForward;
import zipcode.logic.ZipcodeLogic;
import zipcode.vo.ZipCodeVO;

public class ZipcodeController extends AbstractAction {
	Logger logger = Logger.getLogger(this.getClass().toString());
	
	@Override
	public ActionForward actionFerformd(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("ZipcodeController 시작");
		ActionForward actionForward = new ActionForward();
		
		// list.do 일경우 => list
		String path = getExtensionExceptPath(req);
		BoardVO boardVO = boardSetting(req);
		ZipcodeLogic zipcodeLogic = new ZipcodeLogic(boardVO);
		
		logger.info("path = "+path);
		switch (path) {
		case "list":
			actionForward.setPath("list");
			actionForward.setRedirect(false);
			
			req.setAttribute("list", zipcodeLogic.select());
			req.setAttribute("board", zipcodeLogic.getPaingBoardVO());
			break;
		case "delete":
			actionForward.setPath("action?type=delete&page="+boardVO.getNowPage()+"&searchKind="+boardVO.getSearchKind()+"&search="+boardVO.getSearchString());
			actionForward.setRedirect(true);
			
			zipcodeLogic.delete(Integer.parseInt(req.getParameter("num")));
			break;
		case "modify":
			actionForward.setPath("detail?num="+req.getParameter("num")+"&page="+boardVO.getNowPage()+"&searchKind="+boardVO.getSearchKind()+"&search="+boardVO.getSearchString());
			actionForward.setRedirect(false);
			
			req.setAttribute("result", zipcodeLogic.detail(Integer.parseInt(req.getParameter("num"))));
			req.setAttribute("path", path);
			break;	
		case "detail_action":
			String type = req.getParameter("type");
			
			actionForward.setPath("action?type="+type+"&page="+boardVO.getNowPage()+"&searchKind="+boardVO.getSearchKind()+"&search="+boardVO.getSearchString());
			actionForward.setRedirect(true);
			
			ZipCodeVO zipCodeVO = new ZipCodeVO();
			zipCodeVO.setZipcode(Integer.parseInt(req.getParameter("zipcode")));
			zipCodeVO.setAddress(req.getParameter("address"));
			if(type.equals("modify")) 
			{
				zipCodeVO.setUid_no(Integer.parseInt(req.getParameter("uid_no")));
				zipcodeLogic.update(zipCodeVO);
			}
			else
			{
				zipcodeLogic.insert(zipCodeVO);
			}

			break;	
		case "write":
			actionForward.setPath("detail");
			actionForward.setRedirect(false);
			
			req.setAttribute("result", new ZipCodeVO());
			req.setAttribute("path", path);
			break;	
		case "detail":
			actionForward.setPath("detail?num="+req.getParameter("num")+"&page="+boardVO.getNowPage()+"&searchKind="+boardVO.getSearchKind()+"&search="+boardVO.getSearchString());
			actionForward.setRedirect(false);
			
			req.setAttribute("result", zipcodeLogic.detail(Integer.parseInt(req.getParameter("num"))));
			req.setAttribute("path", path);
			break;	
			

		default:
			break;
		}
		return actionForward;
	}
	
	private BoardVO boardSetting(HttpServletRequest req) {
		BoardVO boardVO = new BoardVO();
		
		Map<String, String> searchMap = new LinkedHashMap<String, String>();
		searchMap.put("", "전체");
		searchMap.put("uid_no", "번호");
		searchMap.put("zipcode", "우편번호");
		searchMap.put("address", "주소");
		boardVO.setSearchMap(searchMap);
		boardVO.setSearchKind(req.getParameter("searchKind"));
		boardVO.setSearchString(req.getParameter("search"));
		Map<String,String[]> map = req.getParameterMap();
		
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String[] value = map.get(key);
			
			System.out.println("key: " + key);
			for (String string : value) {
				System.out.println("value: " + string);
			}
		}
		if(req.getParameter("page") != null) boardVO.setNowPage(Integer.valueOf(req.getParameter("page")));
		
		return boardVO;
	}
	
}
