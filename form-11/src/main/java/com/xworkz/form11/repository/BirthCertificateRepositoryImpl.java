package com.xworkz.form11.repository;

import com.xworkz.form11.entity.BirthCertificateEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BirthCertificateRepositoryImpl implements BirthCertificateRepository{
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(BirthCertificateEntity birthCertificateEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(birthCertificateEntity);
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