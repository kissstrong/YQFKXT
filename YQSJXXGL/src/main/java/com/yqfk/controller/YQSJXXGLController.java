package com.yqfk.controller;

import com.yqfk.poji.Address;
import com.yqfk.poji.City;
import com.yqfk.poji.DataForPerson;
import com.yqfk.poji.Province;
import com.yqfk.service.YQSJXXGLService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 15:46
 */
@Controller
public class YQSJXXGLController {
    @Resource
    private YQSJXXGLService yqsjxxglService;

    @RequestMapping("/")
    public String index(Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get("江苏省");
        City city = province.getCities().get("南通");
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        return "index";
    }

    @RequestMapping("/getJsonBySheng")
    public String getJsonBySheng(String sheng, Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get(sheng);
        model.addAttribute("province",province);
        return "index::json";
    }
    @RequestMapping("/getJsonByShi")
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
        return "index::city";
    }

    @RequestMapping("/touploaddata")
    public String touploaddata(){
        return "uploadpersondata";
    }

    @RequestMapping("/uploaddata")
    public String uploaddata(DataForPerson dataForPerson, Address address){
        dataForPerson.setAddress(address.getSheng()+address.getShi()+address.getQu());
        dataForPerson.setDate(new Date());
        yqsjxxglService.uploadPersonData(dataForPerson);
        return "redirect:/";
    }
}
