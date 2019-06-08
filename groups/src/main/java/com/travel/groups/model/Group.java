package com.travel.groups.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Group {
String groupName;
@Indexed(unique=true)
String groupLoginName;
public String getGroupLoginName() {
	return groupLoginName;
}
public void setGroupLoginName(String groupLoginName) {
	this.groupLoginName = groupLoginName;
}
@Id
String groupId;
String groupDescription;
double expectedExpence;
double actualExpence;
double owes;
Set<String> userList;
String password;
Set<Transaction> transactions;
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
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
public Set<String> getUserList() {
	return userList;
}
public void setUserList(Set<String> userList) {
	this.userList = userList;
}

}
