package com.tw.apistackbase.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Procuratorate {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable=false,unique=true,length =50)
    private String  name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Prosecutor> prosecutor;
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

    public List<Prosecutor> getProsecutor() {
        return prosecutor;
    }

    public void setProsecutor(List<Prosecutor> prosecutor) {
        this.prosecutor = prosecutor;
    }

    public Procuratorate(String name, List<Prosecutor> prosecutor) {
        this.name = name;
        this.prosecutor = prosecutor;
    }
}
