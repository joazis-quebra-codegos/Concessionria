package org.example.concessionariajpa.service;

import org.example.concessionariajpa.model.Carro;
import org.example.concessionariajpa.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository){
        this.carroRepository = carroRepository;
    }

    public Carro buscar(Long id){
        return carroRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Carro não encontrado com id: " + id));
    }

    public List<Carro> listar(){
        return carroRepository.findAll();
    }

    public Carro salvar(Carro carro){
        return carroRepository.save(carro);
    }

    public void deletar(Long id){
        buscar(id); // garante que existe
        carroRepository.deleteById(id);
    }

    public Carro atualizar(Carro carro, Long id){
        buscar(id);
        carro.setId(id);
        return carroRepository.save(carro);
    }

    public List<Carro> buscarPorMarca(String marca){
        return carroRepository.findByMarcaContainingIgnoreCase(marca);
    }

    public List<Carro> buscarPorAno(Integer ano){
        return carroRepository.findByAno(ano);
    }

    public List<Carro> buscarPorPreco(Double preco){
        return carroRepository.findByPrecoLessThan(preco);
    }
}
