package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FinancialInstitutionListResponses {
	//@XmlElement(required = true, nillable = true)
	private String batchNumber;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String numberOfRecords;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	public FinancialInstitutionListResponses() {
	}
	
	public FinancialInstitutionListResponses(String batchNumber, String destinationInstitutionCode, String channelCode,
			String numberOfRecords, String responseCode) {
		this.batchNumber = batchNumber;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.numberOfRecords = numberOfRecords;
		this.responseCode = responseCode;
	}
		
}
