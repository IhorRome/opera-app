package opera.service;

import opera.model.Order;
import opera.model.ShoppingCart;
import opera.model.User;

import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
