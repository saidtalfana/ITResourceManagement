package com.ResourceManagement.IT.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    USER,
    ADMIN,
    TECHNICIAN;

    @Override
    public String getAuthority() {
        return name();
    }
}
