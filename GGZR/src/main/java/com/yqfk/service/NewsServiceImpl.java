package com.yqfk.service;

import com.alibaba.fastjson.JSON;
import com.yqfk.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<News.NewslistDTO.NewsDTO> getNewsList() {
        String url = "http://api.tianapi.com/txapi/ncov/index?key=e00a38cd23dbae5817bbaee5a5b46f82";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        News news = JSON.parseObject(json, News.class);
        System.out.println(news.getNewslist().get(0).getNews().get(0));
        List<News.NewslistDTO.NewsDTO> newslist = news.getNewslist().get(0).getNews();

        return newslist;
    }
}
