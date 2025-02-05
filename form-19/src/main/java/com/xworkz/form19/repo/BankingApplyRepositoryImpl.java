package com.xworkz.form19.repo;

import com.xworkz.form19.entity.BankingApplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class BankingApplyRepositoryImpl implements BankingApplyRepository {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(BankingApplyEntity bankingApplyEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(bankingApplyEntity);
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

    @Override
    public List<BankingApplyEntity> getAllApplicantInfo() {
        EntityManager entityManager= emf.createEntityManager();

        try {
            return entityManager.createQuery("select getAllApplicantInfo from BankingApplyEntity getAllApplicantInfo", BankingApplyEntity.class).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("id",id).executeUpdate();
        em.getTransaction().commit();
    }
    @Override
    public BankingApplyEntity getApplicantById(int id) {
        return (BankingApplyEntity) emf.createEntityManager().createNamedQuery("getApplicantById").setParameter("id",id).getSingleResult();


    }

    @Override
    public void updateApplicantInfo(BankingApplyEntity entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
}
