package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.domain.Persona;

/**
 *
 * @author jmartinz
 */
public interface IPersonaService {

    public List<Persona> ListaPersonas();

    public void guardar(Persona persona);

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);

}
