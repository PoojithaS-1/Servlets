package com.xworkz.form11.service;

import com.xworkz.form11.dto.BirthCertificateDto;
import com.xworkz.form11.entity.BirthCertificateEntity;
import com.xworkz.form11.repository.BirthCertificateRepository;
import com.xworkz.form11.repository.BirthCertificateRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class BirthCertificateServiceImpl implements BirthCertificateService {
    BirthCertificateRepository birthCertificateRepository =new BirthCertificateRepositoryImpl();
    @Override
    public Boolean validateAndSave(BirthCertificateDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BirthCertificateDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            BirthCertificateEntity birthCertificateEntity = new BirthCertificateEntity();
            try {
                BeanUtils.copyProperties(birthCertificateEntity, dto);
                System.out.println(birthCertificateEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            birthCertificateRepository.save(birthCertificateEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}

