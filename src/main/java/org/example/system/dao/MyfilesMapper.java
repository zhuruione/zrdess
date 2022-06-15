package org.example.system.dao;

import java.util.List;
import org.example.system.model.Myfiles;

public interface MyfilesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Myfiles record);

    Myfiles selectByPrimaryKey(Integer id);

    List<Myfiles> selectAll();

    int updateByPrimaryKey(Myfiles record);

    void delectall();

    List<Myfiles>  selectbydir(Integer dir);
}