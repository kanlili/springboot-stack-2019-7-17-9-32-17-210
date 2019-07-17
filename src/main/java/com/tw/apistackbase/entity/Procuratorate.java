package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Procuratorate {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable=false,unique=true,length =50)
    private String  name;

    public  Procuratorate(){}

    public Procuratorate(String name) {
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
