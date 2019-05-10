package com.maven.IPOService.service;

import com.maven.IPOService.model.User;
import com.maven.IPOService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The UserServiceImpl is represented as Service layer for User operations
 */
@Service
public class UserServiceImpl implements GenericService<User> {

    @Autowired
    private UserRepository userRepository;

    public User getObjectById(long id){
        return userRepository.getOne(id);
    };

    public Optional<User> findObjectById(long id){
        return userRepository.findById(id);
    };


    public List<User> findAllObject(){
        return userRepository.findAll();
    };

    public User saveObject(User user){
        return userRepository.save(user);
    };

    public void deleteObject(Long id){
         userRepository.deleteById(id);
    };



}

