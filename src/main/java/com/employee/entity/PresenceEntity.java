package com.employee.entity;

import java.util.Date;

public class PresenceEntity {
    private Date date;
    private boolean isPresent;

    public PresenceEntity(Date date, boolean isPresent) {
        this.date = date;
        this.isPresent = isPresent;
    }

    public Date getDate() {
        return date;
    }

    public boolean getIsPresent() {
        return isPresent;
    }
}
