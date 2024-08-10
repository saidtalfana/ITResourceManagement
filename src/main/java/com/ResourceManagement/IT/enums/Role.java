package com.ResourceManagement.IT.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

 USER,
 ADMIN,
  TECHNICIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
