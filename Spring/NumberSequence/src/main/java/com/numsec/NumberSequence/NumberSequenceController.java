package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class NumberSequenceController {
    @GetMapping("/sequence/{n}")
    public List<Integer> getNumberSequence(@PathVariable int n) {
        return IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
    }
}