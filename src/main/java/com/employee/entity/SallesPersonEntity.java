package com.employee.entity;

public class SallesPersonEntity extends EmployeeEntity {
    private Integer[] sales;

    public SallesPersonEntity(
        String registration,
        String name,
        String email,
        String phone,
        String address
    ) {
        super(registration, name, email, phone, address);
        this.sales = new Integer[]{};
    }

    public Integer[] getSales() {
        return sales;
    }
}
