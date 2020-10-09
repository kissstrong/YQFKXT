package com.yqfk.service.Impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yqfk.mapper.ProductMapper;
import com.yqfk.pojo.Product;
import com.yqfk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryAll() {
        return productMapper.queryAll();
    }

    @Override
    public PageInfo queryAll(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        List<Product> products = productMapper.queryAll();
        PageInfo<Product> pageInfo = new PageInfo(products);
        return pageInfo;
    }

    @Override
    public List<Product> searchProduct(String keyword) {
        return productMapper.searchProduct(keyword);
    }

    @Override
    public PageInfo queryAllToPage(int page, int pageSize, String keyword) {
        PageHelper.startPage(page,pageSize);
        List<Product> products = productMapper.searchProduct(keyword);
        PageInfo<Product> pageInfo = new PageInfo(products);
        return pageInfo;
    }

    @Override
    public List<Product> queryBucket(int uId) {
        return productMapper.queryBucket(uId);
    }

    @Override
    public void joinBucket(Map<String,Integer> map) {
        productMapper.joinBucket(map);
    }

    @Override
    public void removeFromBucket(int pId) {
        productMapper.removeFromBucket(pId);
    }

    @Override
    public Product queryProductById(int pId) {
        return productMapper.queryProductById(pId);
    }

    @Override
    public void removeList(List<Product> products) {
        productMapper.removeList(products);
    }
}
