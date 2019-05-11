package com.maven.IPOService.repository;

import com.maven.IPOService.model.IPO;
import com.maven.IPOService.model.OrderInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The UserRepository is used for CRUD operation for User table
 */
@Repository
public interface OrderInventoryRepository extends JpaRepository<OrderInventory,Long> {

    @Query(value = "SELECT * FROM ORDERS where user_id=?1 and ipo_id=?2", nativeQuery = true)
    List<OrderInventory> findbyIds(String clientId , String ipoId);
}
