package org.example.control;


import org.example.service.ServiceSs;
import org.example.system.MyResponseBody;
import org.example.system.model.Myfiles;
import org.example.utils.FileTypeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SeseControl {
    @Autowired
    ServiceSs ss;

    @GetMapping("/getfiles")
    public MyResponseBody getfiles(Integer father,Integer leave){
        if(father==null||leave==null){
            father=0;
            leave=0;
        }
        MyResponseBody body=new MyResponseBody();
        Map map=ss.getDirInfo(father,leave);
        if (map.isEmpty()){
            body.setCode(0);
            body.setInfo("查询失败");
        }else {
            body.setCode(200);
            body.setObject(map);
        }
        return body;
    }

    @GetMapping("getimgsinfo")
    public MyResponseBody getimgsinfo(HttpServletRequest req){
        MyResponseBody body=new MyResponseBody();
        Integer id=(Integer) req.getSession().getAttribute("fileid");
        Map map=ss.getImgInfo(id);
        if (map.isEmpty()){
            body.setCode(0);
            body.setInfo("图片列表为空");
        }else {
            body.setCode(200);
            body.setObject(map);
            req.getSession().setAttribute("imgsinfo",map);
        }
        return body;
    }
    @GetMapping(value = "/getimg",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] seeimg(HttpServletRequest req, HttpServletResponse rsp,Integer id) throws IOException {
       Map<Integer,Map<String,String>> imgsinfo=(Map) req.getSession().getAttribute("imgsinfo");
        if (imgsinfo==null){
            return null;
        }else {
            if(id==null){
                id=(Integer)req.getSession().getAttribute("fileid");
            }
            Map imginfo=imgsinfo.get(id);
            String name=(String) imginfo.get("name");
            if(!FileTypeUtils.getfiletype(name).equals("img")){
                return null;
            }
            String path=(String) imginfo.get("path");
            File file=new File(path);
            FileInputStream io=new FileInputStream(file);
            byte[] bytes=new byte[io.available()];
            io.read(bytes,0,io.available());
            return bytes;
        }
    }
}
