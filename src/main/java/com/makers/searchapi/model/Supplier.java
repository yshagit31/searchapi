package com.makers.searchapi.model;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name = "supplier", uniqueConstraints = @UniqueConstraint(columnNames = "location"))
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;
    @NotNull
    private String company_name;
    private String website;

    @NotNull
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness nature_of_business;


    @Enumerated(EnumType.STRING)
    private ManufacturingProcess manufacturing_process;

    public Supplier() {
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String webiste) {
        this.website = webiste;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NatureOfBusiness getNature_of_business() {
        return nature_of_business;
    }

    public void setNature_of_business(NatureOfBusiness nature_of_business) {
        this.nature_of_business = nature_of_business;
    }

    public ManufacturingProcess getManufacturing_process() {
        return manufacturing_process;
    }

    public void setManufacturing_process(ManufacturingProcess manufacturing_process) {
        this.manufacturing_process = manufacturing_process;
    }

    public enum NatureOfBusiness {
        small_scale,
        medium_scale,
        large_scale
    }
    public enum ManufacturingProcess {
        moulding,
        three_d_printing,
        casting,
        coating
    }


}
