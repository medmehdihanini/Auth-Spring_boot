package com.example.auth._Services.IMP;

import com.example.auth.Repositories.ServiceRepository;
import com.example.auth._Services.IService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class ServiceImp implements IService {
    ServiceRepository serviceRepository;
    @Override
    public com.example.auth.Enteties.Service addservies(com.example.auth.Enteties.Service service) {
return   serviceRepository.save(service);
    }

    @Override
    public void delete(long id) {
        serviceRepository.deleteById(id);

    }

    @Override
    public com.example.auth.Enteties.Service update(com.example.auth.Enteties.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public com.example.auth.Enteties.Service find(long id) {
return  serviceRepository.findById(id).orElse(null);    }

    @Override
    public List<com.example.auth.Enteties.Service> findAll() {
        return serviceRepository.findAll();

    }
}
