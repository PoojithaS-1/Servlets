package com.xworkz.form8.service;

import com.xworkz.form8.dto.DLApplyDto;

public interface DLApplyService {
    Boolean validateAndSave(DLApplyDto dto);
}
