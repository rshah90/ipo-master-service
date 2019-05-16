package com.maven.IPOService.controllers;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
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
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Book Controller is used for operations pertaining to User
 */

@RestController
@Api(value = "ipo master", description = "Operations pertaining to User in Online Store")
public class OrderInventoryController {

    private static final String dateFormat = "yyyy-MM-dd";
    private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat(dateTimeFormat);
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
          //  builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
        };
    }

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
    public List<OrderInventory> GetOrderInventory(@RequestParam("userId") String userId, @RequestParam("ipoId") String ipoId) {
        logger.info("inside GetOrderInventory:");
        List<OrderInventory> DBOrderInventory = orderInventoryServiceImpl.findbyIds(userId, ipoId);
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
        logger.info("inside UpdateOrderInventory:" + orderInventory.toString());
        OrderInventory DBOrderInventory = orderInventoryServiceImpl.saveObject(orderInventory);
        //menuService.saveObject(new Menu(orderInventory.getIssuerCompany(),"nb-star","/pages/forms/order",false))
        return DBOrderInventory;
    }

    @RequestMapping(value = "/get-orderInventory-byIPO", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<OrderInventory> GetOrderInventory(@RequestParam("ipoId") String ipoId) {
        logger.info("inside GetOrderInventory:");
        List<OrderInventory> DBOrderInventory = orderInventoryServiceImpl.findbyIPO(ipoId);

        return DBOrderInventory;
    }

    @RequestMapping(value = "/get-balanceReport", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<BalanceReportResponse> GetBalanceReport(@RequestParam("ipoId") Long ipoId) {
        logger.info("inside balanceReport:");
        List<AdminResponse> DBOrderInventory = orderInventoryServiceImpl.findForAdmin(ipoId);
        List<BalanceReportResponse> finalDBOrderInventory = new ArrayList<BalanceReportResponse>();
        Map<String, CustomerDateResponse> DBMap = new HashMap<String, CustomerDateResponse>();
        long sum = 0;
        for (AdminResponse dBOrderInventory : DBOrderInventory) {
            logger.info("dBOrderInventory:"+dBOrderInventory.toString());
            if (DBMap.containsKey(dBOrderInventory.getClientName())) {
                CustomerDateResponse newObj = DBMap.get(dBOrderInventory.getClientName());
                if (dBOrderInventory.getMode().trim().equalsIgnoreCase("Buy")) {
                    logger.info("dBOrderInventory 2");
                    newObj.setBuyerAmount(dBOrderInventory.getAmount());
                    newObj.setBuyerQuantity(dBOrderInventory.getQuantity());

                    DBMap.put(dBOrderInventory.getClientName(), newObj);
                } else {
                    logger.info("dBOrderInventory 3");
                    newObj.setSellerAmount(dBOrderInventory.getAmount());
                    newObj.setSellerQuantity(dBOrderInventory.getQuantity());

                    DBMap.put(dBOrderInventory.getClientName(), newObj);

                }

            } else {
                logger.info("dBOrderInventory:"+dBOrderInventory.getMode());
                if (dBOrderInventory.getMode().trim().equalsIgnoreCase("Buy")) {
                    logger.info("dBOrderInventory 1"+dBOrderInventory.toString());
                    DBMap.put(dBOrderInventory.getClientName(), new CustomerDateResponse(dBOrderInventory.getClientName(), dBOrderInventory.getAmount(), sum, dBOrderInventory.getQuantity(), sum));
                } else {
                    DBMap.put(dBOrderInventory.getClientName(), new CustomerDateResponse(dBOrderInventory.getClientName(), sum, dBOrderInventory.getAmount(), sum ,dBOrderInventory.getQuantity()));

                }
            }
        }

        List<CustomerDateResponse> dBOrderInventory = new ArrayList<CustomerDateResponse>(DBMap.values());
        for (CustomerDateResponse orderInventory :dBOrderInventory) {
            logger.info("dBOrderInventory 4"+orderInventory.toString());
            BalanceReportResponse balance = new BalanceReportResponse(orderInventory.getClientName(),orderInventory.getBuyerAmount(),orderInventory.getSellerAmount(),
                    orderInventory.getSellerAmount()-orderInventory.getBuyerAmount(),orderInventory.getBuyerQuantity()-orderInventory.getSellerQuantity());
            finalDBOrderInventory.add(balance);
        }


        logger.info("inside DBOrderInventory:" + finalDBOrderInventory);
        return finalDBOrderInventory;
    }


}
