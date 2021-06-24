package com.company.diskexchange.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "DISKEXCHANGE_DISK")
@Entity(name = "diskexchange_Disk")
@NamePattern("%s %s|name,owner")
public class Disk extends StandardEntity {
    private static final long serialVersionUID = 5926058935803948936L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    private String name;

    @JoinColumn(name = "OWNER_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private User owner;

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}