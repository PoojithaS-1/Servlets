package com.xworkz.form19.service;

import com.xworkz.form19.dto.BankingApplyDto;

import java.util.List;

public interface BankingApplyService {
    Boolean validateAndSave(BankingApplyDto dto);

    List<BankingApplyDto> getAllApplicantInfo();
    void deleteById(int id);

    BankingApplyDto getApplicantById(int id);

    void updateApplicantInfo(BankingApplyDto dto);

}
