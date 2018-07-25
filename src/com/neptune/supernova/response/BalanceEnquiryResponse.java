package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BalanceEnquiryResponse {
	
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String AuthorizationCode;
	//@XmlElement(required = true, nillable = true)
	private String TargetAccountName;
	//@XmlElement(required = true, nillable = true)
	private String TargetBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String TargetAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String AvailableBalance;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	public BalanceEnquiryResponse() {
	}
	
	public BalanceEnquiryResponse(String sessionId, String destinationInstitutionCode, String channelCode,
			String authorizationCode, String targetAccountName, String targetBankVerificationNumber,
			String targetAccountNumber, String availableBalance, String responseCode) {
		
		this.sessionId = sessionId;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.AuthorizationCode = authorizationCode;
		this.TargetAccountName = targetAccountName;
		this.TargetBankVerificationNumber = targetBankVerificationNumber;
		this.TargetAccountNumber = targetAccountNumber;
		this.AvailableBalance = availableBalance;
		this.responseCode = responseCode;
	}
	
	

}
