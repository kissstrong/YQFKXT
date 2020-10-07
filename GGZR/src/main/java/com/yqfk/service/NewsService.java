package com.yqfk.service;

import com.yqfk.pojo.News;

import java.util.List;

public interface NewsService {
    //获取疫情相关新闻信息
    List<News.NewslistDTO.NewsDTO> getNewsList ();
    //根据日期获得新闻数据
    List<News.NewslistDTO.NewsDTO> getNewsListByDate (String date);
    //获取疫情数据信息 中国，外国，全球
    News.NewslistDTO.DescDTO getDesc();
}
