package org.example.system.model;

import java.io.Serializable;

public class Myfiles implements Serializable {
    private Integer id;

    private String name;

    private String path;

    private Integer dir;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDir() {
        return dir;
    }

    public void setDir(Integer dir) {
        this.dir = dir;
    }
}