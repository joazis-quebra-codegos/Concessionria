package org.example.concessionariajpa.service;

import org.example.concessionariajpa.model.Carro;
import org.example.concessionariajpa.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    public Carro buscar(Long id){
        return carroRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public List<Carro> listar(){
        return carroRepository.findAll();
    }

    public Carro salvar(Carro carro){
        return carroRepository.save(carro);
    }

    public void deletar(Long id){
        carroRepository.deleteById(id);
    }

    public Carro atualizar(Carro carro, Long id){
        buscar(id);
        carro.setId(id);
        return carroRepository.save(carro);
    }
}
