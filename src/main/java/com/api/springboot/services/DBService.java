package com.api.springboot.services;
import com.api.springboot.domain.Categoria;
import com.api.springboot.domain.Livro;

import com.api.springboot.repositories.CategoriaRepository;
import com.api.springboot.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Categoria cat1 = new Categoria(null, "Informatica","Livro de TI");
        Categoria cat2 = new Categoria(null, "Terror","Livro de terror");
        Categoria cat3 = new Categoria(null, "Gibis","Quadrinhos");

        Livro l1 = new Livro(null, "Clean Code","Robert Martin", "Lorem ipsun", cat1);
        Livro l2 = new Livro(null, "Dragon Ball Z","Japa", "Lorem ipsun", cat3);
        Livro l3 = new Livro(null, "Turma da Monica","Mauricio de souza", "Lorem ipsun", cat3);
        Livro l4 = new Livro(null, "It, A coisa","Stephen King", "Lorem ipsun", cat2);
        Livro l5 = new Livro(null, "Carrie, A estranha","Stephen King", "Lorem ipsun", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1));
        cat2.getLivros().addAll(Arrays.asList(l4, l5));
        cat3.getLivros().addAll(Arrays.asList(l2,l3));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
