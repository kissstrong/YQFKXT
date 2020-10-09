package com.yqfk.mapper;

import com.yqfk.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {

    List<Product> queryAll();
    List<Product> searchProduct(String keyword);
    List<Product> queryBucket(int uId);
    void joinBucket(@Param("map") Map<String,Integer> map);
    void removeFromBucket(int pId);
    Product queryProductById(int pId);
    void removeList(List<Product> products);

}
