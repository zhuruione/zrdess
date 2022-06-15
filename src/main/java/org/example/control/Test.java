package org.example.control;


import org.example.system.dao.MydirMapper;
import org.example.system.dao.MyfilesMapper;
import org.example.system.model.Mydir;
import org.example.system.model.Myfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class Test {
    @Autowired
    MydirMapper mydirMapper;
    @Autowired
    MyfilesMapper myfilesMapper;

    int dir_id;
    List<Mydir> list_dirs;
    List<Myfiles> list_files;

    @GetMapping("/makeshuju")
    @ResponseBody
    public long makeshuju() {
        List<Mydir> list_dirs=new ArrayList();
        List<Myfiles> list_files=new ArrayList<>();

        long stime=System.currentTimeMillis();
        dir_id=0;
        myfilesMapper.delectall();
        mydirMapper.delectall();
        File father = new File("G:\\data\\root\\ss");
        Mydir fistdir=new Mydir();
        fistdir.setId(dir_id);
        dir_id++;
        fistdir.setName(father.getName());
        fistdir.setDirleave(-1);
        fistdir.setDirF(null);
        fistdir.setPath(father.getPath());
        mydirMapper.insert(fistdir);
        make(father,0,0);
        return System.currentTimeMillis()-stime;

    }

    public void make(File file, int leave, Integer id) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                Myfiles myfiles = new Myfiles();
                myfiles.setName(f.getName());
                System.out.println(f.getName());
                myfiles.setPath(f.toString());
                myfiles.setDir(id);
                myfilesMapper.insert(myfiles);
            } else if (f.isDirectory()){
                Mydir dir = new Mydir();
                dir.setId(dir_id);
                dir_id++;
                dir.setDirF(id);
                dir.setPath(f.toString());
                dir.setName(f.getName());
                dir.setDirleave(leave);
                mydirMapper.insert(dir);
                make(f, leave + 1, dir_id-1);
            }
        }
    }
}
