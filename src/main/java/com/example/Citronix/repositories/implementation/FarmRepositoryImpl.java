package com.example.Citronix.repositories.implementation;

import com.example.Citronix.entities.Farm;
import com.example.Citronix.repositories.CustomFarmRepository;
import com.example.Citronix.repositories.FarmRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class FarmRepositoryImpl implements FarmRepository, CustomFarmRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Farm> findByCriteria(String name, String location, LocalDate date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> cq = cb.createQuery(Farm.class);

        Root<Farm> farmRoot = cq.from(Farm.class);

        Predicate farmNamePredicate = cb.equal(farmRoot.get("name"), name);
        Predicate farmLocationPredicate = cb.equal(farmRoot.get("location"), location);
        Predicate farmDatePredicate = cb.equal(farmRoot.get("creation_date"), date);

        cq.where(farmNamePredicate, farmLocationPredicate, farmDatePredicate);

        TypedQuery<Farm> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}
