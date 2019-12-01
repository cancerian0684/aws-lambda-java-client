package com.shunya;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;
import software.amazon.awssdk.services.lambda.model.InvokeResponse;

public class HelloLambdaClient {

    public static void main(String[] args) {
        version1();
        version2();
    }

    private static void version1() {
        final NumberService uppercaseService = LambdaInvokerFactory.builder()
                .lambdaClient(AWSLambdaClientBuilder.defaultClient())
                .build(NumberService.class);

        LambdaInput request = new LambdaInput();
        request.setInput(12345);
        final LambdaOutput lambdaOutput = uppercaseService.reverse(request);
        System.out.println("lambda response = " + lambdaOutput.getResult());
    }

    public static void version2() {
        final LambdaClient lambdaClient = LambdaClient.builder().build();

        InvokeRequest req = InvokeRequest.builder().functionName("number-reversal-java")
                .payload(SdkBytes.fromUtf8String("{\n" +
                        "  \"input\" : 12345\n" +
                        "}"))
                .build();

        final InvokeResponse response = lambdaClient.invoke(req);
        System.out.println("response = " + response);
    }
}
