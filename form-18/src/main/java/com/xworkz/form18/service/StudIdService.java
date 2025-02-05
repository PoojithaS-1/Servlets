package com.xworkz.form18.service;

import com.xworkz.form18.dto.StudIdDto;

import java.util.List;

public interface StudIdService {
    Boolean validateAndSave(StudIdDto dto);

    List<StudIdDto> getAllApplicantInfo();
    void deleteById(int studId);
    StudIdDto getApplicantById(int studId);

    void updateApplicantInfo(StudIdDto dto);
}