package com.xworkz.form10.service;

import com.xworkz.form10.dto.RationCardDto;
import com.xworkz.form10.entity.RationCardEntity;
import com.xworkz.form10.repository.RationCardRepository;
import com.xworkz.form10.repository.RationCardRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class RationCardServiceImpl implements RationCardService {
    RationCardRepository rationCardRepository =new RationCardRepositoryImpl();

    @Override
    public Boolean validateAndSave(RationCardDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RationCardDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            RationCardEntity rationCardEntity = new RationCardEntity();
            try {
                BeanUtils.copyProperties(rationCardEntity, dto);
                System.out.println(rationCardEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            rationCardRepository.save(rationCardEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
