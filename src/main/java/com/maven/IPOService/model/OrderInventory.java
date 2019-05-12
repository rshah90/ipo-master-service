package com.maven.IPOService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * User class is used to map book object to relational model.
 *
 */
@Entity
@Table(name = "orders")
public class OrderInventory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id ;

    @Column(name ="userId")
    private Long userId ;

    @Column(name ="ipoId")
    private Long ipoId;

    @Column(name ="quantiy")
    private Long Quantiy;

    @Column(name ="rate")
    private Long Rate;

    @Column(name ="mode")
    private String Mode;

    @Column(name ="clientName")
    private String clientName;

    public Long getIpoId() {
        return ipoId;
    }

    public void setIpoId(Long ipoId) {
        this.ipoId = ipoId;
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getIPOId() {
        return ipoId;
    }

    public void setIPOId(Long IPOId) {
        this.ipoId = IPOId;
    }

    public Long getQuantiy() {
        return Quantiy;
    }

    public void setQuantiy(Long quantiy) {
        Quantiy = quantiy;
    }

    public Long getRate() {
        return Rate;
    }

    public void setRate(Long rate) {
        Rate = rate;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public String toString() {
        return "OrderInventory{" +
                "userId=" + userId +
                ", ipoId=" + ipoId +
                ", Quantiy=" + Quantiy +
                ", Rate=" + Rate +
                ", Mode=" + Mode +
                '}';
    }
}
