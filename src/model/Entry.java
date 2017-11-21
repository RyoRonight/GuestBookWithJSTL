package model;

public class Entry {
private String name;
private String message;
public long id;
public Entry(){};
public Entry(long id,String name,String message){
	this.id=id;
	this.name=name;
	this.message=message;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}


}
