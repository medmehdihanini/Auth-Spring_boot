package com.example.auth.BlockChaine;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;

import java.math.BigInteger;

@AllArgsConstructor
@Service
public class PaymentContractService {

    private final PaymentContract paymentContract;

    public RemoteCall<TransactionReceipt> addPayment(String payer, String payee, BigInteger amount) {
        return paymentContract.addPayment(payer, payee, amount);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> getPayment(BigInteger index) {
        return paymentContract.getPayment(index);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> payments(BigInteger param0) {
        return paymentContract.payments(param0);
    }
}
