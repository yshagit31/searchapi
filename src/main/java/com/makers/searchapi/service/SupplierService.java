package com.makers.searchapi.service;

import com.makers.searchapi.model.Supplier;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {
    public Supplier saveSupplier(Supplier supplier);
    public List<Supplier> getAllSuppliers();

     Page<Supplier> searchSuppliers(String company_name, String website, String location, Supplier.NatureOfBusiness nature_of_business, Supplier.ManufacturingProcess manufacturing_process,int page,int size);
}
