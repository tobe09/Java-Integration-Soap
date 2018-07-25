package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FTAdviceDebitResponse {
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String NameEnquiryRef;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String DebitAccountName;
	//@XmlElement(required = true, nillable = true)
	private String DebitAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String DebitBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String DebitKYCLevel;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryAccountName;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String BeneficiaryKYCLevel;
	//@XmlElement(required = true, nillable = true)
	private String TransactionLocation;
	//@XmlElement(required = true, nillable = true)
	private String Narration;
	//@XmlElement(required = true, nillable = true)
	private String PaymentReference;
	//@XmlElement(required = true, nillable = true)
	private String MandateReferenceNumber;
	//@XmlElement(required = true, nillable = true)
	private String TransactionFee;
	//@XmlElement(required = true, nillable = true)
	private String Amount;
	//@XmlElement(required = true, nillable = true)
	private String ResponseCode;
	
	
	public FTAdviceDebitResponse() {
	}


	public FTAdviceDebitResponse(String sessionId, String nameEnquiryRef, String destinationInstitutionCode,
			String channelCode, String debitAccountName, String debitAccountNumber, String debitBankVerificationNumber,
			String debitKYCLevel, String beneficiaryAccountName, String beneficiaryAccountNumber,
			String beneficiaryBankVerificationNumber, String beneficiaryKYCLevel, String transactionLocation,
			String narration, String paymentReference, String mandateReferenceNumber, String transactionFee,
			String amount, String responseCode) {
		this.sessionId = sessionId;
		this.NameEnquiryRef = nameEnquiryRef;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.DebitAccountName = debitAccountName;
		this.DebitAccountNumber = debitAccountNumber;
		this.DebitBankVerificationNumber = debitBankVerificationNumber;
		this.DebitKYCLevel = debitKYCLevel;
		this.BeneficiaryAccountName = beneficiaryAccountName;
		this.BeneficiaryAccountNumber = beneficiaryAccountNumber;
		this.BeneficiaryBankVerificationNumber = beneficiaryBankVerificationNumber;
		this.BeneficiaryKYCLevel = beneficiaryKYCLevel;
		this.TransactionLocation = transactionLocation;
		this.Narration = narration;
		this.PaymentReference = paymentReference;
		this.MandateReferenceNumber = mandateReferenceNumber;
		this.TransactionFee = transactionFee;
		this.Amount = amount;
		ResponseCode = responseCode;
	}
	
}
