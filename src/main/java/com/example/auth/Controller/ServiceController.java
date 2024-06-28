package com.example.auth.Controller;

import com.example.auth.Enteties.Service;
import com.example.auth.Enteties.User;
import com.example.auth._Services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("service")
@RestController
@CrossOrigin(origins = "*")

public class ServiceController {
    private final IService Iservice;
    @GetMapping("All")
    public List<Service> GetAll(){return Iservice.findAll();}


    @PostMapping("add")
    public Service add(@RequestBody Service service) {
        return Iservice.addservies(service);
    }


    @PutMapping("Update")
    public Service Update(@RequestBody Service s){
        return Iservice.update(s);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable long id){
        Iservice.delete(id);}

    @GetMapping("get/{id}")
    public Service getone(@PathVariable long id){
        return Iservice.find(id);}

}
