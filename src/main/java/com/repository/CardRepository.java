package com.repository;


//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Card;

@Repository
public interface CardRepository extends CrudRepository<Card,Integer>{


} 