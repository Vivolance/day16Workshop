package SSF.day16Workshop.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import SSF.day16Workshop.model.Order;

@Repository
public class OrderRepository {

	@Autowired @Qualifier("my-redis")
	private RedisTemplate<String, String> template;

	public void insertOrder(Order order) {
	}
}
