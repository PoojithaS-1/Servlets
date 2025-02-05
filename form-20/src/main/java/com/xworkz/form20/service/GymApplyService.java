package com.xworkz.form20.service;

import com.xworkz.form20.dto.GymApplyDto;

import java.util.List;

public interface GymApplyService {
    Boolean validateAndSave(GymApplyDto dto);

    List<GymApplyDto> getAllApplicantInfo();
    void deleteById(int id);
    GymApplyDto getApplicantById(int id);

    void updateApplicantInfo(GymApplyDto dto);

}
