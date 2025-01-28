package com.xworkz.form17.service;

import com.xworkz.form17.dto.LibCardDto;
import com.xworkz.form17.entity.LibCardEntity;
import com.xworkz.form17.repo.LibCardRepository;
import com.xworkz.form17.repo.LibCardRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class LibCardServiceImpl implements LibCardService {
    LibCardRepository libCardRepository =new LibCardRepositoryImpl();

    @Override
    public Boolean validateAndSave(LibCardDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<LibCardDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            LibCardEntity libCardEntity = new LibCardEntity();
            try {
                BeanUtils.copyProperties(libCardEntity, dto);
                System.out.println(libCardEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            libCardRepository.save(libCardEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}