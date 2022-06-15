package org.example.system.model;

import java.io.Serializable;

public class Mydir implements Serializable {
    private Integer id;

    private String path;

    private String name;

    private Integer dirF;

    private Integer dirleave;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDirF() {
        return dirF;
    }

    public void setDirF(Integer dirF) {
        this.dirF = dirF;
    }

    public Integer getDirleave() {
        return dirleave;
    }

    public void setDirleave(Integer dirleave) {
        this.dirleave = dirleave;
    }
}