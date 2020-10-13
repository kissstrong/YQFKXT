package com.yqfk.controller;

import com.yqfk.pojo.*;
import com.yqfk.service.NewsService;
import com.yqfk.service.YQSJXXGLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cyz
 * @date 2020-09-29 15:46
 */
@Controller
public class YQSJXXGLController {
    private final String YYCPGL_URL="http://localhost:8006";
    @Resource
    private YQSJXXGLService yqsjxxglService;
    @Resource
    private NewsService newsService;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 普通用户去主界面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        User user = (User) redisTemplate.opsForHash().values("user").get(0);
        session.setAttribute("user",user);
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get("江苏省");
        City city = province.getCities().get("南通");
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        model.addAttribute("newsList",newsService.getNewsList());
        model.addAttribute("desc",newsService.getDesc());
        return "index";
    }

    /**
     * 根据省份查询疫情数据
     * @param sheng
     * @param model
     * @return
     */
    @RequestMapping("/getJsonBySheng")
    public String getJsonBySheng(String sheng, Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get(sheng);
        model.addAttribute("province",province);
        return "index::json";
    }

    /**
     * 根据市查询疫情数据
     * @param sheng
     * @param shi
     * @param model
     * @return
     */
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

    /**
     * 去上报页面
     * @return
     */
    @RequestMapping("/touploaddata")
    public String touploaddata(){
        return "uploadpersondata";
    }

    /**
     * 上报数据
     * @param dataForPerson
     * @param address
     * @return
     */
    @RequestMapping("/uploaddata")
    public String uploaddata(DataForPerson dataForPerson, Address address){
        dataForPerson.setAddress(address.getSheng()+address.getShi()+address.getQu());
        dataForPerson.setDate(new Date());
        yqsjxxglService.uploadPersonData(dataForPerson);
        return "redirect:/";
    }

    /**
     * 根据时间查询新闻
     * @param date
     * @param model
     * @return
     */
    @RequestMapping("/queryNewsByDate")
    public String queryNewsByDate(String date,Model model){
        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsListByDate(date);
        model.addAttribute("newsList",newsList);
        return "index::newsList";
    }

    /**
     * 去医药产品管理系统
     * @param response
     * @throws Exception
     */
    @RequestMapping("/toYYCPGL")
    public void toYYCPGL(HttpServletResponse response)throws Exception{
        response.sendRedirect(YYCPGL_URL);
    }
}
