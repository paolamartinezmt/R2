package com.cacharrero.model;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;


/**
 * @ autor Paola Martinez
 *
 **/
@Data
@Builder
@Document(collection = "usuarios")
public class User {
    /**
     *Atributo ID
     */
    @Id
    private Integer id;
    /**
     * Atributo identificación
     */
    private String identification;
    /**
     *  Atributo dirección
     */
    private String address;
    /**
     *  Atributo teléfono
     */
    private String cellPhone;
    /**
     * Atributo Email
     */
    private String email;
    /**
     * Atributo Password
     */
    private String password;
    /**
     * Atributo Name
     */
    private String name;
    /**
    * Atributo zone
     */
    private String zone;
    /**
    * Atributo type
     */
    private String type;
}

