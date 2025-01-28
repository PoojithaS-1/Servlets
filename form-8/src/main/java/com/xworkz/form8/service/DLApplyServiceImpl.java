package com.xworkz.form8.service;

import com.xworkz.form8.dto.DLApplyDto;
import com.xworkz.form8.entity.DLApplyEntity;
import com.xworkz.form8.repository.DLApplyRepository;
import com.xworkz.form8.repository.DLApplyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class DLApplyServiceImpl implements DLApplyService {
    DLApplyRepository dlApplyRepository =new DLApplyRepositoryImpl();

    @Override
    public Boolean validateAndSave(DLApplyDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DLApplyDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            DLApplyEntity dlApplyEntity = new DLApplyEntity();
            try {
                BeanUtils.copyProperties(dlApplyEntity, dto);
                System.out.println(dlApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            dlApplyRepository.save(dlApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}

