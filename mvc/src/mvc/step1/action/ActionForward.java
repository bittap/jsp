package mvc.step1.action;

public class ActionForward {
	//path에는 응답페이지에 대한 이름을 담을거야
	//doGet은 리턴타입이 void라서 이 정보를 넘길 수 없다.
	private String path = null;
	// 화면 이동시 두 가지 모드가 가능함
	// 하나는  res.sendRedirect("XXX.jsp"); select할 때는 못 씀

	private boolean isRedirect = false;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
	
}
