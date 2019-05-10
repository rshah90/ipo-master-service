package com.maven.IPOService.service;

import com.maven.IPOService.model.IPO;
import com.maven.IPOService.model.User;
import com.maven.IPOService.repository.IPORepository;
import com.maven.IPOService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The UserServiceImpl is represented as Service layer for User operations
 */
@Service
public class IPOServiceImpl implements GenericService<IPO> {

    @Autowired
    private IPORepository ipoRepository;

    public IPO getObjectById(long id){
        return ipoRepository.getOne(id);
    };

    public Optional<IPO> findObjectById(long id){
        return ipoRepository.findById(id);
    };


    public List<IPO> findAllObject(){
        return ipoRepository.findAll();
    };

    public IPO saveObject(IPO ipo){
        return ipoRepository.save(ipo);
    };

    public void deleteObject(Long id){
         ipoRepository.deleteById(id);
    };



}

