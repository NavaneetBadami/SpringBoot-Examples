package com.group.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<LambadaRequest, LambadaResponse> {

	@Override
	public LambadaResponse handleRequest(LambadaRequest request, Context context) {
		
		context.getLogger().log("Input Request --- > "+ request);
		LambadaResponse response = new LambadaResponse();	
		try {
			response.setMessage("Hello "+request.getName() +" form "+ request.getCity()+" Congrats on AWS LAMADA !!!");
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			context.getLogger().log("Exception Occured--- > "+ e.getMessage());
		}
		return response;
	}
}