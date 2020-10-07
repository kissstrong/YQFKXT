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
    //获取疫情相关新闻信息
    @Override
    public List<News.NewslistDTO.NewsDTO> getNewsList() {
        String url = "http://api.tianapi.com/txapi/ncov/index?key=e00a38cd23dbae5817bbaee5a5b46f82";
        List<News.NewslistDTO.NewsDTO> newslist = getNews(url).getNewslist().get(0).getNews();

        return newslist;
    }
    //根据日期获得新闻数据
    @Override
    public List<News.NewslistDTO.NewsDTO> getNewsListByDate(String date) {
        String url = "http://api.tianapi.com/txapi/ncov/index?key=e00a38cd23dbae5817bbaee5a5b46f82&date="+date;
        List<News.NewslistDTO.NewsDTO> newslist = getNews(url).getNewslist().get(0).getNews();
        return newslist;
    }
    //获取疫情数据信息 中国，外国，全球
    @Override
    public News.NewslistDTO.DescDTO getDesc() {
        String url = "http://api.tianapi.com/txapi/ncov/index?key=e00a38cd23dbae5817bbaee5a5b46f82";
        News.NewslistDTO.DescDTO desc = getNews(url).getNewslist().get(0).getDesc();
        return desc;
    }


    private News getNews(String url) {
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        News news = JSON.parseObject(json, News.class);
        return news;
    }
}
