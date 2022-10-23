package com.tpizza.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tpizza.pojos.User;

public interface UserService extends UserDetailsService {
    boolean addUser(User user, String role);
    List<User> getUsers(String email);
    boolean updateUser(User user, String userUpdate);
}
