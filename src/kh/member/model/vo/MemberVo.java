package kh.member.model.vo;

/**
 * @author uzin
 * TEST_MEMBER 테이블을 이용하여
 * 0. 첫화면("/")-index.jsp include header.jsp - 로그인(login Get),로그아웃(logout Get) 버튼 토글, nav에 내정보보기(myinfo get)버튼만듦
 * 회원가입("/enroll") - 로그인화면 하단에 회원가입 버튼
 * 로그인 화면 - 로그인(login post) / 회원가입(enroll get) 버튼
 * 회원가입("/enroll") - 로그인화면 하단에 회원가입 버튼 get emroll.jsp, post 회원가입 DB 다녀와서 첫 이동
 * 회원가입화면 - 회원가입(enroll POST) 버튼클릭
 * 2. 로그인("/login") -  Get login.jsp , Post 로그인확인 DB다녀와서 session("lgnss")등록(이름, email, id) 첫 화면 이동
 * 3. 로그아웃("/logout") - Get 세션만료후 / 첫 이동
 * 4. 내정보보기("/myinfo") - get myinfo.jsp
   내정보보기 화면에서 하단에 수정(. 탈퇴버튼
 * 5. 내정보수정하기("/infoupdate")
 * 내정보보기 수정 화면에서 수정( infoupdate post)
 * 6.
 * 
 * */


public class MemberVo {
	
	private String id;
	private String name;
	private String passwd;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + "]";
	}

	
	
	
	

}
