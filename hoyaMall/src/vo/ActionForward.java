package vo;

public class ActionForward {
	private String path;
	private boolean redirect;

	public ActionForward() {}
	// 매개변수 없이 인스턴스를 생성하기 위한 디폴트 생성자
	// 생성자 오버로딩으로 여러 형태의 인스턴스를 만들 수 있는 방법

	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() { // 저장된 path를 추출하는 메소드
		return path;
	}

	public void setPath(String path) { //setPath메소드를 통해서 path가 세팅이 된다. path를 저장시켜주는 메소드
		this.path = path;
	}

	public boolean isRedirect() { //redirect여부를 논리값으로 리턴하는 메소드
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
