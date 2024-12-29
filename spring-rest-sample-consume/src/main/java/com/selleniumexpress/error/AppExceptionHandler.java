package com.selleniumexpress.error;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;


@Component
public class AppExceptionHandler implements ResponseErrorHandler {
	
private	ResponseErrorHandler handler=new DefaultResponseErrorHandler();

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {

		System.out.println("Inside has error ");
		if(handler.hasError(response))
		return true;	
		
		else
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		
		System.out.println("Inside handle Error ");
		
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		
		// TODO Auto-generated method stub

	}

}
