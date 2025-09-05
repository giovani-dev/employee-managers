package com.employee.entity;

import com.employee.enums.CountryEnum;
import com.employee.enums.StateEnum;

public class AddressEntity {
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String postalCode;
    private String city;
    private StateEnum state;
    private CountryEnum country;

    public AddressEntity(
        String street,
        String number,
        String complement,
        String neighborhood,
        String postalCode,
        String city,
        StateEnum state,
        CountryEnum country
    ) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
