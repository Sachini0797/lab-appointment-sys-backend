package com.sachini.labappointmentsys.model;

import com.sachini.labappointmentsys.enums.UserTypes;
import jakarta.persistence.*;

@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated
    @Column
    private UserTypes name;

    public  Authority() {}

    public Authority(UserTypes name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserTypes getName() {
        return name;
    }

    public void setName(UserTypes name) {
        this.name = name;
    }
}
