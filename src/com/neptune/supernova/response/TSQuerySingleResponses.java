package com.neptune.supernova.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TSQuerySingleResponses {

	//@XmlElement(required = true, nillable = true)
	private String SourceInstitutionCode;
	//@XmlElement(required = true, nillable = true)
	private String channelCode;
	//@XmlElement(required = true, nillable = true)
	private String sessionId;
	//@XmlElement(required = true, nillable = true)
	private String responseCode;
	
	public TSQuerySingleResponses() {
	}
	
	public TSQuerySingleResponses(String sourceInstitutionCode, String channelCode, String sessionId,
			String responseCode) {
		
		this.SourceInstitutionCode = sourceInstitutionCode;
		this.channelCode = channelCode;
		this.sessionId = sessionId;
		this.responseCode = responseCode;
	}

	public String getSourceInstitutionCode() {
		return SourceInstitutionCode;
	}

	public void setSourceInstitutionCode(String sourceInstitutionCode) {
		SourceInstitutionCode = sourceInstitutionCode;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	

}
