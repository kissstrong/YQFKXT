package com.yqfk.controller;

import com.yqfk.poji.Address;
import com.yqfk.poji.City;
import com.yqfk.poji.DataForPerson;
import com.yqfk.poji.Province;
import com.yqfk.service.YQSJXXGLService;
import com.yqfk.vo.Tags;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 15:46
 */
@Controller
public class AdminYQSJXXGLController {
    @Resource
    private YQSJXXGLService yqsjxxglService;

    @RequestMapping("/admin")
    public String index(Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get("江苏省");
        City city = province.getCities().get("南通");
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        return "admin/index";
    }

    @RequestMapping("/admingetJsonBySheng")
    public String getJsonBySheng(String sheng, Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get(sheng);
        model.addAttribute("province",province);
        return "admin/index::json";
    }
    @RequestMapping("/admingetJsonByShi")
    public String getJsonByShi(String sheng, String shi, Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get(sheng);
        Map<String, City> cities = province.getCities();
        for (String s : cities.keySet()) {
            if (s.indexOf(shi)>-1){
                model.addAttribute("city",cities.get(s));
                break;
            }else if(shi.indexOf(s)>-1){
                model.addAttribute("city",cities.get(s));
                break;
            }
        }
        return "admin/index::city";
    }

    @RequestMapping("/admintouploaddata")
    public String touploaddata(){
        return "admin/uploadpersondata";
    }

    @RequestMapping("/adminuploaddata")
    public String uploaddata(DataForPerson dataForPerson, Address address){
        dataForPerson.setAddress(address.getSheng()+address.getShi()+address.getQu());
        dataForPerson.setDate(new Date());
        yqsjxxglService.uploadPersonData(dataForPerson);
        return "redirect:/admin";
    }
    @RequestMapping("/admintogetdata")
    public String admintogetdata(Model model){
        model.addAttribute("data",yqsjxxglService.queryAll());
        return "admin/alldata";
    }
    @RequestMapping("/queryByTag")
    public String queryByTag(Tags tags, Model model){
        System.out.println(tags);
         List<DataForPerson> dataForPeople = yqsjxxglService.queryByTags(tags);
        model.addAttribute("data",dataForPeople);
        return "admin/alldata::data";
    }

    @RequestMapping("/deleteById")
    public String deleteById(int id, Model model){
        yqsjxxglService.deleteById(id);
        model.addAttribute("data",yqsjxxglService.queryAll());
        return "admin/alldata::data";
    }
}
