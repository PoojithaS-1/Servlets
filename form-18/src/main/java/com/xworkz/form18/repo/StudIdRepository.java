package com.xworkz.form18.repo;

import com.xworkz.form18.entity.StudIdEntity;

import java.util.List;

public interface StudIdRepository {
    Boolean save(StudIdEntity studIdEntity);

    List<StudIdEntity> getAllApplicantInfo();
    void deleteById(int studId);
    StudIdEntity getApplicantById(int studId);

    void updateApplicantInfo(StudIdEntity entity);
}
