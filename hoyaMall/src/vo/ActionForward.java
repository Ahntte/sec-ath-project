package vo;

public class ActionForward {
	private String path;
	private boolean redirect;

	public ActionForward() {}
	// �Ű����� ���� �ν��Ͻ��� �����ϱ� ���� ����Ʈ ������
	// ������ �����ε����� ���� ������ �ν��Ͻ��� ���� �� �ִ� ���

	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() { // ����� path�� �����ϴ� �޼ҵ�
		return path;
	}

	public void setPath(String path) { //setPath�޼ҵ带 ���ؼ� path�� ������ �ȴ�. path�� ��������ִ� �޼ҵ�
		this.path = path;
	}

	public boolean isRedirect() { //redirect���θ� �������� �����ϴ� �޼ҵ�
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
