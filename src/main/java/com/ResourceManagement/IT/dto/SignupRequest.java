package com.ResourceManagement.IT.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {


    private String name;
    private String username;
    private String password;
    private String email;
}
