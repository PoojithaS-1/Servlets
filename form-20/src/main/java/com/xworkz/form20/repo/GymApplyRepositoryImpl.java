package com.xworkz.form20.repo;

import com.xworkz.form20.entity.GymApplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class GymApplyRepositoryImpl implements GymApplyRepository {
    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(GymApplyEntity gymApplyEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gymApplyEntity);
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
    public List<GymApplyEntity> getAllApplicantInfo() {
        EntityManager entityManager= emf.createEntityManager();

        try {
            return entityManager.createQuery("select getAllApplicantInfo from GymApplyEntity getAllApplicantInfo", GymApplyEntity.class).getResultList();

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
    public GymApplyEntity getApplicantById(int id) {
        return (GymApplyEntity) emf.createEntityManager().createNamedQuery("getApplicantById").setParameter("id",id).getSingleResult();


    }

    @Override
    public void updateApplicantInfo(GymApplyEntity entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
}