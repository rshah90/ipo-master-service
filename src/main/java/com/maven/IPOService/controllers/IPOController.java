package com.maven.IPOService.controllers;

import com.maven.IPOService.model.*;
import com.maven.IPOService.service.IPOServiceImpl;
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
import java.util.Optional;

/**
 * The Book Controller is used for operations pertaining to User
 *
 */

@RestController
@Api(value="ipo master", description="Operations pertaining to User in Online Store")
public class IPOController {

    Logger logger = LoggerFactory.getLogger(IPOController.class);

    @Autowired
    private IPOServiceImpl ipoService;

    @Autowired
    private MenuServiceImpl menuService;


    // Add User api used to create the new User
    @ApiOperation(value = "Add a ipo")
    @RequestMapping(value = "/create-ipo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public IPO AddUser(@RequestBody IPO ipo) {
        logger.info("ipo:" + ipo.toString());
        ipo.setStatus("Active");
        Menu newMenu = new Menu();
        newMenu.setTitle(ipo.getIssuerCompany());
        newMenu.setIcon("nb-compose");
        newMenu.setLink("/pages/forms/order");
        newMenu.setHome(false);



        ipo.setMenu(newMenu);


        IPO DBIPO = ipoService.saveObject(ipo);

        return DBIPO;
    }


    @RequestMapping(value = "/get-ipo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<IPO> GetIPO() {
        logger.info("inside GetIPO:");
        List<IPO> DBIPO = ipoService.findAllObject();
        return DBIPO;
    }


    @RequestMapping(value = "/delete-ipo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public Long DeleteIPO(@RequestParam("id") Long id) {
        logger.info("inside GetIPO:");
         ipoService.deleteObject(id);
        return id;
    }


    @RequestMapping(value = "/update-ipo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public IPO UpdateIPO(@RequestBody IPO ipo) {
        logger.info("inside UpdateIPO:"+ipo.toString());
        logger.info("ipo.getStatus():" + ipo.getStatus());
        if(ipo.getStatus().equalsIgnoreCase("DeActivated")){

            IPO ipoDetails = ipoService.getObjectById(ipo.getId());
            logger.info("ipo.():" + ipoDetails.getMenu().getId());
            Long ipoId = ipoDetails.getMenu().getId();
            ipoDetails.setMenu(null);
            IPO DBIPO = ipoService.saveObject(ipo);
            menuService.deleteObject(ipoId);
            return DBIPO;

        }else {

            IPO DBIPO = ipoService.saveObject(ipo);
            return DBIPO;
        }
        //menuService.saveObject(new Menu(ipo.getIssuerCompany(),"nb-star","/pages/forms/order",false))

    }


}
