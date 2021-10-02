package com.example.SpringSecurity.security;
import java.util.Set;
import static com.example.SpringSecurity.security.ApplicationUserPermission.*;
import com.google.common.collect.Sets;


public enum ApplicationUserRole {
STUDENT(Sets.newHashSet()),
ADMIN(Sets.newHashSet(COURSE_READ,
		COURSE_WRITE, STUDENT_READ, COURSE_WRITE));
	
	private final Set<ApplicationUserPermission> permission;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permisson) {
		this.permission = permission;
	}
	
	public Set<ApplicationUserPermission> getPermission() {
		return permission;
	}
}


