package com.spring.first.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String fio;

    private Date bdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gr_id")
    private Group group;

    public Student() {}

    public Student(String fio, Group group) {
        this.fio = fio;
        this.group = group;
        this.bdate = new Date(new Date().getTime());
    }

    public Integer getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getBdate() {
        return bdate;
    }

    public String getStringBdate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(bdate);
    }

    public String getGroupName() { return group != null? group.getGroupName() : "<none>"; }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }
}
