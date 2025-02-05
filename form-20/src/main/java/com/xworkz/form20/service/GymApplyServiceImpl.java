package com.xworkz.form20.service;

import com.xworkz.form20.dto.GymApplyDto;
import com.xworkz.form20.entity.GymApplyEntity;
import com.xworkz.form20.repo.GymApplyRepository;
import com.xworkz.form20.repo.GymApplyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GymApplyServiceImpl implements GymApplyService {
    GymApplyRepository gymApplyRepository =new GymApplyRepositoryImpl();

    @Override
    public Boolean validateAndSave(GymApplyDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<GymApplyDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            GymApplyEntity gymApplyEntity = new GymApplyEntity();
            try {
                BeanUtils.copyProperties(gymApplyEntity, dto);
                System.out.println(gymApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            gymApplyRepository.save(gymApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<GymApplyDto> getAllApplicantInfo() {
        List<GymApplyEntity> entities=gymApplyRepository.getAllApplicantInfo();
        List<GymApplyDto> gymApplyDtos =new ArrayList<>();
        if (entities != null) {
            for (GymApplyEntity entity : entities) {
                GymApplyDto dto = new GymApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(gymApplyDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                gymApplyDtos.add(dto);
            }
        }
        return gymApplyDtos;

    }


    @Override
    public void deleteById(int id) {
        gymApplyRepository.deleteById(id);
        if (gymApplyRepository != null) {
            gymApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
    @Override
    public GymApplyDto getApplicantById(int id) {
        GymApplyDto dto = new GymApplyDto();
        if (id > 0) {
            GymApplyEntity entity = gymApplyRepository.getApplicantById(id);
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
    public void updateApplicantInfo(GymApplyDto dto) {
        GymApplyEntity entity=new GymApplyEntity();
        try {
            BeanUtils.copyProperties(entity,dto);
            gymApplyRepository.updateApplicantInfo(entity);
            System.out.println("Applicant Info Updated Successfully");

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}


