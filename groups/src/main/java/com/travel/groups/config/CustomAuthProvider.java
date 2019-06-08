/*
 * Copyright (c) 2017. Open Text Corporation. All Rights Reserved.
 */

package com.travel.groups.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.travel.groups.model.Group;
import com.travel.groups.model.GroupRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomAuthProvider  implements AuthenticationProvider {
    private boolean supportClientToken = false;
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthProvider.class);
   
    @Autowired
	GroupRepository groupRepository;
    private static final int SECOND = 1000;
    private static final int MINUTE = 60;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       
    	AbstractAuthenticationToken authToken=null;
        
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        Group group=groupRepository.findByGroupLoginName(username);
        logger.error("Group : "+group);
	     if(username==null || username.equals("")||password==null || password.equals("")|| group==null)
	     {
	    	 logger.error("User/Password is empty");
	    	 return null;
	     }
	     
       
        try {
         
          
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
          
            if (group.getPassword().equals(password))
			{
				grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				logger.info("Granting Admin: "+username+" password : "+password);
			}
            else
            {
            	logger.error("Credentials are invalid");
            	return null;
            }
			
            
             authToken = new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    grantedAuths
            );
            
            
            logger.info("authToken created");
          
            return authToken;
        } catch (Exception e) {
        	logger.error("Exception while validating credentials: "+ e);
            
        }
        return authToken;
        
    }
   
    @Override
    public boolean supports(Class<?> authClass) {
        return UsernamePasswordAuthenticationToken.class.equals(authClass);
    }
    
}
