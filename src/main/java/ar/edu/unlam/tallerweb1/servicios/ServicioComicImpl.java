package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Comic;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioComic")
@Transactional
public class ServicioComicImpl implements ServicioComic{

    private RepositorioComic repoComic;

    @Autowired
    public ServicioComicImpl(RepositorioComic repoComic){
        this.repoComic = repoComic;
    }

    @Override
    public List<Comic> todosLosComics() {
        return repoComic.todosLosComics();
    }
}
