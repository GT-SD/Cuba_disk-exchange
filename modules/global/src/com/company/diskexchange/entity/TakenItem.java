package com.company.diskexchange.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "DISKEXCHANGE_TAKEN_ITEM")
@Entity(name = "diskexchange_TakenItem")
public class TakenItem extends StandardEntity {
    private static final long serialVersionUID = -1516158910382478396L;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DISK_ID")
    private Disk disk;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;

    /*public TakenItem(Disk disk, User user){
        this.disk = disk;
        this.user = user;
    }*/

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }
}