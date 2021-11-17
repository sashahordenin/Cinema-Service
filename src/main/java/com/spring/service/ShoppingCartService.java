package com.spring.service;

import com.spring.model.MovieSession;
import com.spring.model.ShoppingCart;
import com.spring.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
