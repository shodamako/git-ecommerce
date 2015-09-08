package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.example.domain.User;
import com.example.repository.LoginUserRepository;
import com.example.web.LoginUserForm;
import com.example.web.UserPage;

/**
 * ユーザーログイン用サービス
 * @author sho
 *
 */
@Service
public class LoginUserService {
	@Autowired
	private LoginUserRepository loginUserRepository;
	
	public UserPage execute(LoginUserForm form,
			BindingResult result,
			Model model){
		String email = form.getEmail();
		String password = form.getPassword();
		User user = loginUserRepository.findByMailAddress(email);
		if(user == null){
			return null;
		}else if (user.getPassword().equals(password)){
			UserPage page = new UserPage();
			
			page.setId(user.getId());
			page.setName(user.getName());
			page.setEmail(user.getEmail());
			page.setAddress(user.getAddress());
			page.setTelephone(user.getTelephone());
			
			return page;
		}else{
			return null;
		}
	}
}
