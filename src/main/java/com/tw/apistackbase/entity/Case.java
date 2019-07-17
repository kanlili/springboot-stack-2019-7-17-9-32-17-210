package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class Case {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = false)
    private  long caseHappenTime;
    @OneToOne(cascade = CascadeType.ALL)
    private  CaseInformation caseInformation;
    @OneToOne(cascade=CascadeType.ALL,optional=false)
    private  Procuratorate procuratorate;
    public  Case(){

    }

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public Case(String name, long caseHappenTime, CaseInformation caseInformation) {
        this.name = name;
        this.caseHappenTime = caseHappenTime;
        this.caseInformation = caseInformation;
    }

    public Case(String name, long caseHappenTime, CaseInformation caseInformation, Procuratorate procuratorate) {
        this.name = name;
        this.caseHappenTime = caseHappenTime;
        this.caseInformation = caseInformation;
        this.procuratorate = procuratorate;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
