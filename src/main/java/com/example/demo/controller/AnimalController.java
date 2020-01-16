package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/animal")
public class AnimalController {
    @Autowired
    AnimalRepository animalRepository;

    @GetMapping
    public Flux<Animal> animalFlux() {
        return animalRepository.findAll();
    }
    @GetMapping("/{id}")
    public Mono<Animal> getAnimalById(@PathVariable String id){
        return animalRepository.findById(id);
    }
    @PutMapping("/{id}")
    public  Mono<Animal> updateAnimal(@PathVariable String id,@RequestBody Animal animal){
        return animalRepository.findById(id).flatMap(a -> {
            a.setName(animal.getName());
            a.setServer(animal.getServer());
            return animalRepository.save(a);
        });
    }

    @PostMapping
    public Mono<Animal> saveAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        return animalRepository.deleteById(id);
    }


}
