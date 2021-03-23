package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author jmartinz
 */
@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("ejecutando el controlador Spring MVC");
        var personas = personaService.ListaPersonas();
        model.addAttribute("personas", personas);

        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores) {

        if (errores.hasErrors()) {
            return "modificar";
        }
        log.info("Guardando la persona " + persona);
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {
        log.info("Modificacand la persona " + persona);
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model) {
        log.info("Eliminando la persona " + persona);
        personaService.eliminar(persona);
        model.addAttribute("persona", persona);
        return "redirect:/";
    }
}
