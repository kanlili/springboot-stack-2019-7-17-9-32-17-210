package com.tw.apistackbase.repository;


import com.tw.apistackbase.entity.Procuratorate;
import com.tw.apistackbase.entity.Prosecutor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProsecutorRespositoryTest {
    @Autowired
    private  ProsecutorRespository prosecutorRespository;
    @Autowired
    private ProcuratorateRespository procuratorateRespository;
    @Test
    public void should_return_prosecutorInfo_when_given_id(){
        Prosecutor prosecutor=new Prosecutor("LILO");
        prosecutorRespository.save(prosecutor);
        Prosecutor  prosecutor1=prosecutorRespository.findById(prosecutor.getId()).get();
        Assertions.assertEquals(prosecutor,prosecutor1);
    }
    @Test
    public  void  should_return_procuratorate_prosecutor_information(){
        Prosecutor prosecutor=new Prosecutor("LILO");
        Prosecutor prosecutort=new Prosecutor("LIPO");
        List<Prosecutor>prosecutorList=new ArrayList<>();
        prosecutorRespository.save(prosecutor);
        prosecutorRespository.save(prosecutort);
        prosecutorList.add(prosecutor);
        prosecutorList.add(prosecutort);
        Procuratorate procuratorate=new Procuratorate("check",prosecutorList);
        procuratorateRespository.save(procuratorate);
        List<Procuratorate>procuratoratelist=procuratorateRespository.findAll();
        Assertions.assertEquals("{\"name\":\"check\",\"prosecutors\":[{\"name\":\"LILO\"}, {\"name\":\"LIPO\"}]}",procuratoratelist.get(0).toString());


}
}