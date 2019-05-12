package com.maven.IPOService.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

/**
 * User class is used to map book object to relational model.
 *
 */
/*@Entity*/
/*@Table(name = "children")*/
public class Children implements Serializable {
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    /*@JsonIgnore*/
    /*@Column(name ="id")*/
    /*private Long id ;*/

   /* @ManyToOne
    private C menu;*/

    /*@Column*/
    private String title;

    /*@Column*/
    private String link;


    private Map<String, String> queryParams;
  /*  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +

                ", link='" + link + '\'' +

                '}';
    }

    public Children(String title, String link , Map<String, String>  queryParams ) {
        this.title = title;
        this.link = link;
        this.queryParams = queryParams;
    }
}
