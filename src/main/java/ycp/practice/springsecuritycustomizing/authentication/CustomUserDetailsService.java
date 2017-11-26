package ycp.practice.springsecuritycustomizing.authentication;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ycp.practice.springsecuritycustomizing.authorization.Role;

/*사용자 정보 조회 결과를 UserDetailsService에 담음
 - Strictly Speacking
UserDetailsService 에 담는 것이 아니라 비지니스 로직을 처리하는 일을 하고 UserDetails 라는 곳에 담는다.
기본적으로 계정 암호 권한룰 그외 몇가지만 설정되어 있어 필요에 따라 항목을 추가하면 된다.*/

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Override
	public CustomUserDetails loadUserByUsername(String gwid) throws UsernameNotFoundException {

		// 회원 정보 데이터를 읽어오는 구간(ex. from DB or API) 시작
		
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setGwid(gwid);
		customUserDetails.seteMail("ycp@naver.com");
		customUserDetails.setGrade("사원");

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Role role = new Role("USER");
		authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		customUserDetails.setAuthorities(authorities);

		// // 회원 정보 데이터를 읽어오는 구간(ex. from DB or API) 끝
		
		
		
		return customUserDetails;
	}
}
