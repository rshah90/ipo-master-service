package com.maven.IPOService.service;

import com.maven.IPOService.controllers.OrderInventoryController;
import com.maven.IPOService.model.AdminResponse;
import com.maven.IPOService.model.IPO;
import com.maven.IPOService.model.OrderInventory;
import com.maven.IPOService.repository.IPORepository;
import com.maven.IPOService.repository.OrderInventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The UserServiceImpl is represented as Service layer for User operations
 */
@Service
public class OrderInventoryServiceImpl implements GenericService<OrderInventory> {
    Logger logger = LoggerFactory.getLogger(OrderInventoryServiceImpl.class);
    @Autowired
    private OrderInventoryRepository orderInventoryRepository;

    public OrderInventory getObjectById(long id){
        return orderInventoryRepository.getOne(id);
    };

    public Optional<OrderInventory> findObjectById(long id){
        return orderInventoryRepository.findById(id);
    };


    public List<OrderInventory> findAllObject(){
        return orderInventoryRepository.findAll();

    };

    public List<OrderInventory> findbyIds(String clientID , String ipoId){
        return orderInventoryRepository.findbyIds(clientID , ipoId);

    };

    public List<AdminResponse> findForAdmin(Long ipoId){
        List<AdminResponse> admin = orderInventoryRepository.findForAdmin( ipoId , "Buy" , "Sell");
        logger.info("admin"+admin.get(0).toString());
        return admin;
    };


    public List<OrderInventory> findbyIPO(String ipoId){
        return orderInventoryRepository.findbyIPO(ipoId);

    };

    public OrderInventory saveObject(OrderInventory orderInventory){
        return orderInventoryRepository.save(orderInventory);
    };

    public void deleteObject(Long id){
        orderInventoryRepository.deleteById(id);
    };



}

