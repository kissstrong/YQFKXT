package com.yqfk.service;

import com.yqfk.pojo.News;

import java.util.List;

public interface NewsService {
    List<News.NewslistDTO.NewsDTO> getNewsList ();
}
