package com.ResourceManagement.IT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtDto {
   private Integer id;
   private String role;
    private String token;
}
