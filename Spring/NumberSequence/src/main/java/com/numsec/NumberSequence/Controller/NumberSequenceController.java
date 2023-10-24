package com.numsec.NumberSequence.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController //Defines this class is a rest controller
public class NumberSequenceController {
    @GetMapping("/sequence/{n}") //Defines /sequence path followed by a /{n} parameter which is the number that will be sequenced
    public List<Integer> getNumberSequence(@PathVariable int n) { //Method activated by the get request. @PathVariable links the {n} variable of the path to the parameter "int n"
        return IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList()); //RestController sets as response the return value, in this case the list.
    }
}