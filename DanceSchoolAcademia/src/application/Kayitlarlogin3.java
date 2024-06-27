package application;


import java.util.Date;

public class Kayitlarlogin3 {
	
	private int ID;
	private String username;
	private String teachername;
	public int getID() {
		return ID;
	}






	public void setID(int iD) {
		ID = iD;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	public String getTeachername() {
		return teachername;
	}






	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}






	public String getDancetype() {
		return dancetype;
	}






	public void setDancetype(String dancetype) {
		this.dancetype = dancetype;
	}






	/*public Date getDate() {
		return date;
	}*/






	/*public void setDate(Date date) {
		this.date = date;
	}*/






	private String dancetype;
	//private Date date;
	

	

	
	
	Kayitlarlogin3(int ID,String username,String dancetype,String teachername){
		this.ID=ID;
		this.username=username;
		this.dancetype=dancetype;
		this.teachername=teachername;
		//this.date=date;
	}

}
