package jp.co.sss.emanage.bean;

import java.io.Serializable;

public class PassBean implements Serializable {

private String empId;
private String oldPass;
private String newPass;
private String passCheck;
private String empPass;

public String getEmpPass() {
	return empPass;
}
public void setEmpPass(String oldPassCheck) {
	this.empPass = oldPassCheck;
}
public String getOldPass() {
	return oldPass;
}
public void setOldPass(String oldPass) {
	this.oldPass = oldPass;
}
public String getNewPass() {
	return newPass;
}
public void setNewPass(String newPass) {
	this.newPass = newPass;
}
public String getPassCheck() {
	return passCheck;
}
public void setPassCheck(String passCheck) {
	this.passCheck = passCheck;
}
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}

}
