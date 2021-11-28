package com.cacharrero.services;
import com.cacharrero.model.User;
import com.cacharrero.repository.crud.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @ autor Paola Martinez
 *
 **/
@Service
public class UserServices {
    /**
     * Atributo repositorio
     */


    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Metodo para obtener todos los usuarios
     * @return
     */
    public List<User> getAll(){
        return  userRepository.findAll();
    }

    /**
     * Metodo para crear un usuario
     * @param user
     * @return
     */

    public User newUser(User user){
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            return userRepository.save(user);
        }
        else if ( verifyEmail(user.getEmail()) == false ) {
            return userRepository.save(user);
        }
        return user;
    }

    /**
     * Metodo para verificar un correo existe en la base de datos
     * @param email
     * @return
     */

    public boolean  verifyEmail(String email){
        boolean flag = false;
        List<User> users = userRepository.findAll();
        for (User user : users){
            if (email.equals(user.getEmail())){
                flag=true;
            }
        }
        return flag;
    }

    /**
     * Metodo para verificar si un usuario existe en la base de datos
     * @param email
     * @param pass
     * @return
     */
    public User verifyUser ( String email , String pass ){
        List<User> users = userRepository.findAll();
        User notExit = User.builder().build();
        for (User user : users){
            if (email.equals(user.getEmail()) && pass.equals(user.getPassword()) ){
                return user;
            }
        }
        return notExit;
    }
}
