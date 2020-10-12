package com.yqfk.service.Impl;

import com.yqfk.mapper.OrderMapper;
import com.yqfk.pojo.Order;
import com.yqfk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> queryAll() {
        return orderMapper.queryAll();
    }

    @Override
    public Order queryOrderByOid(long oId) {
        return orderMapper.queryOrderByOid(oId);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void deleteOrder(long oId) {
        orderMapper.deleteOrder(oId);
    }

    @Override
    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }


}
