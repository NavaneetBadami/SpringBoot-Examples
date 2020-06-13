package com.group.aws.lambda;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.CognitoEvent;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private LambadaRequest input;

//    @Before
//    public void createInput() throws IOException {
//        input = TestUtils.parse("/cognito-sync-event.json", CognitoEvent.class);
//    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {
        LambdaFunctionHandler handler = new LambdaFunctionHandler();
        input = new LambadaRequest();
        input.setCity("PUNE");
        input.setName("NAVANEET");
        Context ctx = createContext();

        LambadaResponse output = handler.handleRequest(input, ctx);

        if (output != null) {
            System.out.println(output.toString());
        }
    }
}
