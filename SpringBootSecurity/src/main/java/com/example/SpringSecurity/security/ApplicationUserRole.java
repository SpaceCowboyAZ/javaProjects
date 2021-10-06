package com.example.SpringSecurity.security;
import java.util.Set;
import static com.example.SpringSecurity.security.ApplicationUserPermission.*;
import com.google.common.collect.Sets;


public enum ApplicationUserRole {
STUDENT(Sets.newHashSet()),
ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));
	
	private final Set<ApplicationUserPermission> permission;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permission = permissions;
	}
	
	public Set<ApplicationUserPermission> getPermission() {
		return permission;
	}
}


