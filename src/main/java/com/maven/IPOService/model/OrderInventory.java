package com.maven.IPOService.model;

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
    private String userId ;

    @Column(name ="ipoId")
    private String ipoId;

    @Column(name ="quantiy")
    private Long Quantiy;

    @Column(name ="rate")
    private Long Rate;

    @Column(name ="mode")
    private String Mode;

    public String getIpoId() {
        return ipoId;
    }

    public void setIpoId(String ipoId) {
        this.ipoId = ipoId;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIPOId() {
        return ipoId;
    }

    public void setIPOId(String IPOId) {
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
