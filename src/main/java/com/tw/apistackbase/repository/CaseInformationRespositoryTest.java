package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Case;
import com.tw.apistackbase.entity.CaseInformation;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CaseInformationRespositoryTest {

    @Autowired
    private  CaseInformationRespository caseInformationRespository;
    private  CaseRepository caseRepository;
    @Test
    public void should_return_case_given_correct_case(){
        CaseInformation caseInformation=new CaseInformation("lisi driverd","zhangsan killed");
       caseInformationRespository.save(caseInformation);
        List<CaseInformation> caseInformations1=caseInformationRespository.findAll();
        Assertions.assertEquals(1,caseInformations1.size());
    }
    @Test
    public  void  should_return_allInfo_when_given_caseId(){
        CaseInformation caseInformation=new CaseInformation("wangwu driverd","wangwu driverd");
        caseInformationRespository.save(caseInformation);
        CaseInformation caseInformation1=caseInformationRespository.findAllById(caseInformation.getId()).get();
        Assertions.assertEquals(caseInformation1,caseInformation);

    }
    @Test
    public  void should_return_sameInfo(){
        CaseInformation caseInformation=new CaseInformation("lisi driverd","zhangsan killed");
        Case cs=new Case("lisi",Long.valueOf(20190717),caseInformation);

        caseRepository.save(cs);
        Case csone=caseRepository.findById(cs.getId()).get();
        Assertions.assertEquals("{\"criminalInfomation\":{" +
                "\"id\":2," +
                "\"subCondition\":\"lisi driverd\"," +
                "\"objCondition\":\"zhangsan killed\"}," +
                "\"date\":20190717," +
                "\"id\":1," +
                "\"name\":\"caseone\"}",JSON.toJSONString(csone));

    }
}
