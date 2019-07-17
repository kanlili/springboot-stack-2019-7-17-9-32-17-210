package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.Prosecutor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProsecutorRespositoryTest {
    @Autowired
    private  ProsecutorRespository prosecutorRespository;

    @Test
    public void should_return_prosecutorInfo_when_given_id(){
        Prosecutor prosecutor=new Prosecutor("LILO");
        prosecutorRespository.save(prosecutor);
        Prosecutor  prosecutor1=prosecutorRespository.findById(prosecutor.getId()).get();
        Assertions.assertEquals(prosecutor,prosecutor1);
    }
}
