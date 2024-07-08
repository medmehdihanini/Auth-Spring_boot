package com.example.auth._Services.IMP.BlockChaine;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.0.
 */
@SuppressWarnings("rawtypes")
public class PaymentContract extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b506106db8061001c5f395ff3fe608060405234801561000f575f80fd5b506004361061003f575f3560e01c80633280a8361461004357806350d8667f1461006e57806387d8178914610083575b5f80fd5b6100566100513660046103cb565b610096565b60405161006593929190610410565b60405180910390f35b61008161007c3660046104e4565b610208565b005b6100566100913660046103cb565b61028b565b6060805f805f85815481106100ad576100ad610552565b905f5260205f2090600302016040518060600160405290815f820180546100d390610566565b80601f01602080910402602001604051908101604052809291908181526020018280546100ff90610566565b801561014a5780601f106101215761010080835404028352916020019161014a565b820191905f5260205f20905b81548152906001019060200180831161012d57829003601f168201915b5050505050815260200160018201805461016390610566565b80601f016020809104026020016040519081016040528092919081815260200182805461018f90610566565b80156101da5780601f106101b1576101008083540402835291602001916101da565b820191905f5260205f20905b8154815290600101906020018083116101bd57829003601f168201915b5050509183525050600291909101546020918201528151908201516040909201519097919650945092505050565b60408051606081018252848152602081018490529081018290525f8054600181018255908052815160039091027f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5630190819061026490826105ea565b506020820151600182019061027990826105ea565b50604082015181600201555050505050565b5f8181548110610299575f80fd5b905f5260205f2090600302015f91509050805f0180546102b890610566565b80601f01602080910402602001604051908101604052809291908181526020018280546102e490610566565b801561032f5780601f106103065761010080835404028352916020019161032f565b820191905f5260205f20905b81548152906001019060200180831161031257829003601f168201915b50505050509080600101805461034490610566565b80601f016020809104026020016040519081016040528092919081815260200182805461037090610566565b80156103bb5780601f10610392576101008083540402835291602001916103bb565b820191905f5260205f20905b81548152906001019060200180831161039e57829003601f168201915b5050505050908060020154905083565b5f602082840312156103db575f80fd5b5035919050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b606081525f61042260608301866103e2565b828103602084015261043481866103e2565b915050826040830152949350505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f830112610468575f80fd5b813567ffffffffffffffff81111561048257610482610445565b604051601f8201601f19908116603f0116810167ffffffffffffffff811182821017156104b1576104b1610445565b6040528181528382016020018510156104c8575f80fd5b816020850160208301375f918101602001919091529392505050565b5f805f606084860312156104f6575f80fd5b833567ffffffffffffffff81111561050c575f80fd5b61051886828701610459565b935050602084013567ffffffffffffffff811115610534575f80fd5b61054086828701610459565b93969395505050506040919091013590565b634e487b7160e01b5f52603260045260245ffd5b600181811c9082168061057a57607f821691505b60208210810361059857634e487b7160e01b5f52602260045260245ffd5b50919050565b601f8211156105e557805f5260205f20601f840160051c810160208510156105c35750805b601f840160051c820191505b818110156105e2575f81556001016105cf565b50505b505050565b815167ffffffffffffffff81111561060457610604610445565b610618816106128454610566565b8461059e565b6020601f82116001811461064a575f83156106335750848201515b5f19600385901b1c1916600184901b1784556105e2565b5f84815260208120601f198516915b828110156106795787850151825560209485019460019092019101610659565b508482101561069657868401515f19600387901b60f8161c191681555b50505050600190811b0190555056fea2646970667358221220d8bff6bd30da446bc394e7dd1d18dc78f01af3d967c370f5264a66ad6ea81ca864736f6c634300081a0033";

    private static String librariesLinkedBinary;

    public static final String FUNC_ADDPAYMENT = "addPayment";

    public static final String FUNC_GETPAYMENT = "getPayment";

    public static final String FUNC_PAYMENTS = "payments";

    @Deprecated
    protected PaymentContract(String contractAddress, Web3j web3j, Credentials credentials,
                              BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PaymentContract(String contractAddress, Web3j web3j, Credentials credentials,
                              ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PaymentContract(String contractAddress, Web3j web3j,
                              TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PaymentContract(String contractAddress, Web3j web3j,
                              TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }


    public RemoteFunctionCall<TransactionReceipt> addPayment(String _payer, String _payee,
                                                             BigInteger _amount) {
        final Function function = new Function(
                FUNC_ADDPAYMENT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_payer),
                        new org.web3j.abi.datatypes.Utf8String(_payee),
                        new org.web3j.abi.datatypes.generated.Uint256(_amount)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<String, String, BigInteger>> getPayment(BigInteger index) {
        final Function function = new Function(FUNC_GETPAYMENT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, BigInteger>>(function,
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<Tuple3<String, String, BigInteger>> payments(BigInteger param0) {
        final Function function = new Function(FUNC_PAYMENTS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, BigInteger>>(function,
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static PaymentContract load(String contractAddress, Web3j web3j, Credentials credentials,
                                       BigInteger gasPrice, BigInteger gasLimit) {
        return new PaymentContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PaymentContract load(String contractAddress, Web3j web3j,
                                       TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new PaymentContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PaymentContract load(String contractAddress, Web3j web3j, Credentials credentials,
                                       ContractGasProvider contractGasProvider) {
        return new PaymentContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PaymentContract load(String contractAddress, Web3j web3j,
                                       TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new PaymentContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<PaymentContract> deploy(Web3j web3j, Credentials credentials,
                                                     ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PaymentContract.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<PaymentContract> deploy(Web3j web3j, Credentials credentials,
                                                     BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PaymentContract.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<PaymentContract> deploy(Web3j web3j,
                                                     TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(PaymentContract.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<PaymentContract> deploy(Web3j web3j,
                                                     TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(PaymentContract.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
