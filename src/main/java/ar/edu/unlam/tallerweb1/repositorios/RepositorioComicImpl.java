package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Comic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RepositorioComic")
public class RepositorioComicImpl implements RepositorioComic{

    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioComicImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Comic> todosLosComics() {
        List<Comic> comics = sessionFactory.getCurrentSession().createCriteria(Comic.class)
                .list();
        return comics;
    }
}
