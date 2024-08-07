package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Nivel;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioNivel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioNivel")
@Transactional
public class ServicioNivelImpl implements ServicioNivel{

    private RepositorioNivel repoNivel;

    @Autowired
    public ServicioNivelImpl(RepositorioNivel repoNivel){
        this.repoNivel = repoNivel;
    }

    @Override
    public Nivel crearNivel(Integer numeroDeNivel, Integer valorMax) {
        return repoNivel.crearNivel(numeroDeNivel,valorMax);
    }

    @Override
    public Nivel traerDatosDelNivel(Integer id) {
        return repoNivel.traerDatosDelNivel(id);
    }

    @Override
    public void modificar(Nivel nivel) {
        repoNivel.modificar(nivel);
    }


}
