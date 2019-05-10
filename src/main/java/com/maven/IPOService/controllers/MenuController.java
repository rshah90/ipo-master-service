package com.maven.IPOService.controllers;

import com.maven.IPOService.model.Menu;
import com.maven.IPOService.model.User;
import com.maven.IPOService.model.UserResponse;
import com.maven.IPOService.service.MenuServiceImpl;
import com.maven.IPOService.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Book Controller is used for operations pertaining to User
 *
 */

@RestController
@Api(value="MenuCreation", description="Operations pertaining to User in Online Store")
public class MenuController {

    Logger logger = LoggerFactory.getLogger(MenuController.class);


    @Autowired
    private MenuServiceImpl menuService;


    @RequestMapping(value = "/get-menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Menu> GetMenu() {
        logger.info("inside GetMenu:");
        List<Menu>  tabs = menuService.findAllObject();
        return tabs;
    }




}
