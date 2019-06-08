package com.travel.groups.controller;


import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.travel.groups.model.Group;
import com.travel.groups.services.GroupService;


@RestController
public class GroupController {
	@Autowired
	GroupService groupService;

	private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
	//DmtResponce dmtResponce = new DmtResponce();
	@RequestMapping(value = "/group")
	public ResponseEntity<Set> listAllGroups() {
		logger.info("Listing All groups");
		Set<String> groups=groupService.getAllgroups();
		return new ResponseEntity(groups, HttpStatus.OK);
}
	@RequestMapping(value = "/group/{groupLoginName}", method = RequestMethod.GET)
	public ResponseEntity<Group> getGroup(@PathVariable("groupLoginName") String groupLoginName) {
		logger.info("Listing specific group");
		Group group=groupService.getGroup(groupLoginName);
		return new ResponseEntity(group, HttpStatus.OK);
}
	
	@RequestMapping(value = "/group/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> createGroup(@RequestBody Group group) {
		logger.info("Creating a group with name : "+group.getGroupName());
		boolean  groupCreated=groupService.createGroup(group);
		return new ResponseEntity(groupCreated, HttpStatus.OK);
}
	@RequestMapping(value = "/group/{groupName}", method = RequestMethod.PUT)
	public ResponseEntity<Group> updateGroup(@PathVariable("groupName") String groupName, @RequestBody Group group) {
		logger.info("Updating a group  : "+group.getGroupName());
		Group  upgroup=groupService.updateGroup(group,groupName);
		return new ResponseEntity(upgroup, HttpStatus.OK);
}
	@RequestMapping(value = "/group/{groupName}", method = RequestMethod.DELETE)
	public ResponseEntity<Group> deleteGroup(@PathVariable("groupName") String groupName) {
		logger.info("Deleting a group: "+groupName);
		Group  upgroup=groupService.deleteGroup(groupName);
		return new ResponseEntity(upgroup, HttpStatus.OK);
}
}


