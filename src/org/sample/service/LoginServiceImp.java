package org.sample.service;

import org.sample.dao.LoginDao;
import org.sample.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService{
	
	@Autowired
	LoginDao loginDao;

	@Override
	public boolean validateCredentials(String uname, String pwd) {

		System.out.println("#############Inside Validate Credentials###########");
		System.out.println("Entered User name:"+uname+"\n Entered Password"+pwd);
		User user=loginDao.getUser(uname);
		if(user!=null){
			System.out.println("#########User Not NUll#######");
			String username=user.getUsername();
			String password=user.getPassword();
			if(username.equalsIgnoreCase(uname)&&password.equalsIgnoreCase(pwd)){
				System.out.println("USER DETAILS MATCHED");
			return true;	
			}
			else{
			
			return false;
			}
		}
		else{
			System.out.println("##########user Not Available#######");
			
			return false;
		}
		}
	}
	


