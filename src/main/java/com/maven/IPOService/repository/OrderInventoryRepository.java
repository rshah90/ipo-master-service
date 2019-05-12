package com.maven.IPOService.repository;

import com.maven.IPOService.model.AdminResponse;
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


    @Query(value = "SELECT * FROM ORDERS where ipo_id=?1", nativeQuery = true)
    List<OrderInventory> findbyIPO(String ipoId);

@Query(value ="select \n" +
        "new com.maven.IPOService.model.AdminResponse(buyer.clientName,SUM(buyer.Quantiy * buyer.Rate) ,SUM(seller.Quantiy * seller.Rate) ,(SUM(buyer.Quantiy * buyer.Rate) - SUM(seller.Quantiy * seller.Rate) ) ,SUM(buyer.Quantiy) - SUM(seller.Quantiy) )\n" +
        "from OrderInventory buyer , OrderInventory seller " +
        "where buyer.ipoId=?1 and seller.ipoId=buyer.ipoId and buyer.Mode =?2 and seller.Mode =?3 " +
        "GROUP BY buyer.clientName")
List<AdminResponse> findForAdmin(Long ipoId , String buy  , String Sell);

}
