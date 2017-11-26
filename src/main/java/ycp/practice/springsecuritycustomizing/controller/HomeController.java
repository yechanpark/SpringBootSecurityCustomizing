package ycp.practice.springsecuritycustomizing.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ycp.practice.springsecuritycustomizing.authentication.CustomUserDetails;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String hello(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// AuthenticationProvider# authenticate()에서 return하는 UsernamePasswordAuthenticationToken의 첫 번째 인자(Object Principal)일 경우 다음과 같은 Exception이 발생한다.
		// java.lang.ClassCastException
		// : java.base/java.lang.String cannot be cast to com.example.demo.auth.CustomUserDetails
		CustomUserDetails details = (CustomUserDetails)authentication.getPrincipal();
		
		System.out.println("그룹웨어id : " + details.getUsername());
		System.out.println("직책 : " + details.getGrade());
		System.out.println("이메일 : " + details.geteMail());
		System.out.println("권한 : " + details.getAuthorities().toString());	
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			// AuthenticationProvider에서 UsernamePasswordAuthenticationToken에  CustomUserDetails객체를 넣는경우 
			String username = ((CustomUserDetails)principal).getUsername();
		} else {
			// AuthenticationProvider에서 UsernamePasswordAuthenticationToken생성자의 첫번째 인자(Object Principal)로  String값(유저 Id)을 넣는경우 
			String username = principal.toString();
		}
		
		return "hello";
	}
}
