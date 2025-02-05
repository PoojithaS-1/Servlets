package com.xworkz.form18.repo;

import com.xworkz.form18.entity.StudIdEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.List;

public class StudIdRepositoryImpl implements StudIdRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("poojitha");

    @Override
    public Boolean save(StudIdEntity studIdEntity) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(studIdEntity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
                return false;
            } else {
                return false;
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<StudIdEntity> getAllApplicantInfo() {
        EntityManager entityManager = emf.createEntityManager();

        try {
            return entityManager.createQuery("select getAllApplicantInfo from StudIdEntity getAllApplicantInfo", StudIdEntity.class).getResultList();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(int studId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("deleteById").setParameter("studId", studId).executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public StudIdEntity getApplicantById(int studId) {
        return (StudIdEntity) emf.createEntityManager().createNamedQuery("getApplicantById").setParameter("studId", studId).getSingleResult();


    }

    @Override
    public void updateApplicantInfo(StudIdEntity entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }
}
