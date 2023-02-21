package SSF.day16Workshop.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SSF.day16Workshop.model.Order;
import SSF.day16Workshop.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public String createNewOrder(Order order) {
		// Generating the orderId
		String orderId = UUID.randomUUID().toString().substring(0, 8);
		order.setOrderId(orderId);

		// Save the order
		orderRepo.insertOrder(order);

		return orderId;
	}

}