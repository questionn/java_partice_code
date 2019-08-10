package com.tom.mapper;

import com.tom.po.Orders;

import java.util.List;

public interface OrdersMapper {
    //商品表到用户

    public List<Orders> queryOrderToUser();
}
