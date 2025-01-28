package com.xworkz.form9.service;

import com.xworkz.form9.dto.VoterIdApplyDto;
import com.xworkz.form9.entity.VoterIdApplyEntity;
import com.xworkz.form9.repository.VoterIdApplyRepository;
import com.xworkz.form9.repository.VoterIdApplyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class VoterIdApplyServiceImpl implements VoterIdApplyService {
    VoterIdApplyRepository voterIdApplyRepository=new VoterIdApplyRepositoryImpl();

    @Override
    public Boolean validateAndSave(VoterIdApplyDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<VoterIdApplyDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            VoterIdApplyEntity voterIdApplyEntity = new VoterIdApplyEntity();
            try {
                BeanUtils.copyProperties(voterIdApplyEntity, dto);
                System.out.println(voterIdApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            voterIdApplyRepository.save(voterIdApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}

