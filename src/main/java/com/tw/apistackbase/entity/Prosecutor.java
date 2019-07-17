package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Prosecutor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable=false,length =50)
    private String  name;

    public Prosecutor( String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
