package com.example.auth._Services.IMP.BlockChaine;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.gas.ContractGasProvider;

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
