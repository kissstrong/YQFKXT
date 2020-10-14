package com.yqfk.controller;

import com.yqfk.pojo.*;
import com.yqfk.service.NewsService;
import com.yqfk.service.YQSJXXGLService;
import com.yqfk.vo.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

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
public class AdminYQSJXXGLController {
    private final String YYCPGL_URL="http://localhost:8006";
    private final String XTSZ_URL="http://localhost:80";
    @Resource
    private YQSJXXGLService yqsjxxglService;
    @Resource
    private NewsService newsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Resource
    private RestTemplate restTemplate;

    /**
     * 管理员主页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/admin")
    public String index(Model model, HttpSession session){
        Admin admin = (Admin) redisTemplate.opsForHash().values("admin").get(0);
        session.setAttribute("admin",admin);
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get("江苏省");
        City city = province.getCities().get("南通");
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        model.addAttribute("newsList",newsService.getNewsList());
        model.addAttribute("desc",newsService.getDesc());
        return "admin/index";
    }

    /**
     * 根据省份查询疫情
     * @param sheng
     * @param model
     * @return
     */
    @RequestMapping("/admingetJsonBySheng")
    public String getJsonBySheng(String sheng, Model model){
        Map<String, Province> jsonMsg = yqsjxxglService.getJsonMsg();
        Province province = jsonMsg.get(sheng);
        model.addAttribute("province",province);
        return "admin/index::json";
    }

    /**
     * 根据市查询疫情
     * @param sheng
     * @param shi
     * @param model
     * @return
     */
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

    /**
     * 管理员去上报页面
     * @return
     */
    @RequestMapping("/admintouploaddata")
    public String touploaddata(){
        return "admin/uploadpersondata";
    }

    /**
     * 管理员上报疫情数据
     * @param dataForPerson
     * @param address
     * @return
     */
    @RequestMapping("/adminuploaddata")
    public String uploaddata(DataForPerson dataForPerson, Address address){
        dataForPerson.setAddress(address.getSheng()+address.getShi()+address.getQu());
        dataForPerson.setDate(new Date());
        yqsjxxglService.uploadPersonData(dataForPerson);
        return "redirect:/admin";
    }

    /**
     * 管理员获取上报记录数据
     * @param model
     * @return
     */
    @RequestMapping("/admintogetdata")
    public String admintogetdata(Model model){
        model.addAttribute("data",yqsjxxglService.queryAll());
        return "admin/alldata";
    }

    /**
     * 管理员模糊查询
     * @param tags
     * @param model
     * @return
     */
    @RequestMapping("/queryByTag")
    public String queryByTag(Tags tags, Model model){
         List<DataForPerson> dataForPeople = yqsjxxglService.queryByTags(tags);
        model.addAttribute("data",dataForPeople);
        return "admin/alldata::data";
    }

    /**
     * 根据id删除上报记录
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(int id, Model model){
        yqsjxxglService.deleteById(id);
        model.addAttribute("data",yqsjxxglService.queryAll());
        return "admin/alldata::data";
    }

    /**
     * 管理员根据查询新闻数据
     * @param date
     * @param model
     * @return
     */
    @RequestMapping("/adminqueryNewsByDate")
    public String queryNewsByDate(String date,Model model){
        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsListByDate(date);
        model.addAttribute("newsList",newsList);
        return "admin/index::newsList";
    }

    /**
     * 管理员退出登录
     * @param response
     * @param session
     * @throws Exception
     */
    @RequestMapping("/logout")
    public void logout(HttpServletResponse response,HttpSession session)throws Exception{
        session.removeAttribute("admin");
        session.removeAttribute("user");
        response.sendRedirect(XTSZ_URL+"/logout");
    }

    /**
     * 去医药厂品管理页面
     * @param response
     * @throws Exception
     */
    @RequestMapping("/toMainYYCPGL")
    public void toYYCPGL(HttpServletResponse response)throws Exception{
        response.sendRedirect(YYCPGL_URL+"/admin");
    }
}
