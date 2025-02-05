package com.xworkz.form20.repo;

import com.xworkz.form20.entity.GymApplyEntity;

import java.util.List;

public interface GymApplyRepository {
    Boolean save(GymApplyEntity gymApplyEntity);

    List<GymApplyEntity> getAllApplicantInfo();
    void deleteById(int id);
    GymApplyEntity getApplicantById(int id);

    void updateApplicantInfo(GymApplyEntity entity);
}
