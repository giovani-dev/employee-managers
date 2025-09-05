package com.employee.entity;

import java.util.Date;

public class EmployeeEntity {
    private String registration;
    private String name;
    private String email;
    private String phone;
    private String address;
    private PresenceEntity[] presence;
    private int presenceCount;

    public EmployeeEntity(
        String registration,
        String name,
        String email,
        String phone,
        String address
    ) {
        this.registration = registration;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.presence = new PresenceEntity[]{};
        this.presenceCount = 0;
    }

    public PresenceEntity[] getPresence() {
        return presence;
    }

    public void setPresence(PresenceEntity presence) {
        this.presence[this.presenceCount] = presence;
    }
}
