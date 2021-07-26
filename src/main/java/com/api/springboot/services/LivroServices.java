package com.api.springboot.services;

import com.api.springboot.domain.Categoria;
import com.api.springboot.domain.Livro;
import com.api.springboot.repositories.LivroRepository;
import com.api.springboot.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServices {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaServices categoriaServices;

    public Livro findById(Integer id){
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaServices.findById(id_cat);
        return  livroRepository.findAllByCategoria(id_cat);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updatedata(newObj, obj);
        return livroRepository.save(newObj);
    }

    private void updatedata(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Integer id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaServices.findById(id_cat);
        obj.setCategoria(cat);
        return livroRepository.save(obj);
    }

    public void delete(Integer id) {
        Livro obj = findById(id);
        livroRepository.delete(obj);
    }
}
