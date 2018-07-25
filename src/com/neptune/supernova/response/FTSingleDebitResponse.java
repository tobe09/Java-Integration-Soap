package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FTSingleDebitResponse {
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String nameEnquiryRef;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String debitAccountName;
	//@XmlElement(required = true, nillable = true)
	private String debitAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String debitBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String debitKYCLevel;
	//@XmlElement(required = true, nillable = true)
	private String beneficiaryAccountName;
	//@XmlElement(required = true, nillable = true)
	private String beneficiaryAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String beneficiaryBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String beneficiaryKYCLevel;
	
	//@XmlElement(required = true, nillable = true)
	private String transactionLocation;
	//@XmlElement(required = true, nillable = true)
	private String narration;
	//@XmlElement(required = true, nillable = true)
	private String paymentReference;
	//@XmlElement(required = true, nillable = true)
	private String amount;
	//@XmlElement(required = true, nillable = true)
	private String mandateReference;
	//@XmlElement(required = true, nillable = true)
	private String transactionFee;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	
	public FTSingleDebitResponse(){		
	}


	public FTSingleDebitResponse(String sessionId, String nameEnquiryRef, String channelCode,
			String destinationInstitutionCode, String debitAccountName, String debitAccountNumber,
			String debitBankVerificationNumber, String debitKYCLevel, String beneficiaryAccountName,
			String beneficiaryAccountNumber, String beneficiaryBankVerificationNumber, String beneficiaryKYCLevel,
			String transactionLocation, String narration, String paymentReference, String amount,
			String mandateReference, String transactionFee, String responseCode) {
		this.sessionId = sessionId;
		this.nameEnquiryRef = nameEnquiryRef;
		this.channelCode = channelCode;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.debitAccountName = debitAccountName;
		this.debitAccountNumber = debitAccountNumber;
		this.debitBankVerificationNumber = debitBankVerificationNumber;
		this.debitKYCLevel = debitKYCLevel;
		this.beneficiaryAccountName = beneficiaryAccountName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
		this.beneficiaryKYCLevel = beneficiaryKYCLevel;
		this.transactionLocation = transactionLocation;
		this.narration = narration;
		this.paymentReference = paymentReference;
		this.amount = amount;
		this.mandateReference = mandateReference;
		this.transactionFee = transactionFee;
		this.responseCode = responseCode;
	}
	
	
}
