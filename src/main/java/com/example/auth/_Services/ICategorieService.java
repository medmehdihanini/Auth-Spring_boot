package com.example.auth._Services;

import com.example.auth.Enteties.Categorie;

import java.util.List;

public interface ICategorieService
{
    Categorie add(Categorie categorie);
    void delete(long id);
    Categorie update(Categorie categorie);
    Categorie find(long id);
    List<Categorie> findAll();
}
