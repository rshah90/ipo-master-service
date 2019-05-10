package com.maven.IPOService.controllers;

import com.maven.IPOService.model.*;
import com.maven.IPOService.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * The Book Controller is used for operations pertaining to User
 *
 */

@RestController
@Api(value="onlinestore", description="Operations pertaining to User in Online Store")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    // Add User api used to create the new User
    @ApiOperation(value = "Add a User")
    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public UserResponse AddUser(@RequestBody User user) {
        logger.info("user:" + user.toString());
        User DBUser = userService.saveObject(user);
        return new UserResponse(DBUser.getId(),DBUser.getUsername(),DBUser.getEmail(),DBUser.getPhonenumber());
    }


    @RequestMapping(value = "/get-user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> GetUser() {
        logger.info("inside GetUser:");
        List<User> DBUser = userService.findAllObject();
        return DBUser;
    }


    @RequestMapping(value = "/delete-user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public Long DeleteUser(@RequestParam("id") Long id) {
        logger.info("inside GetUser:");
         userService.deleteObject(id);
        return id;
    }


    @RequestMapping(value = "/update-user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public UserResponse UpdateUser(@RequestBody User user) {
        logger.info("inside UpdateUser:"+user.toString());
        User DBUser = userService.saveObject(user);
        return new UserResponse(DBUser.getId(),DBUser.getUsername(),DBUser.getEmail(),DBUser.getPhonenumber());
    }


}
