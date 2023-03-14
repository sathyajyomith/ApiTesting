package com.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pojoaddemployee {

	
@JsonProperty("name")
private String name1;
@JsonProperty("salary")
private String salary1;
@JsonProperty("age")
private String age1;
@JsonProperty("id")
private String id1;

public String getId1() {
	return id1;
}
public void setId1(String id1) {
	this.id1 = id1;
}
public String getName1() {
	return name1;
}
public void setName1(String name1) {
	this.name1 = name1;
}
public String getSalary1() {
	return salary1;
}
public void setSalary1(String salary1) {
	this.salary1 = salary1;
}
public String getAge1() {
	return age1;
}
public void setAge1(String age1) {
	this.age1 = age1;
}

}
