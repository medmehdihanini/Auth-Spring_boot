package com.example.auth.BlockChaine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Configuration
public class ContractConfig {

    @Bean
    public PaymentContract paymentContract(Web3j web3j, ContractGasProvider contractGasProvider) {
        String contractAddress = "0x880fBa0afe7f266f82C8d7370F936d9Def52e277";
        Credentials credentials = Credentials.create("0x5ee84e69ab37c52646c2ab4ab26317b8830bb5a72cfafb471458d19b15afe398");
        return PaymentContract.load(contractAddress, web3j, credentials, contractGasProvider);
    }
}
