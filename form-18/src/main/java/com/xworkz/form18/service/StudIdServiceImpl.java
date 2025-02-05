package com.xworkz.form18.service;

import com.xworkz.form18.dto.StudIdDto;
import com.xworkz.form18.entity.StudIdEntity;
import com.xworkz.form18.repo.StudIdRepository;
import com.xworkz.form18.repo.StudIdRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StudIdServiceImpl implements StudIdService {
    StudIdRepository studIdRepository =new StudIdRepositoryImpl();

    @Override
    public Boolean validateAndSave(StudIdDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<StudIdDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            StudIdEntity studIdEntity = new StudIdEntity();
            try {
                BeanUtils.copyProperties(studIdEntity, dto);
                System.out.println(studIdEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            studIdRepository.save(studIdEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<StudIdDto> getAllApplicantInfo() {
        List<StudIdEntity> entities=studIdRepository.getAllApplicantInfo();
        List<StudIdDto> studIdDtos =new ArrayList<>();
        if (entities != null) {
            for (StudIdEntity entity : entities) {
                StudIdDto dto = new StudIdDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(studIdDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                studIdDtos.add(dto);
            }
        }
        return studIdDtos;

    }

    @Override
    public void deleteById(int studId) {
        studIdRepository.deleteById(studId);
        if (studIdRepository != null) {
            studIdRepository.deleteById(studId);
            System.out.println("Applicant Info with id " + studId + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + studId + " not found");
        }
    }
    @Override
    public StudIdDto getApplicantById(int studId) {
        StudIdDto dto = new StudIdDto();
        if (studId > 0) {
            StudIdEntity entity = studIdRepository.getApplicantById(studId);
            try {
                BeanUtils.copyProperties(dto, entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

        }
        return dto;
    }

    @Override
    public void updateApplicantInfo(StudIdDto dto) {
        StudIdEntity entity=new StudIdEntity();
        try {
            BeanUtils.copyProperties(entity,dto);
            studIdRepository.updateApplicantInfo(entity);
            System.out.println("Applicant Info Updated Successfully");

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
