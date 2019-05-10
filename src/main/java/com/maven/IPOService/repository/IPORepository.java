package com.maven.IPOService.repository;

import com.maven.IPOService.model.IPO;
import com.maven.IPOService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The UserRepository is used for CRUD operation for User table
 */
@Repository
public interface IPORepository extends JpaRepository<IPO,Long> {
}
