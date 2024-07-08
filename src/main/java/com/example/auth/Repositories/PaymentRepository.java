package com.example.auth.Repositories;

import com.example.auth._Services.IMP.BlockChaine.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}