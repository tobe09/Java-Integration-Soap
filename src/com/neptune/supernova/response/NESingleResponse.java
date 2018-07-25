package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NESingleResponse {
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String accountNumber;
	//@XmlElement(required = true, nillable = true)
	private String accountName;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	//@XmlElement(required = true, nillable = true)
	private String kycLevel;
	//@XmlElement(required = true, nillable = true)
	private String bankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	
	public NESingleResponse(){		
	}
	
	public NESingleResponse(String sessionId, String channelCode, String accountNumber, 
			String accountName, String responseCode, String kycLevel, 
			String bankVerificationNumber, String destinationInstitutionCode){
		this.sessionId=sessionId;
		this.channelCode=channelCode;
		this.accountNumber=accountNumber;
		this.accountName=accountName;
		this.responseCode=responseCode;
		this.kycLevel=kycLevel;
		this.bankVerificationNumber=bankVerificationNumber;
		this.destinationInstitutionCode=destinationInstitutionCode;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getKycLevel() {
		return kycLevel;
	}

	public void setKycLevel(String kycLevel) {
		this.kycLevel = kycLevel;
	}

	public String getBankVerificationNumber() {
		return bankVerificationNumber;
	}

	public void setBankVerificationNumber(String bankVerificationNumber) {
		this.bankVerificationNumber = bankVerificationNumber;
	}

	public String getDestinationInstitutionCode() {
		return destinationInstitutionCode;
	}

	public void setDestinationInstitutionCode(String destinationInstitutionCode) {
		this.destinationInstitutionCode = destinationInstitutionCode;
	}
	
}
