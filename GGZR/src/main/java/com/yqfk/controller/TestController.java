package com.yqfk.controller;

import com.yqfk.pojo.News;
import com.yqfk.service.NewsService;
import com.yqfk.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    NewsService newsService = new NewsServiceImpl();
    @GetMapping("/test")
    @ResponseBody
    public String test (){

        List<News.NewslistDTO.NewsDTO> newsList = newsService.getNewsList();
        return newsList.toString();
    }
}
