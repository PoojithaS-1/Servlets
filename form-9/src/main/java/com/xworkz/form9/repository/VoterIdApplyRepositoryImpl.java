package com.xworkz.form9.repository;

import com.xworkz.form9.entity.VoterIdApplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VoterIdApplyRepositoryImpl implements VoterIdApplyRepository {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(VoterIdApplyEntity voterIdApplyEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(voterIdApplyEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()){
                entityManager.getTransaction().rollback();
                return false;
            }else {
                return false;
            }
        } finally {
            entityManager.close();
        }
    }
}

