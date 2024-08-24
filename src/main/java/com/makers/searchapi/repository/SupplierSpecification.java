package com.makers.searchapi.repository;

import com.makers.searchapi.model.Supplier;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class SupplierSpecification implements Specification<Supplier> {
    private final String company_name;
    private final String website;
    private final String location;
    private final Supplier.NatureOfBusiness nature_of_business;
    private final Supplier.ManufacturingProcess manufacturing_process;

    public SupplierSpecification(String company_name, String website, String location, Supplier.NatureOfBusiness nature_of_business, Supplier.ManufacturingProcess manufacturing_process){
        this.company_name=company_name;
        this.website=website;
        this.location=location;
        this.nature_of_business=nature_of_business;
        this.manufacturing_process=manufacturing_process;
    }
    @Override
    public Predicate toPredicate(Root<Supplier> root, CriteriaQuery<?> query, CriteriaBuilder cb)
    {
    List<Predicate> predicates=new ArrayList<>();
    if(company_name!=null&&!company_name.isEmpty())
    {
      predicates.add(cb.like(cb.lower(root.get("company_name")),"%"+company_name.toLowerCase()+"%"));
    }
        if(website!=null&&!website.isEmpty())
        {
            predicates.add(cb.like(cb.lower(root.get("website")),"%"+website.toLowerCase()+"%"));
        }
        if(location!=null&&!location.isEmpty())
        {
            predicates.add(cb.like(cb.lower(root.get("location")),"%"+location.toLowerCase()+"%"));
        }
        if(nature_of_business!=null)
        {
            predicates.add(cb.equal(root.get("nature_of_business"),nature_of_business));
        }
        if(manufacturing_process!=null)
        {
            predicates.add(cb.equal(root.get("manufacturing_process"),manufacturing_process));
        }

        return cb.and(predicates.toArray(new Predicate[0]));

    }

}
