package com.maven.IPOService.controllers;

import com.maven.IPOService.model.*;
import com.maven.IPOService.service.IPOServiceImpl;
import com.maven.IPOService.service.MenuServiceImpl;
import com.maven.IPOService.service.OrderInventoryServiceImpl;
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
@Api(value="ipo master", description="Operations pertaining to User in Online Store")
public class OrderInventoryController {

    Logger logger = LoggerFactory.getLogger(OrderInventoryController.class);

    @Autowired
    private OrderInventoryServiceImpl orderInventoryServiceImpl;

    @Autowired
    private MenuServiceImpl menuService;

    @Autowired
    private UserServiceImpl userService;

    // Add User api used to create the new User
    @ApiOperation(value = "Add a ipo")
    @RequestMapping(value = "/create-order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderInventory AddOrder(@RequestBody OrderInventory orderInventory) {
        logger.info("orderInventory:" + orderInventory.toString());
        User userObject = userService.getObjectById(orderInventory.getUserId());
        orderInventory.setClientName(userObject.getUsername());
        orderInventory.setTotal(orderInventory.getQuantiy() * orderInventory.getRate());
        OrderInventory DBOrderInventory = orderInventoryServiceImpl.saveObject(orderInventory);

        return DBOrderInventory;
    }


    @RequestMapping(value = "/get-orderInventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<OrderInventory> GetOrderInventory(@RequestParam("userId") String userId , @RequestParam("ipoId") String ipoId) {
        logger.info("inside GetOrderInventory:");
        List<OrderInventory> DBOrderInventory = orderInventoryServiceImpl.findbyIds(userId,ipoId);
        return DBOrderInventory;
    }


    @RequestMapping(value = "/delete-orderInventory", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public Long DeleteOrderInventory(@RequestParam("id") Long id) {
        logger.info("inside GetOrderInventory:");
        orderInventoryServiceImpl.deleteObject(id);
        return id;
    }


    @RequestMapping(value = "/update-orderInventory", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderInventory UpdateOrderInventory(@RequestBody OrderInventory orderInventory) {
        logger.info("inside UpdateOrderInventory:"+orderInventory.toString());
        OrderInventory DBOrderInventory = orderInventoryServiceImpl.saveObject(orderInventory);
        //menuService.saveObject(new Menu(orderInventory.getIssuerCompany(),"nb-star","/pages/forms/order",false))
        return DBOrderInventory;
    }

    @RequestMapping(value = "/get-orderInventory-byIPO", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
        public List<OrderInventory> GetOrderInventory( @RequestParam("ipoId") String ipoId) {
        logger.info("inside GetOrderInventory:");
        List<OrderInventory> DBOrderInventory = orderInventoryServiceImpl.findbyIPO(ipoId);

        return DBOrderInventory;
    }

    @RequestMapping(value = "/get-balanceReport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<AdminResponse> GetBalanceReport( @RequestParam("ipoId") Long ipoId) {
        logger.info("inside GetOrderInventory:");
        List<AdminResponse> DBOrderInventory = orderInventoryServiceImpl.findForAdmin(ipoId);

        return DBOrderInventory;
    }



}
