package com.maven.IPOService.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * User class is used to map book object to relational model.
 *
 */
@Entity
@Table(name = "ipo_master")
public class IPO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@JsonIgnore*/
    @Column(name ="id")

    private Long id ;

    @Column
    private String status;

    public String getStatus() {
        return status;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Menu menu;



    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @NotBlank(message = "Please enter Company Name")
    private String issuerCompany;

    @NotBlank(message = "Please enter Open Date")
    private String openDate;

    @NotBlank(message = "Please enter Close Date")
    private String closeDate;


    @NotBlank(message = "Please enter Lotsize")
    private String lotSize;


    @NotBlank(message = "Please enter Issue Lower Price")
    private String issueLowerPrice;


    @NotBlank(message = "Please enter Issue Higher Price")
    private String issueHigherPrice;

    @NotBlank(message = "Please enter issue size")
    private String issueSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssuerCompany() {
        return issuerCompany;
    }

    public void setIssuerCompany(String issuerCompany) {
        this.issuerCompany = issuerCompany;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getLotSize() {
        return lotSize;
    }

    public void setLotSize(String lotSize) {
        this.lotSize = lotSize;
    }

    public String getIssueLowerPrice() {
        return issueLowerPrice;
    }

    public void setIssueLowerPrice(String issueLowerPrice) {
        this.issueLowerPrice = issueLowerPrice;
    }

    public String getIssueHigherPrice() {
        return issueHigherPrice;
    }

    public void setIssueHigherPrice(String issueHigherPrice) {
        this.issueHigherPrice = issueHigherPrice;
    }

    public String getIssueSize() {
        return issueSize;
    }

    public void setIssueSize(String issueSize) {
        this.issueSize = issueSize;
    }




    @Override
    public String toString() {
        return "IPO{" +
                "id=" + id +
                ", issuerCompany='" + issuerCompany + '\'' +
                ", openDate='" + openDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", lotSize='" + lotSize + '\'' +
                ", issueLowerPrice='" + issueLowerPrice + '\'' +
                ", issueHigherPrice='" + issueHigherPrice + '\'' +
                ", issueSize='" + issueSize + '\'' +
                '}';
    }
}
