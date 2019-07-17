package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Case {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = false)
    private  long caseHappenTime;
    public  Case(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Case(String name, long caseHappenTime) {
        this.name = name;
        this.caseHappenTime = caseHappenTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCaseHappenTime() {
        return caseHappenTime;
    }

    public void setCaseHappenTime(long caseHappenTime) {
        this.caseHappenTime = caseHappenTime;
    }
}
