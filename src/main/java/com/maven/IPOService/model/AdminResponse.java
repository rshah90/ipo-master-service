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
    private Long Amount ;


    private Long Quantity ;

    private String Mode ;

    public AdminResponse(String clientName, Long Amount, Long Quantity, String mode) {
        this.ClientName = clientName;
        this.Amount = Amount;
        this.Quantity = Quantity;
        this.Mode = mode;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Long getAmount() {
        return Amount;
    }

    public void setAmount(Long amount) {
        Amount = amount;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    @Override
    public String toString() {
        return "AdminResponse{" +
                "ClientName='" + ClientName + '\'' +
                ", Amount=" + Amount +
                ", Quantity=" + Quantity +
                ", Mode='" + Mode + '\'' +
                '}';
    }
}
