package com.maven.IPOService.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * User class is used to map book object to relational model.
 *
 */

public class AdminResponse implements Serializable {


    private String ClientName ;
    private Long BuyerAmount ;


    private Long SellerAmount ;

    private Long balance ;
    private Long pendingQuantity ;

    public AdminResponse(String clientName, Long buyerAmount, Long sellerAmount, Long balance, Long pendingQuantity) {
        ClientName = clientName;
        BuyerAmount = buyerAmount;
        SellerAmount = sellerAmount;
        this.balance = balance;
        this.pendingQuantity = pendingQuantity;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Long getBuyerAmount() {
        return BuyerAmount;
    }

    public void setBuyerAmount(Long buyerAmount) {
        BuyerAmount = buyerAmount;
    }

    public Long getSellerAmount() {
        return SellerAmount;
    }

    public void setSellerAmount(Long sellerAmount) {
        SellerAmount = sellerAmount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getPendingQuantity() {
        return pendingQuantity;
    }

    public void setPendingQuantity(Long pendingQuantity) {
        this.pendingQuantity = pendingQuantity;
    }
}
