package com.maven.IPOService.controllers;

import com.maven.IPOService.model.Children;
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
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
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
        List<Menu>  newTabs =  new ArrayList<Menu>();
        for(Menu tab : tabs){
            System.out.println("tab.getIcon()"+tab.getIcon());
                if(tab.getIcon().equalsIgnoreCase("nb-compose")){
                    List<Children>  newChildren =  new ArrayList<Children>();
                    Map map = new HashMap();
                    map.put("id",tab.getId().toString());
                    newChildren.add(new Children("Orders","/pages/forms/order",map));
                    newChildren.add(new Children("Customer Report","/pages/forms/clientReport",map));
                    newChildren.add(new Children("Admin Report","/pages/forms/order",map));
                    tab.setLink(null);
                    tab.setChildren(newChildren);
                    newTabs.add(tab);
                }else{
                    newTabs.add(tab);
                }
        }


        //children object for menu



        return newTabs;
    }




}
