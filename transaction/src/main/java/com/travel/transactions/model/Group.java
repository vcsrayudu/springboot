package com.travel.transactions.model;

import java.util.List;
import java.util.Set;

public class Group {
String groupName;
String groupId;
String groupDescription;
double expectedExpence;
double actualExpence;
double owes;
Set userList;
String groupAdmin;
Set<Transaction> transactions;
public String getGroupAdmin() {
	return groupAdmin;
}
public void setGroupAdmin(String groupAdmin) {
	this.groupAdmin = groupAdmin;
}
public Set<Transaction> getTransactions() {
	return transactions;
}
public void setTransactions(Set<Transaction> transactions) {
	this.transactions = transactions;
}
public String getGroupName() {
	return groupName;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}
public String getGroupDescription() {
	return groupDescription;
}
public void setGroupDescription(String groupDescription) {
	this.groupDescription = groupDescription;
}
public double getExpectedExpence() {
	return expectedExpence;
}
public void setExpectedExpence(double expectedExpence) {
	this.expectedExpence = expectedExpence;
}
public double getActualExpence() {
	return actualExpence;
}
public void setActualExpence(double actualExpence) {
	this.actualExpence = actualExpence;
}
public double getOwes() {
	return owes;
}
public void setOwes(double owes) {
	this.owes = owes;
}
public Set getUserList() {
	return userList;
}
public void setUserList(Set userList) {
	this.userList = userList;
}

}
