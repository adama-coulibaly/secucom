package com.SecuCom.SecuCom.Contollers;

import com.SecuCom.SecuCom.Implements.UsersCrud;
import com.SecuCom.SecuCom.Modeles.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/users")
public class CrudControllers {

    @Autowired
    private UsersCrud usersCrud;


    // µµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµ

    @RolesAllowed("ADMIN")
    @GetMapping("/afficher")
    public  List<Users> AfficherUsers(){
        return usersCrud.Afficher();
    }

    // µµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµ   MODIFIER

    @PutMapping("/modifier")
    public String ModierUser(@RequestBody Users users){

        usersCrud.Modifier(users);
        return "Modification reussie avec succès";
    }

}
