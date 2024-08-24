package com.makers.searchapi.controller;

import com.makers.searchapi.model.Supplier;
import com.makers.searchapi.model.Supplier.ManufacturingProcess;
import com.makers.searchapi.model.Supplier.NatureOfBusiness;
import com.makers.searchapi.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    public String add(@RequestBody Supplier supplier){
        supplierService.saveSupplier(supplier);
        return "New supplier is added";
    }

    @GetMapping("/getAll")
    public List<Supplier> getAllSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String website,
            @RequestParam(required = false) String company_name,
            @RequestParam(required = false) NatureOfBusiness nature_of_business,
            @RequestParam(required = false) ManufacturingProcess manufacturing_process,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<Supplier> suppliers = supplierService.searchSuppliers(company_name, website, location, nature_of_business, manufacturing_process, page, size);
        return ResponseEntity.ok(suppliers);
    }
}
