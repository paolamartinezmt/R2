package com.cacharrero.controller;
import com.cacharrero.model.User;
import com.cacharrero.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @ autor Paola Martinez
 *
 **/
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/user/")
public class UserController {
    /**
     * atributo API
     */
  @Autowired
    private UserServices userServices;
    /**
     * Metodo para obtener todos los usarios
     * @return
     */
    @GetMapping("all")
    public List<User> getAll() {
        return userServices.getAll();
    }
    /**
     * Metodo para crear un usuario
     * @param
     * @return
     */
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userServices.newUser(user);
    }
    /**
     * metodo para verificar un correo
     * @param email
     * @return
     */
    @GetMapping("{email}")
    public boolean verifyEmail(@PathVariable("email") String email)
    {
        return userServices.verifyEmail(email);
    }
    /**
     * Metodo verificar si existe un usuario por su correo y contraseña
     * @param email
     * @param pass
     * @return
     */
    @GetMapping("{email}/{pass}")
    public User verifyUser(@PathVariable("email") String email, @PathVariable("pass") String pass)
    {
        return userServices.verifyUser(email,pass);
    }
}