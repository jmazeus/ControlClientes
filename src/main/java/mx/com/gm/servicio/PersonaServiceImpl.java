package mx.com.gm.servicio;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.IPersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jmartinz
 */
@Service
@Slf4j
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> ListaPersonas() {
        log.info("Consultando listado de personas");
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        log.info("Guardando la persona " + persona);
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        log.info("Eliminando la persona " + persona);
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        log.info("Buscando la persona " + persona);
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }

}
