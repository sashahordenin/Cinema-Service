package com.spring.dao;

import com.spring.model.Order;
import com.spring.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
