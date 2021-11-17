package com.spring.service;

import com.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
