package com.yqfk.service;

import com.yqfk.pojo.Product;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> queryAll();
    PageInfo queryAll(int page,int pageSize);
    List<Product> searchProduct(String keyword);
    PageInfo queryAllToPage(int page,int pageSize,String keyword);

    List<Product> queryBucket(int uId);
    void joinBucket(Map<String,Integer> map);
    void removeFromBucket(int pId);
    Product queryProductById(int pId);
    void removeList(List<Product> products);
}
