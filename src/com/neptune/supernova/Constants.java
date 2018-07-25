package com.neptune.supernova;

import java.util.HashMap;

public class Constants {
	private static HashMap<String, String> responseCodes = null;
	private static HashMap<String, String> reasonCodes = null;

	private static void setResponseCodes(){
		responseCodes = new HashMap<String, String>();
		responseCodes.put("00", "Approved or completed successfully");
		responseCodes.put("01", "Status unknown, please wait for settlement report");
		responseCodes.put("03", "Invalid Sender");
		responseCodes.put("05", "Do not honor");
		responseCodes.put("06", "Dormant Account");
		responseCodes.put("07", "Invalid Account");
		responseCodes.put("08", "Account Name Mismatch");
		responseCodes.put("09", "Request processing in progress");
		responseCodes.put("12", "Invalid transaction");
		responseCodes.put("13", "Invalid Amount");
		responseCodes.put("14", "Invalid Batch Number");
		responseCodes.put("15", "Invalid Session or Record ID");
		responseCodes.put("16", "Unknown Bank Code");
		responseCodes.put("17", "Invalid Channel");
		responseCodes.put("18", "Wrong Method Call");
		responseCodes.put("21", "No action taken");
		responseCodes.put("25", "Unable to locate record");
		responseCodes.put("26", "Duplicate record");
		responseCodes.put("30", "Format error");
		responseCodes.put("34", "Suspected fraud");
		responseCodes.put("35", "Contact sending bank");
		responseCodes.put("51", "No sufficient funds");
		responseCodes.put("57", "Transaction not permitted to sender");
		responseCodes.put("58", "Transaction not permitted on channel");
		responseCodes.put("61", "Transfer limit Exceeded");
		responseCodes.put("63", "Security violation");
		responseCodes.put("65", "Exceeds withdrawal frequency");
		responseCodes.put("68", "Response received too late");
		responseCodes.put("69", "Unsuccessful Account/Amount block");
		responseCodes.put("70", "Unsuccessful Account/Amount unblock");
		responseCodes.put("71", "Empty Mandate Reference Number");
		responseCodes.put("91", "Beneficiary Bank not available");
		responseCodes.put("92", "Routing error");
		responseCodes.put("94", "Duplicate transaction");
		responseCodes.put("96", "System malfunction");
		responseCodes.put("97", "Timeout waiting for response from destination");		
	}
	
	private static void setReasonCodes(){
		reasonCodes = new HashMap<String, String>();
		reasonCodes.put("0001", "Suspected fraud");
		reasonCodes.put("0002", "Security violation");
		reasonCodes.put("0003", "Multiple cases of insufficient fund");
		reasonCodes.put("0004", "Multiple cases of “Transfer limit Exceeded”");
		reasonCodes.put("0005", "Non-compliance with operating regulations");
		reasonCodes.put("0006", "Identity theft");
		reasonCodes.put("0007", "Duplicate transaction processing");
		reasonCodes.put("0008", "Fraudulent multiple transactions");
		reasonCodes.put("0009", "Payment made by other means");
		reasonCodes.put("0010", "Purpose of payment not redeemed");
		reasonCodes.put("0011", "Recurring transactions");
		reasonCodes.put("1111", "Others");		
	}

	public static String getResponseMessage(String responseCode) {
		if (responseCodes == null){
			setResponseCodes();			
		}

		if (!responseCodes.containsKey(responseCode)) {
			return "Unknown Error Occured";
		}

		return responseCodes.get(responseCode);
	}

	
	public static String getReasonMessage(String reasonCode) {
		if (reasonCodes == null){
			setReasonCodes();			
		}

		if (!reasonCodes.containsKey(reasonCode)) {
			return "Unknown Error Occured";
		}

		return reasonCodes.get(reasonCode);
	}
}
