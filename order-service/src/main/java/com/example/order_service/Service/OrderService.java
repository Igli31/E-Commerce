package com.example.order_service.Service;

import com.example.order_service.DTO.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    OrderDTO updateOrder(Long id, OrderDTO orderDTO);
    void deleteOrderById(Long id);
}
