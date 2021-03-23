/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jmartinz
 */
public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
