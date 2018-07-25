package com.neptunesoftware.endpoint;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.neptune.supernova.IntegrationSoapImpl;


@WebService(endpointInterface = "com.neptune.supernova.IntegrationSoap")
public class IntegrationPublisher {

	public static void main(String[] args) {

		String content = IntegrationSoapImpl.getInfo("systeminfo.txt", IntegrationPublisher.class);
		String[] ipPortDef = content.split(",");
		String ipAddress = ipPortDef[0].split("=")[1];
		String portNo = ipPortDef[1].split("=")[1];

		System.out.println(ipAddress + ", " + portNo);
		
	   Endpoint.publish("http://" + ipAddress + ":" + portNo + "/ws/integration", new IntegrationSoapImpl());
    }

}
