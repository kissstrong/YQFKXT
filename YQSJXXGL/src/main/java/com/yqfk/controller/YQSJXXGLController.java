package com.yqfk.controller;

import com.yqfk.poji.Address;
import com.yqfk.poji.City;
import com.yqfk.poji.DataForPerson;
import com.yqfk.poji.Province;
import com.yqfk.pojo.News;
import com.yqfk.service.NewsService;
import com.yqfk.service.YQSJXXGLService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class YQSJXXGLController {
    @Resource
    private YQSJXXGLService yqsjxxglService;
    @Resource
    private NewsService newsService;
    @RequestMapping("/")
    public String index(Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get("江苏省");
        City city = province.getCities().get("南通");
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        model.addAttribute("newsList",newsService.getNewsList());
        model.addAttribute("desc",newsService.getDesc());
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
    @RequestMapping("/queryNewsByDate")
    public String queryNewsByDate(String date,Model model){
        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsListByDate(date);
        model.addAttribute("newsList",newsList);
        return "index::newsList";
    }
}
