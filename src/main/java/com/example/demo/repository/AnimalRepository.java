package com.example.demo.repository;

import com.example.demo.model.Animal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends ReactiveMongoRepository<Animal,String>{

}