package com.makers.searchapi.service;

import com.makers.searchapi.model.Supplier;
import com.makers.searchapi.repository.SupplierRepository;
import com.makers.searchapi.repository.SupplierSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImp implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    @Override
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    @Override
    public Page<Supplier> searchSuppliers(String company_name, String website, String location, Supplier.NatureOfBusiness nature_of_business, Supplier.ManufacturingProcess manufacturing_process,int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        SupplierSpecification spec=new SupplierSpecification(company_name, website, location, nature_of_business, manufacturing_process);
        return supplierRepository.findAll(spec, pageable);
    }
}
