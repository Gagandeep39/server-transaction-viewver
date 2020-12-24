package com.gagan.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

  private static final long serialVersionUID = 5926468583005150707L;
	
	private Integer userId;
	private String password;
  
}
