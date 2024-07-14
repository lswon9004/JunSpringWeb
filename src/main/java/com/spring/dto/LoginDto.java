package com.spring.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginDto {
	@NotNull(message = "id is null.")
	@NotEmpty(message = "id is empty.")
	private String userid;
	@NotNull(message = "password is null.")
	@NotEmpty(message = "password is empty.")
	private String password;

}
