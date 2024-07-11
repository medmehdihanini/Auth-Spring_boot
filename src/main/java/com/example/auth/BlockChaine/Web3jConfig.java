package com.example.auth.BlockChaine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Configuration
public class Web3jConfig {
    @Bean
    public Web3j web3j() {

        return Web3j.build(new HttpService("http://127.0.0.1:7545")); 
    }


    @Bean
    public ContractGasProvider contractGasProvider() {
        BigInteger gasPrice = BigInteger.valueOf(20000000000L); // Exemple de prix du gaz
        BigInteger gasLimit = BigInteger.valueOf(6721975); // Exemple de limite du gaz
        return new StaticGasProvider(gasPrice, gasLimit);
    }
}
