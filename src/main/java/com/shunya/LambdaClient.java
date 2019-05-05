package com.shunya;

import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class LambdaClient {

    public static void main(String[] args) {
        final NumberService uppercaseService = LambdaInvokerFactory.builder()
                .lambdaClient(AWSLambdaClientBuilder.defaultClient())
                .build(NumberService.class);

        LambdaInput request = new LambdaInput();
        request.setInput(12345);
        final LambdaOutput lambdaOutput = uppercaseService.reverse(request);
        System.out.println("lambda response = " + lambdaOutput.getResult());
    }
}
