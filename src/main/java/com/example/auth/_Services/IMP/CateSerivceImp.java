package com.example.auth._Services.IMP;

import com.example.auth.Enteties.Categorie;
import com.example.auth.Repositories.CategorieRepository;
import com.example.auth._Services.ICategorieService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class CateSerivceImp  implements ICategorieService {

    private CategorieRepository categorieRepository;

    @Override
    @Transactional
    public Categorie add(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void delete(long id) {
     categorieRepository.deleteById(id);
    }

    @Override
    public Categorie update(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public Categorie find(long id) {
return  categorieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
}
