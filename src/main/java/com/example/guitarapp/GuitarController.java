package com.example.guitarapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/guitars")
public class GuitarController {

    @Autowired
    private GuitarRepository guitarRepository;

    @GetMapping
    public List<Guitar> getAllGuitars() {
        return guitarRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guitar getGuitarById(@PathVariable Long id) {
        return guitarRepository.findById(id).orElseThrow(() -> new RuntimeException("Guitar not found"));
    }

    @PostMapping
    public Guitar createGuitar(@RequestBody Guitar guitar) {
        return guitarRepository.save(guitar);
    }

    @PutMapping("/{id}")
    public Guitar updateGuitar(@PathVariable Long id, @RequestBody Guitar guitarDetails) {
        Guitar guitar = guitarRepository.findById(id).orElseThrow(() -> new RuntimeException("Guitar not found"));

        guitar.setBrand(guitarDetails.getBrand());
        guitar.setModel(guitarDetails.getModel());
        guitar.setYearOfProduction(guitarDetails.getYearOfProduction());
        guitar.setDescription(guitarDetails.getDescription());

        return guitarRepository.save(guitar);
    }

    @DeleteMapping("/{id}")
    public void deleteGuitar(@PathVariable Long id) {
        guitarRepository.deleteById(id);
    }
}