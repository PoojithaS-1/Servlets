package com.xworkz.form19.service;

import com.xworkz.form19.dto.BankingApplyDto;
import com.xworkz.form19.entity.BankingApplyEntity;
import com.xworkz.form19.repo.BankingApplyRepository;
import com.xworkz.form19.repo.BankingApplyRepositoryImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BankingApplyServiceImpl implements BankingApplyService {
    BankingApplyRepository bankingApplyRepository =new BankingApplyRepositoryImpl();

    @Override
    public Boolean validateAndSave(BankingApplyDto dto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BankingApplyDto>> validate = validator.validate(dto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            BankingApplyEntity bankingApplyEntity = new BankingApplyEntity();
            try {
                BeanUtils.copyProperties(bankingApplyEntity, dto);
                System.out.println(bankingApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            bankingApplyRepository.save(bankingApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<BankingApplyDto> getAllApplicantInfo() {
        List<BankingApplyEntity> entities=bankingApplyRepository.getAllApplicantInfo();
        List<BankingApplyDto> bankingApplyDtos =new ArrayList<>();
        if (entities != null) {
            for (BankingApplyEntity entity : entities) {
                BankingApplyDto dto = new BankingApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(bankingApplyDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                bankingApplyDtos.add(dto);
            }
        }
        return bankingApplyDtos;

    }


    @Override
    public void deleteById(int id) {
        bankingApplyRepository.deleteById(id);
        if (bankingApplyRepository != null) {
            bankingApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
    @Override
    public BankingApplyDto getApplicantById(int id) {
        BankingApplyDto dto = new BankingApplyDto();
        if (id > 0) {
            BankingApplyEntity entity = bankingApplyRepository.getApplicantById(id);
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
    public void updateApplicantInfo(BankingApplyDto dto) {
        BankingApplyEntity entity=new BankingApplyEntity();
        try {
            BeanUtils.copyProperties(entity,dto);
            bankingApplyRepository.updateApplicantInfo(entity);
            System.out.println("Applicant Info Updated Successfully");

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}


