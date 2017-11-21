package model;

public class EmployBean {

	String firstName="";
	String lastName="";
	String startYear="";
	String payRate="";
	public EmployBean(){
		
	}
public EmployBean(String firstName,String lastName,String startYear,String payRate){
		this.firstName=firstName;
		this.lastName=lastName;
		this.startYear=startYear;
		this.payRate=payRate; 
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getPayRate() {
		return payRate;
	}
	public void setPayRate(String payRate) {
		this.payRate = payRate;
	}
	
}
