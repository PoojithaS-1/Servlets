package com.xworkz.form9.service;

import com.xworkz.form9.dto.VoterIdApplyDto;

public interface VoterIdApplyService {
    Boolean validateAndSave(VoterIdApplyDto dto);
}
