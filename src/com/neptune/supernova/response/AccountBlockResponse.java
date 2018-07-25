package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class AccountBlockResponse {
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String destinationInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String referenceCode;
	//@XmlElement(required = true, nillable = true)
	private String targetAccountName;
	//@XmlElement(required = true, nillable = true)
	private String targetAccountNumber;
	//@XmlElement(required = true, nillable = true)
	private String targetBankVerificationNumber;
	//@XmlElement(required = true, nillable = true)
	private String reasonCode;
	//@XmlElement(required = true, nillable = true)
	private String narration;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	public AccountBlockResponse() {
	}

	public AccountBlockResponse(String sessionId, String destinationInstitutionCode, String channelCode,
			String referenceCode, String targetAccountName, String targetAccountNumber,
			String targetBankVerificationNumber, String reasonCode, String narration, String responseCode) {
		this.sessionId = sessionId;
		this.destinationInstitutionCode = destinationInstitutionCode;
		this.channelCode = channelCode;
		this.referenceCode = referenceCode;
		this.targetAccountName = targetAccountName;
		this.targetAccountNumber = targetAccountNumber;
		this.targetBankVerificationNumber = targetBankVerificationNumber;
		this.reasonCode = reasonCode;
		this.narration = narration;
		this.responseCode = responseCode;
	}
	
	
}
