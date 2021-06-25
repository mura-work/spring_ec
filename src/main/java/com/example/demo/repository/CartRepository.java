package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Employee;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByEmployee(Employee emp);
}
