package com.SecuCom.SecuCom.Modeles;

import lombok.Data;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public  Long id;
    private String name;
    private String username;
    private String email;
    private String password;



    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Lows> lows;
}
