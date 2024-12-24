package com.thalesbensi.To_Do_List.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.thalesbensi.To_Do_List.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	UserDetails findByLogin(String login); 
}
