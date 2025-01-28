package com.xworkz.form11.service;

import com.xworkz.form11.dto.BirthCertificateDto;

public interface BirthCertificateService {
    Boolean validateAndSave(BirthCertificateDto dto);
}
