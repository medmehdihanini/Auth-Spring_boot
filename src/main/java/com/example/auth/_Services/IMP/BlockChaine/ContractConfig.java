package com.example.auth._Services.IMP.BlockChaine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.ContractGasProvider;

@Configuration
public class ContractConfig {

    @Bean
    public PaymentContract paymentContract(Web3j web3j, ContractGasProvider contractGasProvider) {
        String contractAddress = "0xc4c9dd326452e2c708dD09cc6b60F554eBBDb998";
        Credentials credentials = Credentials.create("0x3c3f0e6fdea379bc17271b6196f68111287df9ed3e146068ae1b388f71398c41");
        return PaymentContract.load(contractAddress, web3j, credentials, contractGasProvider);
    }
}
