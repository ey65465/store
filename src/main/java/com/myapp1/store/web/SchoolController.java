package com.myapp1.store.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myapp1.store.pojo.School;
import com.myapp1.store.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class SchoolController {
    @Autowired
    SchoolService schoolService;
    // 页面跳转
    @RequestMapping("/admin_school_list")
    public ModelAndView toSchool(){
        ModelAndView mav = new ModelAndView("admin_school_list");
        return mav;
    }

    // restful
    @GetMapping("/schools")
    public PageInfo<School> listSchool(@RequestParam(value = "start", defaultValue = "1") int start,
                                       @RequestParam(value = "size", defaultValue = "10") int size){
        PageHelper.startPage(start, size, "id desc");
        List<School> ss = schoolService.list();
        PageInfo<School> page = new PageInfo<>(ss, 5);
        return page;
    }
}
