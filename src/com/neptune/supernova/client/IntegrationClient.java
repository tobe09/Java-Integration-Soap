package com.neptune.supernova.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.neptune.supernova.IntegrationSoap;
import com.neptune.supernova.response.NESingleResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.NameInquiryRequestData;


public class IntegrationClient {
	public static void main(String[] args) throws Exception {

	    URL url = new URL("http://localhost:1578/ws/integration?wsdl");
        QName qname = new QName("http://supernova.neptune.com/", "IntegrationSoapImplService");

      
        //1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above/* 
       
        Service service = Service.create(url, qname);

        IntegrationSoap soapObj = service.getPort(IntegrationSoap.class);
        
        NameInquiryRequestData request = new NameInquiryRequestData();
        request.setAccountNumber("1002");
        
        NESingleResponse response = soapObj.nameInquirySubmit(request);
        
        System.out.println(response.getAccountNumber());        
	}
}
