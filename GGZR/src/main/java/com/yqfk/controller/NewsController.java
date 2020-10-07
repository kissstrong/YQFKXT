package com.yqfk.controller;

import com.yqfk.pojo.News;
import com.yqfk.service.NewsService;
import com.yqfk.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("news")
public class NewsController {
    @Autowired
    NewsService newsService = new NewsServiceImpl();

    @GetMapping("newsList")
    public String getNewsList (Model model){

        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsList();
        News.NewslistDTO.DescDTO descDTO = newsService.getDesc();
        model.addAttribute("newsList",newsList);
        model.addAttribute("desc",descDTO);
        return "newsList";
    }

    @GetMapping("getNewsListByDate")
    public String getNewsListByDate (Model model,@RequestParam(value = "date",defaultValue = "2020-10-01") String date){

        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsListByDate(date);
        if (newsList==null){
            model.addAttribute("error","请输入正确的日期格式或日期不在疫情区间");
            return "news";
        }
        model.addAttribute("newsList",newsList);
        return "news";
    }

}
