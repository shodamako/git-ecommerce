package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.service.LoginUserService;

/**
 * ユーザーログイン用のコントローラークラス.
 * @author sho
 *
 */
@Controller
@Transactional
@RequestMapping(value="/loginUser")
@SessionAttributes("user")
public class LoginUserController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@ModelAttribute
	private LoginUserForm setUpForm(){
		return new LoginUserForm();
	}
	
	public String index(){
		return "loginUser";
	}
	
	public String login(@Validated LoginUserForm form, BindingResult result, RedirectAttributes redirectAttributes,
			@ModelAttribute("user")UserPage before, Model model){
		
		if(result.hasErrors()){
			FieldError error = new FieldError("emailError", "email", "");
			FieldError error2 = new FieldError("passwordError", "password", "");
			result.addError(error);
			result.addError(error2);
			return index();
		}
		
		String beforePage = before.getBeforePage();
		
		UserPage user = loginUserService.execute(form, result, model);
		
		if(user == null){
			ObjectError error = new ObjectError("loginError", "メールアドレスまたはパスワードが違います。");
			result.addError(error);
			return index();
		}
		
		model.addAttribute("user", user);
		redirectAttributes.addFlashAttribute("user", user);
		if(("/makePayment").equals(beforePage)){
			return "redirect:/makePayment/";
		}
		return "redirect:/serchItem/";
	}
	
}
