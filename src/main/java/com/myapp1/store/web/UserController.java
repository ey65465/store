package com.myapp1.store.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myapp1.store.pojo.User;
import com.myapp1.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@RestController
public class UserController {
    @Autowired
    UserService userService;
    // 跳转页面
    @RequestMapping("/admin_register")
    public ModelAndView toRegister(){
        ModelAndView mav = new ModelAndView("admin_user_register");
        return mav;
    }
    @RequestMapping("/admin_login")
    public ModelAndView toLogin(HttpServletRequest request){
        request.getSession().setAttribute("tip", "你好吗？");
        ModelAndView mav = new ModelAndView("admin_user_login");
        return mav;
    }
    @RequestMapping("/admin_user_list")
    public ModelAndView userPage(){
        ModelAndView mav = new ModelAndView("admin_user_list");
        return mav;
    }
    @RequestMapping("/admin_user_edit")
    public ModelAndView editPage(){
        ModelAndView mav = new ModelAndView("admin_user_edit");
        return mav;
    }

    // restful
    @PostMapping("/users/{authCode}")
    public String add(@RequestBody User user, @PathVariable("authCode") String authCode){
        User u = userService.getByName(user.getName());
        if(null != u) return "exist";
        if("teacher".equals(user.getActor()) && !"1234567".equals(authCode)) return "errorCode";
        if("admin".equals(user.getActor()) && !"12345".equals(authCode)) return "errorCode";
        user.setCreateDate(new Date());
        userService.add(user);
        return "success";
    }
    @PostMapping("/users/update/{id}")
    public String update(@RequestBody User user){
        userService.update(user);
        return "success";
    }
    @PostMapping("/users")
    public String postAndLogin(HttpServletRequest request, @RequestBody User user){
        User u = userService.getByName(user.getName());
        if(null == u) return "notExist";
        else if(!Objects.equals(u.getPassword(), user.getPassword())) return "errorPassword";
        else if(!"admin".equals(u.getActor())) return "lowActor";
        else {
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            return "success";
        }
    }
    @GetMapping("/users")
    public PageInfo<User> listUser(@RequestParam(value = "start", defaultValue = "1") int start,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam(value ="actor", defaultValue = "admin") String actor){
        PageHelper.startPage(start, size, "id desc");
        List<User> users = userService.listByActor(actor);
        PageInfo<User> page = new PageInfo<>(users, 5);
        return page;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") int id){
        System.out.println(id);
        userService.delete(id);
        return "success";
    }
    @GetMapping("users/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getById(id);
    }
}
