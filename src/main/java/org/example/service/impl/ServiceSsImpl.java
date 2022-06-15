package org.example.service.impl;

import org.example.service.ServiceSs;
import org.example.system.dao.MydirMapper;
import org.example.system.dao.MyfilesMapper;
import org.example.system.model.Mydir;
import org.example.system.model.Myfiles;
import org.example.utils.FileTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceSsImpl implements ServiceSs {
    @Autowired
    MydirMapper dirmapper;
    @Autowired
    MyfilesMapper filesMapper;

    @Override
    public Map getDirInfo(Integer father, Integer leave) {
        List<Map> alldir=new ArrayList<>();
        List<Mydir> dirs = dirmapper.selectbylandf(father, leave);
        Iterator<Mydir> it=dirs.iterator();
        //获取所有的文件夹
        while (it.hasNext()){
            Map<String,Object> map=new HashMap();
            Mydir dir=it.next();
            map.put("name",dir.getName());
            map.put("path",dir.getPath());
            map.put("id",dir.getId());
            map.put("leave",dir.getDirleave()) ;
            alldir.add(map);
        }
        //获取所有文件
        List<Map> allfile=new ArrayList<>();
        List files=filesMapper.selectbydir(father);
        Iterator<Myfiles> it2=files.iterator();
        while (it2.hasNext()){
            Map<String,Object> map=new HashMap();
            Myfiles myfiles=it2.next();
            map.put("name",myfiles.getName());
            map.put("path",myfiles.getPath());
            map.put("id",myfiles.getId());
            map.put("type",FileTypeUtils.getfiletype(myfiles.getName()));
            allfile.add(map);
        }
        Map<String,List> map=new HashMap<>();
        map.put("dirs",alldir);
        map.put("files",allfile);
        return map;
    }

    @Override
    public Map getImgInfo(Integer dir) {
        Myfiles myfile=filesMapper.selectByPrimaryKey(dir);
       List<Myfiles> list=filesMapper.selectbydir(myfile.getDir());
       Iterator<Myfiles> it=list.iterator();
       Map maps=new HashMap();
       while (it.hasNext()){
           Map<String,Object> map=new HashMap<>();
           Myfiles file=it.next();
           map.put("name",file.getName());
           map.put("path",file.getPath());
           maps.put(file.getId(),map);
       }
        return maps;
    }
}
