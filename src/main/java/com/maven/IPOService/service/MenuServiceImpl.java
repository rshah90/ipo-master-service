package com.maven.IPOService.service;

import com.maven.IPOService.model.Menu;
import com.maven.IPOService.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The UserServiceImpl is represented as Service layer for User operations
 */
@Service
public class MenuServiceImpl{

    @Autowired
    private MenuRepository menuRepository;

    public Menu saveObject(Menu menu){
        return menuRepository.save(menu);
    };


    public List<Menu> findAllObject(){
        return menuRepository.findAll();
    };


}

