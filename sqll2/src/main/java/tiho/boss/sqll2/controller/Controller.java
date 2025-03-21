package tiho.boss.sqll2.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tiho.boss.sqll2.Persons;
import tiho.boss.sqll2.repository.SRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class Controller {
    private SRepository repository;

    @GetMapping("/by-city")
    public List<Persons> findByCityOfLiving(@RequestParam String city) {
        return repository.findByCityOfLiving(city);
    }
    @GetMapping("/by-age")
    public List<Persons> findByAgeLessThanOrderByAge(@RequestParam int age) {
        return repository.findById_Age(age);
    }
    @GetMapping("/by-name-and-surname")
    public Optional<Persons> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return repository.findById_NameAndId_Surname(name, surname);
    }
}