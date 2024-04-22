package com.scaler.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhello")
public class SampleController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/{name}/{city}/{num}")
    public String name(@PathVariable("name") String name, @PathVariable("city") String city, @PathVariable("num") int num){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < num; i++){
        stringBuilder.append("Hello " + name + " from " + city + " " + i + " time! ");
        }
        return stringBuilder.toString();
    }
}
