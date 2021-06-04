package com.zzuli.housekeepingserver.bean;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private Long id;

    private String name;

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
