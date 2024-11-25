package com.example.Citronix.repositories;

import com.example.Citronix.dtos.response.FarmResponseDTO;
import com.example.Citronix.entities.Farm;
import com.example.Citronix.mappers.FarmMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FarmCriteriaBuilder {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private FarmMapper farmMapper;

    public List<FarmResponseDTO> findByCriteria(String name, String location, LocalDate date) {
        System.out.println("criteria prams: "+name+ ", "+location+", "+date);
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> cq = cb.createQuery(Farm.class);

        Root<Farm> farmRoot = cq.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        if (name != null && !name.isEmpty())
            predicates.add(cb.equal(farmRoot.get("name"), name));
        if (location != null && !location.isEmpty())
            predicates.add(cb.equal(farmRoot.get("location"), location));
        if (date != null)
            predicates.add(cb.equal(farmRoot.get("creationDate"), date));

        if (!predicates.isEmpty())
            cq.where(cb.and(predicates.toArray(new Predicate[0])));

        TypedQuery<Farm> query = entityManager.createQuery(cq);

        return query.getResultList()
                .stream().map(farm -> farmMapper.toResponseDto(farm)).toList();
    }
}
