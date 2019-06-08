package com.travel.groups.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;


import com.travel.groups.model.Group;
import com.travel.groups.model.GroupRepository;
import com.travel.groups.model.Transaction;


@Service("groupService")
public class GroupServiceImpl implements GroupService{
	@Autowired
	GroupRepository groupRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${transactionservice}")
	private String trxService;
	private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
	@Override
	public HashSet<String> getAllgroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getGroup(String groupLoginName) {
		// TODO Auto-generated method stub
		Set<Transaction> trxs=new HashSet<Transaction> (); 
		trxs =restTemplate.exchange("http://"+trxService+"/transaction/{groupLoginName}", HttpMethod.GET, null, new ParameterizedTypeReference<Set>() {}, groupLoginName).getBody();
		
		//trxs.addAll();
		logger.info("Retrieving group from db");
		Group group=groupRepository.findByGroupLoginName(groupLoginName);
		logger.info("Retrived group is "+group.getGroupName());
		if(group!=null)
		group.setTransactions(trxs);
		return group;
	}

	@Override
	public boolean createGroup(Group group) {
		// TODO Auto-generated method stub
		logger.info("Creating new Group with username: "+group.getGroupName());
		group=groupRepository.save(group);
		if(group!=null)
			return true;
		return false;
	
	}

	@Override
	public Group updateGroup(Group group, String groupName) {
		// TODO Auto-generated method stub
		 group=groupRepository.findByGroupLoginName(groupName);
		if(group!=null)
		{
			//TODO
		}
			
		return group;
	}

	@Override
	public Group deleteGroup(String groupName) {
		// TODO Auto-generated method stub
		Group group=groupRepository.findByGroupLoginName(groupName);
		groupRepository.delete(group);
		if(group!=null)
		{
			//TODO
		}
		return group;
	}
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
