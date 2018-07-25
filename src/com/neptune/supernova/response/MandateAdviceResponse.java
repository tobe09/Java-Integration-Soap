package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MandateAdviceResponse {
	@XmlElement(required = true, nillable = true)
	private String sessionId;
	@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	@XmlElement(required = true, nillable = true)
	private String channelCode;
	@XmlElement(required = true, nillable = true)
	private String mandateReferenceNumber;
	@XmlElement(required = true, nillable = true)
	private String amount;
	@XmlElement(required = true, nillable = true)
	private String debitAccountName;
	@XmlElement(required = true, nillable = true)
	private String debitAccountNumber;
	@XmlElement(required = true, nillable = true)
	private String debitBankVerificationNumber;
	@XmlElement(required = true, nillable = true)
	private String debitKYCLevel;
	@XmlElement(required = true, nillable = true)
	private String beneficiaryAccountName;
	@XmlElement(required = true, nillable = true)
	private String beneficiaryAccountNumber;
	@XmlElement(required = true, nillable = true)
	private String beneficiaryBankVerificationNumber;
	@XmlElement(required = true, nillable = true)
	private String beneficiaryKYCLevel;
	@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	
	public MandateAdviceResponse(String sessionId, String destinationInstitutionCode, String channelCode,
			String mandateReferenceNumber, String amount, String debitAccountName, String debitAccountNumber,
			String debitBankVerificationNumber, String debitKYCLevel, String beneficiaryAccountName,
			String beneficiaryAccountNumber, String beneficiaryBankVerificationNumber, String beneficiaryKYCLevel,
			String responseCode) {
		this.sessionId = sessionId;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.mandateReferenceNumber = mandateReferenceNumber;
		this.amount = amount;
		this.debitAccountName = debitAccountName;
		this.debitAccountNumber = debitAccountNumber;
		this.debitBankVerificationNumber = debitBankVerificationNumber;
		this.debitKYCLevel = debitKYCLevel;
		this.beneficiaryAccountName = beneficiaryAccountName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
		this.beneficiaryKYCLevel = beneficiaryKYCLevel;
		this.responseCode = responseCode;
	}
		
	public MandateAdviceResponse() {}
		
}
