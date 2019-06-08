package com.travel.groups.services;

import java.util.ArrayList;
import java.util.Set;

import com.travel.groups.model.Group;

public interface GroupService {

	public Set<String> getAllgroups();
	public Group getGroup(String groupLoginName);
	public boolean createGroup(Group group);
	public Group updateGroup(Group group,String groupLoginName);
	public Group deleteGroup(String groupLoginName);
	
	
}
