package com.tpizza.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Bill;
import com.tpizza.pojos.BillDetails;
import com.tpizza.pojos.Product;
import com.tpizza.pojos.User;
import com.tpizza.service.BillDetailsService;
import com.tpizza.service.ProductService;
import com.tpizza.service.StatisticService;
import com.tpizza.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> listTours() {
        try {
            return new ResponseEntity<>(this.userService.getUsers(""), HttpStatus.OK);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/register", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Boolean> addUser(@RequestBody Map<String, String> params){
        try {
            String email = params.get("email");
            String username = params.get("username");
            String password = params.get("password");
            String passwordConfirm = params.get("passwordConfirm");
            String role = params.get("role");
            if(!password.equals(passwordConfirm)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setUsername(username);
                user.setPassword(password);
                return new ResponseEntity<>(this.userService.addUser(user, role), HttpStatus.CREATED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(path="/update-user", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Boolean> updateUser(@RequestBody Map<String, String> params){
        try {
            String email = params.get("email");
            String username = params.get("username");
            String password = params.get("password");
            String phone = params.get("phone");
            String address = params.get("address");
            String role = params.get("role");
            
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAddress(address);
            user.setRole(role);
            
            return new ResponseEntity<>(this.userService.updateUser(user, email), HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Autowired
    private StatisticService statisticService;
    @Autowired
    private BillDetailsService billDetailsService;
    @Autowired
    private ProductService productService;

    @GetMapping("/statistic")
    public ResponseEntity<List<Map<String, Object>>> getStatistic() {
        try {
            return new ResponseEntity<>(this.statisticService.getTopProducts(3), HttpStatus.OK);  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
