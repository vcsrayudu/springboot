package com.travel.groups.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface GroupRepository extends MongoRepository<Group, String> {
	
	
	  //public User findByDeparture(String departure);
	  public Group findByGroupLoginName(String gloginName);

	

}
