package com.maven.IPOService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * User class is used to map book object to relational model.
 *
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@JsonIgnore*/
    @Column(name ="id")
    private Long id ;


    @OneToOne(mappedBy = "menu")
    private IPO ipo;

    @Column
    private String title;

    @Column
    private String icon;

    @Column
    private String link;

/*
    public Menu(String title, String icon, String link, Boolean home) {
        this.title = title;
        this.icon = icon;
        this.link = link;
        this.home = home;
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", link='" + link + '\'' +
                ", home=" + home +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getHome() {
        return home;
    }

    public void setHome(Boolean home) {
        this.home = home;
    }

    private Boolean home;

}
