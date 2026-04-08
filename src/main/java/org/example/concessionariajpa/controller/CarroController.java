package org.example.concessionariajpa.controller;

import jakarta.validation.Valid;
import org.example.concessionariajpa.model.Carro;
import org.example.concessionariajpa.service.CarroService;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    CarroService carroService;

    public CarroController(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping("/{id}")
    public Carro buscar(@PathVariable Long id){
        return carroService.buscar(id);
    }

    @GetMapping
    public List<Carro> listar(){
        return carroService.listar();
    }

    @PostMapping
    public Carro salvar(@RequestBody @Valid Carro carro){
        return carroService.salvar(carro);
    }

    @PutMapping
    public Carro atualizar(@RequestBody Carro carro, @PathVariable Long id){
        return carroService.atualizar(carro, id);
    }

    @DeleteMapping
    public void deletar(@PathVariable Long id){
        carroService.deletar(id);
    }

    @GetMapping("/buscarPorMarca")
    public List<Carro> buscarPorMarca(@RequestParam String marca){
        return carroService.buscarPorMarca(marca);
    }
}
