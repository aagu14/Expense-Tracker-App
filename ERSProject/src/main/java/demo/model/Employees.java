package demo.model;

public class Employees {

	private int emp_id;
	private String fullName;
	private String emp_role;
	private String emp_username;
	private String emp_password;

public Employees() {
	// TODO Auto-generated constructor stub
}

public Employees(int emp_id, String fullName, String emp_role, String emp_username, String emp_password) {
	super();
	this.emp_id = emp_id;
	this.fullName = fullName;
	this.emp_role = emp_role;
	this.emp_username = emp_username;
	this.emp_password = emp_password;
}

public int getEmp_id() {
	return emp_id;
}

public void setEmp_id(int emp_id) {
	this.emp_id = emp_id;
}

public String getFullName() {
	return fullName;
}

public void setFullName(String fullName) {
	this.fullName = fullName;
}

public String getEmp_role() {
	return emp_role;
}

public void setEmp_role(String emp_role) {
	this.emp_role = emp_role;
}

public String getEmp_username() {
	return emp_username;
}

public void setEmp_username(String emp_username) {
	this.emp_username = emp_username;
}

public String getEmp_password() {
	return emp_password;
}

public void setEmp_password(String emp_password) {
	this.emp_password = emp_password;
}

@Override
public String toString() {
	return "Employees [emp_id=" + emp_id + ", fullName=" + fullName + ", emp_role=" + emp_role + ", emp_username="
			+ emp_username + ", emp_password=" + emp_password + "]";
}


}
