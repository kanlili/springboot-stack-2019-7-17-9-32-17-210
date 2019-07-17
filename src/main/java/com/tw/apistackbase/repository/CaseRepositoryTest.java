package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.Case;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.reverse;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CaseRepositoryTest {

    @Autowired
    private  CaseRepository caseRepository;
    @Test
    public void should_return_case_given_correct_case(){
        Case cs=new Case("lisi",new Date().getTime());
        caseRepository.save(cs);
        List<Case>csone=caseRepository.findAll();

        Assertions.assertEquals(1,csone.size());
    }
    @Test
    public void should_return_allContents_when_find_by_id(){
        Case cs2=new Case("lisitwo",new Date().getTime());
        caseRepository.save(cs2);
        Case cstwo=caseRepository.findById(cs2.getId()).get();
        Assertions.assertEquals(cstwo,cs2);
    }
    @Test
    public  void  should_return_allContends_and_desc_sort(){
        Case csone=new Case("lisi",Long.valueOf(20190717));
        Case cstwo=new Case("zhangsan",Long.valueOf(20190717));
        caseRepository.save(csone);
        caseRepository.save(cstwo);

        List<Case>csoneone=caseRepository.findAll();

        List<Case>csonetwo=csoneone.stream().sorted(Comparator.comparing(Case::getCaseHappenTime)).collect(Collectors.toList());
        reverse(csonetwo);
        Assertions.assertEquals(csoneone,csonetwo);

    }

}
