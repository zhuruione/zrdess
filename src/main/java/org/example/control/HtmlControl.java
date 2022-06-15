package org.example.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HtmlControl {
    @GetMapping("/file")
    public String file(){
        return "file/index";
    }
    @GetMapping("/openfile")
    public String openfile(HttpServletRequest req,Integer fileid ){
        req.getSession().setAttribute("fileid",fileid);
        return "file/img";
    }
}
