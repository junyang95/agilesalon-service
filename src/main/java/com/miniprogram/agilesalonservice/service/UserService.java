package com.miniprogram.agilesalonservice.service;

import com.miniprogram.agilesalonservice.entity.User;
import com.miniprogram.agilesalonservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public Optional<User> getUserByOpenId(String openId) {
        return this.userRepo.findById(openId);
    }
}
