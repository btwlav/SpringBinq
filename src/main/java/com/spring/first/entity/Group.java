package com.spring.first.entity;

import javax.persistence.*;

@Entity
@Table(name = "grp")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Group() {}

    public Integer getId() {
        return id;
    }

    public String getGroupName() {
        return name;
    }

    public void setGr_name(String gr_name) {
        this.name = gr_name;
    }
}
