package com.api.springboot.services;

import com.api.springboot.domain.Categoria;
import com.api.springboot.dtos.CategoriaDTO;
import com.api.springboot.repositories.CategoriaRepository;
import com.api.springboot.services.exceptions.DataIntegrityViolationException;
import com.api.springboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! ID " + id ));
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return  categoriaRepository.save(obj);

    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoriaRepository.deleteById(id);
        }catch (org.springframework.dao.DataIntegrityViolationException e){
            throw  new DataIntegrityViolationException("Categoria não pode ser deletado! Possui livros cadastrados");
        }

    }
}
