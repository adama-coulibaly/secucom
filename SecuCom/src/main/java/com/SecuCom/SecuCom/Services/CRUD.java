package com.SecuCom.SecuCom.Services;

import com.SecuCom.SecuCom.Implements.UsersCrud;
import com.SecuCom.SecuCom.Modeles.Users;
import com.SecuCom.SecuCom.Repositories.RepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUD implements UsersCrud {

    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private RepositoryUsers repositoryUsers;

    @Override
    public Users Supprimer(Long id_users) {
        return null;
    }

    @Override
    public String Modifier(Users users) {
        return repositoryUsers.findById(users.getId()).map(
        use ->{
            use.setEmail(users.getEmail());
            use.setName(users.getName());
            use.setUsername(users.getUsername());
            use.setPassword(passwordEncoder.encode(users.getPassword()));

            repositoryUsers.save(use);
            return "Modification reussie avec succès";
        }
        ).orElseThrow(() -> new RuntimeException("Cet utilisateur n'existe pas"));

    }

    @Override
    public List<Users> Afficher() {
        return repositoryUsers.findAll();
    }

    @Override
    public Users Ajouter(Users utilisateur) {
        return null;
    }
}
