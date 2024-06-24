package com.example.auth._Services;

import com.example.auth.Enteties.Service;

import java.util.List;

public interface IService {
    Service addservies(Service service);
    void delete(long id);
    Service update(Service service);
    Service find(long id);
    List<Service> findAll();
}
