package application;



public class Kayitlarlogin2 {
	
	private int id;
	private String teachername;
	private String password;
	private String expert;
	
	 Kayitlarlogin2(int id,String teachername,String password,String expert) {
		 this.id=id;
		 this.teachername=teachername;
		 this.password=password;
		 this.expert=expert;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getExpert() {
		return expert;
	}

	public void setExpert(String expert) {
		this.expert = expert;
	}

}
