package com.xworkz.form10.repository;

import com.xworkz.form10.entity.RationCardEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RationCardRepositoryImpl implements RationCardRepository {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(RationCardEntity rationCardEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(rationCardEntity);
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
