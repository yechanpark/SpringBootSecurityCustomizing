package ycp.practice.springsecuritycustomizing.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//접속자가 입력한 계정과 암호를 사용자 정보의 계정과 암호를 비교하여 일치 한다면 사용자 정보를 사용할 수 있게 허가하는 역할
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	/**
	 * @param authentication
	 *            유저가 로그인 시도를 하기 위해 입력한 정보(Id값(username) -> gwid)
	 * 
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(authentication.getName());

		/**
		 * @param Principal
		 *            Object를 넘기면 UserDetails Object를 리턴하므로 캐스팅 가능 String을 넘기면 String을
		 *            리턴하므로 캐스팅 불가능
		 */
		return new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}

}
