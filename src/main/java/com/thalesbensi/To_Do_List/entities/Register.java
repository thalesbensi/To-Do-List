package com.thalesbensi.To_Do_List.entities;

import com.thalesbensi.To_Do_List.enums.UserRole;

import lombok.Data;

@Data
public class Register {

	private String login;
	private String password;
	private UserRole role;
}
