package application;



public class Kayitlarlogin {
	
	private int ıd;
	private String userName;
	private String sifre;
	private String dancetype;
	//private int date;
	private String teacher;
	
	
	
	
	Kayitlarlogin(int ıd,String userName,String sifre,String dancetype,String teacher){
		 this.ıd=ıd;
		 this.userName=userName;
		 this.sifre=sifre;
		 this.dancetype=dancetype;
		 //this.date=date;
		 this.teacher=teacher;
		 
	 }




	public int getId() {
		return ıd;
	}




	public void setId(int id) {
		ıd = id;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getSifre() {
		return sifre;
	}




	public void setSifre(String sifre) {
		this.sifre = sifre;
	}




	public String getDancetype() {
		return dancetype;
	}




	public void setDancetype(String dancetype) {
		this.dancetype = dancetype;
	}




	public String getTeacher() {
		return teacher;
	}




	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


}