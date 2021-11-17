package com.spring.service;

import com.spring.model.Order;
import com.spring.model.ShoppingCart;
import com.spring.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
