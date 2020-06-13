package com.group.ws.endpoints;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.group.ws.bean.InputSOATest;
import com.group.ws.bean.ObjectFactory;
import com.group.ws.bean.OutputSOATest;



@Endpoint
public class WebServiceEndpoint {

	private static final String NAMESPACE_URI = "http://javainuse.com";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
	@ResponsePayload
	public OutputSOATest hello(@RequestPayload InputSOATest request) {

		String outputString = "Hello " + request.getTest() + "!";

		ObjectFactory factory = new ObjectFactory();
		OutputSOATest response = factory.createOutputSOATest();
		response.setResult(outputString);

		return response;
	}
}