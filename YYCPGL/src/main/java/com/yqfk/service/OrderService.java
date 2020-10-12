package com.yqfk.service;

import com.yqfk.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryAll();
    Order queryOrderByOid(long oId);
    void addOrder(Order order);
    void deleteOrder(long oId);
    void updateOrder(Order order);
}
