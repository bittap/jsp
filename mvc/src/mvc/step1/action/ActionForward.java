package mvc.step1.action;

public class ActionForward {
	//path���� ������������ ���� �̸��� �����ž�
	//doGet�� ����Ÿ���� void�� �� ������ �ѱ� �� ����.
	private String path = null;
	// ȭ�� �̵��� �� ���� ��尡 ������
	// �ϳ���  res.sendRedirect("XXX.jsp"); select�� ���� �� ��

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
