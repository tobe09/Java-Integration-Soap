package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FTAdviceCreditResponse {
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String NameEnquiryRef;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryAccountName;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryKYCLevel;
	//@XmlElement(required = true, nillable = true)
	private String OriginatorAccountName;
	//@XmlElement(required = true, nillable = true)
	private String OriginatorAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String OriginatorBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String OriginatorKYCLevel;
	
	@XmlElement(required = true, nillable = true)
	private String TransactionLocation;
	@XmlElement(required = true, nillable = true)
	private String Narration;
	@XmlElement(required = true, nillable = true)
	private String PaymentReference;
	@XmlElement(required = true, nillable = true)
	private String Amount;
	@XmlElement(required = true, nillable = true)
	private String ResponseCode;
	
	public FTAdviceCreditResponse() {
	}
	
	public FTAdviceCreditResponse(String sessionId, String nameEnquiryRef, String destinationInstitutionCode,
			String channelCode, String beneficiaryAccountName, String beneficiaryAccountNumber,
			String beneficiaryBankVerificationNumber, String beneficiaryKYCLevel, String originatorAccountName,
			String originatorAccountNumber, String originatorBankVerificationNumber, String originatorKYCLevel,
			String transactionLocation, String narration, String paymentReference, String amount, String responseCode) {
		
		this.sessionId = sessionId;
		this.NameEnquiryRef = nameEnquiryRef;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.BeneficiaryAccountName = beneficiaryAccountName;
		this.BeneficiaryAccountNumber = beneficiaryAccountNumber;
		this.BeneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
		this.BeneficiaryKYCLevel = beneficiaryKYCLevel;
		this.OriginatorAccountName = originatorAccountName;
		this.OriginatorAccountNumber = originatorAccountNumber;
		this.OriginatorBankVerificationNumber = originatorBankVerificationNumber;
		this.OriginatorKYCLevel = originatorKYCLevel;
		this.TransactionLocation = transactionLocation;
		this.Narration = narration;
		this.PaymentReference = paymentReference;
		this.Amount = amount;
		this.ResponseCode = responseCode;
	}

}
