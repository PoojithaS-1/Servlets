package com.xworkz.form19.repo;

import com.xworkz.form19.entity.BankingApplyEntity;

import java.util.List;

public interface BankingApplyRepository {
    Boolean save(BankingApplyEntity bankingApplyEntity);

    List<BankingApplyEntity> getAllApplicantInfo();
    void deleteById(int id);
    BankingApplyEntity getApplicantById(int id);

    void updateApplicantInfo(BankingApplyEntity entity);
}
