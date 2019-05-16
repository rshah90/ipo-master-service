package com.maven.IPOService.model;

import java.io.Serializable;

/**
 * User class is used to map book object to relational model.
 *
 */


public class BalanceReportResponse implements Serializable {


    private String ClientName ;
    private Long BuyerAmount ;
    private Long SellerAmount ;
    private Long Total ;
    private Long PendingQuantity ;

    public BalanceReportResponse(String clientName, Long buyerAmount, Long sellerAmount, Long total, Long pendingQuantity) {
        this.ClientName = clientName;
        this.BuyerAmount = buyerAmount;
        this.SellerAmount = sellerAmount;
        this.Total = total;
        this.PendingQuantity = pendingQuantity;
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

    public Long getTotal() {
        return Total;
    }

    public void setTotal(Long total) {
        Total = total;
    }

    public Long getPendingQuantity() {
        return PendingQuantity;
    }

    public void setPendingQuantity(Long pendingQuantity) {
        PendingQuantity = pendingQuantity;
    }
}
