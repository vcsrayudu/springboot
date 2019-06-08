package com.travel.groups.model;

import java.util.List;
import java.util.Set;

public class User {
String userName;
String userId;
String password;
double paidExpences;
double owes;
Set<Transaction> transactions;
String groupName;
public Set<Transaction> getTransaction() {
	return transactions;
}
public void setTransaction(Set<Transaction> transactions) {
	this.transactions = transactions;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getPaidExpences() {
	return paidExpences;
}
public void setPaidExpences(double paidExpences) {
	this.paidExpences = paidExpences;
}
public double getOwes() {
	return owes;
}
public void setOwes(double owes) {
	this.owes = owes;
}


}
