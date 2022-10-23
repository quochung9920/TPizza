package com.tpizza.configs.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.tpizza.pojos.User;
import com.tpizza.service.UserService;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userDetailService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        User user = this.userDetailService.getUsers(authentication.getName()).get(0);
        

        if(user.getRole().equals(User.ADMIN) || user.getRole().equals(User.STAFF)) {
            response.sendRedirect("/tpizza/admin/");
        } else {
            response.sendRedirect("/tpizza");
        }
        
        
        
    }
    
}
