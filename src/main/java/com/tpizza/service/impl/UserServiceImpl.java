package com.tpizza.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.User;
import com.tpizza.repository.UserRepository;
import com.tpizza.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<User> users = this.getUsers(email);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        User user = users.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public boolean addUser(User user, String role) {
        String encodedPassword = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(role);

        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public boolean updateUser(User user, String userUpdate) {
        User oldUser = this.getUsers(user.getEmail()).get(0);
        if(oldUser.getPassword().equals(user.getPassword())) {
            user.setId(oldUser.getId());
            return this.userRepository.updateUser(user, userUpdate);
        } else {
            String encodedPassword = this.passwordEncoder.encode(user.getPassword());
            user.setId(oldUser.getId());
            user.setPassword(encodedPassword);
            return this.userRepository.updateUser(user, userUpdate);
        }
    }
    
}
