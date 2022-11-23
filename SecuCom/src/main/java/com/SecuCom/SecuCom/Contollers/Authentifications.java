package com.SecuCom.SecuCom.Contollers;

import com.SecuCom.SecuCom.Modeles.Lows;
import com.SecuCom.SecuCom.Modeles.Users;
import com.SecuCom.SecuCom.Modeles.login;
import com.SecuCom.SecuCom.Modeles.signup;
import com.SecuCom.SecuCom.Repositories.RepositoryLow;
import com.SecuCom.SecuCom.Repositories.RepositoryUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;

@RestController
//@RequestMapping("/api/auth")
public class Authentifications {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RepositoryUsers repositoryUsers;
    @Autowired
    private RepositoryLow repositoryLow;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody login Login){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                Login.getUsernameOrEmail(), Login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("Connexion reussie avec succès!.", HttpStatus.OK);
    }

    @RolesAllowed({"USER"})
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody signup signup){

        // add check for username exists in a DB
        if(repositoryUsers.existsByUsername(signup.getUsername())){
            return new ResponseEntity<>("Collaborateur existe déja !", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(repositoryUsers.existsByEmail(signup.getEmail())){
            return new ResponseEntity<>("Cet email existe déja", HttpStatus.BAD_REQUEST);
        }

        // create user object
        Users user = new Users();
        user.setName(signup.getName());
        user.setUsername(signup.getUsername());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));


        Lows roles = repositoryLow.findByName("ADMIN").get();
        user.setLows(Collections.singleton(roles));

        repositoryUsers.save(user);


        return new ResponseEntity<>("Collaborateur ajouté avec succès :", HttpStatus.OK);

    }





}

