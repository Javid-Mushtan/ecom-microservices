package com.ecommerce.order.controllers;

import com.ecommerce.order.dto.OrderResponse;
import com.ecommerce.order.services.OrderService;
import lombok.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    private static final Log logger = LogFactory.getLog(OrderController.class);
    
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestHeader("X-User-ID") String userId) {
        return orderService.createOrder(userId)
                .map(orderResponse -> new ResponseEntity<>(orderResponse, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/order")
    public String getAllOrders(@RequestParam String item) {
        logger.info("Order received for item: {}" + item);
        logger.error("huthththoooooooo");
        logger.warn("hello this is warn");
        return "Order received for item: " + item;
    }

}
