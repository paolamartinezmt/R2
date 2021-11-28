package com.cacharrero.controller;


import com.cacharrero.model.Clone;
import com.cacharrero.model.User;
import com.cacharrero.services.CloneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ autor Paola Martinez
 **/
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/clone/")

public class CloneController {
    /**
     * atributo API
     */
    @Autowired
    private CloneServices cloneServices;

    /**
     * Metodo para obtener todos los usarios
     *
     * @return
     */
    @GetMapping("all")
    public List<Clone> getAll() {
        return cloneServices.getAll();
    }

    /**
     * Metodo para crear un usuario
     *
     * @param
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return cloneServices.newClone(clone);
    }
    /**
     * Metodo para borrar un usuario
     *
     * @param cloneId
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer cloneId) {
        cloneServices.deleteClone(cloneId);
    }

    /**
     * Metodo para actualizar usuario
     *
     * @param clone
     * @return
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone updateUser(@RequestBody Clone clone) {
        return cloneServices.updateclone(clone);
    }



}
