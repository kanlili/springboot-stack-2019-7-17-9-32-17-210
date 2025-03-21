package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CaseInformation;
import com.tw.apistackbase.entity.Procuratorate;
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
public class ProcuratorateRespositoryTest {
    @Autowired
    private ProcuratorateRespository procuratorateRespository;
    @Autowired
    private  CaseRepository caseRepository;
    @Test
    public void should_void_return_procuratorate_list(){
        Procuratorate procuratorate=new Procuratorate("CHECK");
        Procuratorate procuratorateone=new Procuratorate("CHECkK");
        procuratorateRespository.save(procuratorate);
        procuratorateRespository.save(procuratorateone);
        List<Procuratorate> procuratorates=procuratorateRespository.findAll();
        Assertions.assertEquals(2,procuratorates.size());
    }
    @Test
    public  void should_void_return_procuratorate_when_given_id(){
        Procuratorate procuratorate=new Procuratorate("CHECK2");
        procuratorateRespository.save(procuratorate);
        Procuratorate procuratorate2=procuratorateRespository.findById(procuratorate.getId()).get();
        Assertions.assertEquals(procuratorate,procuratorate2);

    }
    @Test
    public  void should_return_procuratorate_when_given_a_case(){
        CaseInformation caseInformation=new CaseInformation("lisi driverd","zhangsan killed");
        Procuratorate procuratorate=new Procuratorate("CHECKK");
        Case cson=new Case("lisi",Long.valueOf(20190717),caseInformation,procuratorate);
        caseRepository.save(cson);
        List<Case> cs=caseRepository.findAll();
        Assertions.assertEquals(1,cs.size());
    }

}
