package com.tpizza.repository;

import java.util.List;

import com.tpizza.pojos.User;

public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String email);
    boolean updateUser(User user, String userUpdate);
}
