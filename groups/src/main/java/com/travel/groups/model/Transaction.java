package com.travel.groups.model;

import java.util.Date;

public class Transaction {
String transId;
String groupId;
String userId;
Date date;
public String getTransId() {
	return transId;
}
public void setTransId(String transId) {
	this.transId = transId;
}
public String getGroupId() {
	return groupId;
}
public void setGroupId(String groupId) {
	this.groupId = groupId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getCause() {
	return cause;
}
public void setCause(String cause) {
	this.cause = cause;
}
public double getExpence() {
	return expence;
}
public void setExpence(double expence) {
	this.expence = expence;
}
String cause;
double expence;
}
