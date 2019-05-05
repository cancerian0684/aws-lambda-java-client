package com.shunya;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface NumberService {

    @LambdaFunction(functionName = "number-reversal-java")
    LambdaOutput reverse(LambdaInput input);
}
