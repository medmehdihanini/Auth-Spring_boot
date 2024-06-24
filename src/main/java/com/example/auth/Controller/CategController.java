package com.example.auth.Controller;

import com.example.auth.Enteties.Categorie;
import com.example.auth.Enteties.Service;
import com.example.auth._Services.ICategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("categ")
@RestController
public class CategController {
    private final ICategorieService ICategService;

@GetMapping("getAll")
    public List<Categorie> getAll() {return ICategService.findAll();
}
    @PostMapping("add")
    public Categorie add(@RequestBody Categorie cat) {
        return ICategService.add(cat);
    }


    @PutMapping("Update")
    public Categorie Update(@RequestBody Categorie cat){
        return ICategService.update(cat);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        ICategService.delete(id);}

    @DeleteMapping("get/{id}")
    public Categorie getone(@PathVariable long id){
        return ICategService.find(id);}

}
