package org.example.system.dao;

import java.util.List;
import org.example.system.model.Mydir;

public interface MydirMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mydir record);

    Mydir selectByPrimaryKey(Integer id);

    Mydir selectByPath(String path);


    List<Mydir> selectAll();

    int updateByPrimaryKey(Mydir record);

    void delectall();

    List<Mydir> selectbylandf(Integer dir_f,Integer dirleave);
}