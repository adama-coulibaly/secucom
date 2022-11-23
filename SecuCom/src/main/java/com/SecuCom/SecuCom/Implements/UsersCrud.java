package com.SecuCom.SecuCom.Implements;

import com.SecuCom.SecuCom.Modeles.Users;

import java.util.List;

public interface UsersCrud {

    Users Supprimer(Long id_users);  // LA METHODE PERMETTANT DE SUPPRIMER UN COLLABORATEUR

    String Modifier(Users users);   // LA METHODE PERMETTANT DE MODIFIER UN COLLABORATEUR

    List<Users> Afficher();       // LA METHODE PERMETTANT D'AFFICHER UN COLLABORATEUR

    Users Ajouter(Users utilisateur); // LA METHODE PERMETTANT D'AJOUTER UN COLLABORATEUR
}
