package com.academia.biblioteca.academiabiblioteca.helloacademia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcademiaHelloControler {
    @GetMapping("/academia")
    public String helloAcademia() {
        return "Hello Academia";
    }

    @GetMapping("/academia-bean")
    public HelloAcademiaBean helloAcademiaBean() {
        return new HelloAcademiaBean("Hello Academia com beans");
    }

    @GetMapping("/academia/path-variable/{name}")
    public HelloAcademiaBean helloAcademiaPathVariable(@PathVariable String name) {
        return new HelloAcademiaBean("Bom dia enconado " + name);
    }
}
