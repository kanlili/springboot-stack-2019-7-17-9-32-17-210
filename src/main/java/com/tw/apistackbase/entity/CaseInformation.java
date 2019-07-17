package com.tw.apistackbase.entity;

import javax.persistence.*;

@Entity
public class CaseInformation {
   @Id
   @Column
   @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Column(nullable = false,length = 255)
   private  String subCondition;
    @Column(nullable = false,length = 255)
   private String objCondition;
    public  CaseInformation(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubCondition() {
        return subCondition;
    }

    public void setSubCondition(String subCondition) {
        this.subCondition = subCondition;
    }

    public String getObjCondition() {
        return objCondition;
    }

    public void setObjCondition(String objCondition) {
        this.objCondition = objCondition;
    }

    public CaseInformation(String subCondition, String objCondition) {
        this.subCondition = subCondition;
        this.objCondition = objCondition;
    }
}
