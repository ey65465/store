package com.myapp1.store.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myapp1.store.pojo.City;
import com.myapp1.store.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    CityService cityService;

    //    页面跳转
    @RequestMapping(value="/admin_city_list", method = RequestMethod.GET)
    public ModelAndView listCity(){
        ModelAndView mav = new ModelAndView("admin_city_list");
        return mav;
    }
    @RequestMapping(value = "/admin_city_edit", method = RequestMethod.GET)
    public ModelAndView editCity(){
        ModelAndView mav = new ModelAndView("admin_city_edit");
        return mav;
    }
    //    Restful部分
    @GetMapping("/cities")
    public PageInfo<City> list(@RequestParam(value="start", defaultValue = "1") int start,
                               @RequestParam(value="size", defaultValue = "10") int size){
        PageHelper.startPage(start, size, "id desc");
        List<City> cs = cityService.list();
        PageInfo<City> page = new PageInfo<>(cs, 5); // 5表示导航分页最多5个
        return page;
    }
    @GetMapping("/cities/all")
    public List<City> list(){
        List<City> cs = cityService.list();
        return cs;
    }
    @PostMapping("/cities")
    public String add(@RequestBody City city){
        City c = cityService.listByName(city.getName());
        if(null != c) return "exist";
        else{
            cityService.add(city);
            return "success";
        }
    }
    @DeleteMapping("/cities/{id}")
    public String delete(City city){
        cityService.delete(city.getId());
        return "success";
    }
    @GetMapping("/cities/{id}")
    public City get(@PathVariable("id") int id){
        City c = cityService.get(id);
        return c;
    }
    @PostMapping("/cities/{id}")
    public String update(@RequestBody City city){
        cityService.update(city);
        return "success";
    }
}
