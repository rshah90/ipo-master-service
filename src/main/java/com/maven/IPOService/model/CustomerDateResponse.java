package com.maven.IPOService.model;

import java.io.Serializable;

/**
 * User class is used to map book object to relational model.
 *
 */


public class CustomerDateResponse implements Serializable {


    private String ClientName ;
    private Long BuyerAmount ;
    private Long SellerAmount ;

    private Long BuyerQuantity ;
    private Long SellerQuantity ;

    public CustomerDateResponse(String clientName, Long buyerAmount, Long sellerAmount, Long buyerQuantity, Long sellerQuantity) {
        ClientName = clientName;
        BuyerAmount = buyerAmount;
        SellerAmount = sellerAmount;
        BuyerQuantity = buyerQuantity;
        SellerQuantity = sellerQuantity;
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

    public Long getBuyerQuantity() {
        return BuyerQuantity;
    }

    public void setBuyerQuantity(Long buyerQuantity) {
        BuyerQuantity = buyerQuantity;
    }

    public Long getSellerQuantity() {
        return SellerQuantity;
    }

    public void setSellerQuantity(Long sellerQuantity) {
        SellerQuantity = sellerQuantity;
    }

    @Override
    public String toString() {
        return "CustomerDateResponse{" +
                "ClientName='" + ClientName + '\'' +
                ", BuyerAmount=" + BuyerAmount +
                ", SellerAmount=" + SellerAmount +
                ", BuyerQuantity=" + BuyerQuantity +
                ", SellerQuantity=" + SellerQuantity +
                '}';
    }
}
