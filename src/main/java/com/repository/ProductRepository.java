package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Customer;
import com.entity.Product;

@Repository
public interface ProductRepository extends  JpaRepository<Product,Integer>{


} 