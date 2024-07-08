package com.example.auth._Services.IMP.BlockChaine;

import com.example.auth._Services.IMP.BlockChaine.PaymentContractService;
import kotlin.PublishedApi;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentContractController {

    private final PaymentContractService paymentContractService;


    @PublishedApi
    @PostMapping("/add")
    public ResponseEntity<String> addPayment(
            @RequestParam String payer,
            @RequestParam String payee,
            @RequestParam BigInteger amount) {
        try {
            TransactionReceipt receipt = paymentContractService.addPayment(payer, payee, amount).send();
            return ResponseEntity.ok("Payment added with transaction hash: " + receipt.getTransactionHash());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding payment: " + e.getMessage());
        }
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> getPayment(@PathVariable BigInteger index) {
        try {
            Tuple3<String, String, BigInteger> payment = paymentContractService.getPayment(index).sendAsync().get();
            return ResponseEntity.ok(payment);
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(500).body("Error retrieving payment: " + e.getMessage());
        }
    }

    @GetMapping("/all/{index}")
    public ResponseEntity<?> getAllPayments(@PathVariable BigInteger index) {
        try {
            Tuple3<String, String, BigInteger> payment = paymentContractService.payments(index).sendAsync().get();
            return ResponseEntity.ok(payment);
        } catch (InterruptedException | ExecutionException e) {
            return ResponseEntity.status(500).body("Error retrieving payment: " + e.getMessage());
        }
    }
}
