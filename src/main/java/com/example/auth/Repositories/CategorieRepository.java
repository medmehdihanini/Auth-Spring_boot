package com.example.auth.Repositories;

import com.example.auth.Enteties.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}