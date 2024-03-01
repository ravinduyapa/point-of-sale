package com.example.standardPractice.repo;

import com.example.standardPractice.entity.Item;
import com.example.standardPractice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order,Integer> {
}
