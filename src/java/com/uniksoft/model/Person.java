package com.uniksoft.model;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Person {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    private String gender;
    private String country;
    
    @Column(name="about_you")
    private String aboutYou;
    
    @Column(name="mailing_list")
    private Boolean mailingList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAboutYou() {
        return aboutYou;
    }

    public void setAboutYou(String aboutYou) {
        this.aboutYou = aboutYou;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getMailingList() {
        return mailingList;
    }

    public void setMailingList(Boolean mailingList) {
        this.mailingList = mailingList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
