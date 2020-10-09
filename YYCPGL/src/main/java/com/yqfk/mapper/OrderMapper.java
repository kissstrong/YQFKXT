package com.yqfk.mapper;

import com.yqfk.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> queryAll();
    void addOrder(Order order);
    void deleteOrder(long oId);
}
