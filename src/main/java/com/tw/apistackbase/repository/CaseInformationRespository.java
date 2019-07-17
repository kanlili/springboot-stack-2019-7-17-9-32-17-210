package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseInformationRespository extends JpaRepository<CaseInformation,Long> {
}
