package com.example.auth.Enteties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@Entity
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String servicename;
    private String servicedescription;
    private double serviceprice;

    @ManyToOne
    private User user;
    @ManyToOne
    private Categorie categorie;




}
