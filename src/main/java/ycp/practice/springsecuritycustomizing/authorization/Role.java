package ycp.practice.springsecuritycustomizing.authorization;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority, Serializable{
	private final String PREFIX = "ROLE_";
	private String roleName;
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		return PREFIX + roleName;
	}
}
