package com.example.auth._Services;

import com.example.auth.Enteties.Categorie;

import java.util.List;
import org.springframework.security.core.Authentication;


public interface ICategorieService
{
    Categorie add(Categorie categorie,Authentication connectedUser);
    void delete(long id);
    Categorie update(Categorie categorie);
    Categorie find(long id);
    List<Categorie> findAll();
}
