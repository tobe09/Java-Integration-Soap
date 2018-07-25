package com.neptune.supernova;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.neptune.supernova.response.AccountBlockResponse;
import com.neptune.supernova.response.AmountBlockResponse;
import com.neptune.supernova.response.AmountUnblockResponse;
import com.neptune.supernova.response.BalanceEnquiryResponse;
import com.neptune.supernova.response.FTAdviceCreditResponse;
import com.neptune.supernova.response.FTAdviceDebitResponse;
import com.neptune.supernova.response.FTSingleCreditResponse;
import com.neptune.supernova.response.FTSingleDebitResponse;
import com.neptune.supernova.response.FinancialInstitutionListResponses;
import com.neptune.supernova.response.MandateAdviceResponse;
import com.neptune.supernova.response.NESingleResponse;
import com.neptune.supernova.response.TSQuerySingleResponses;
import com.neptunesoftware.supernova.ws.server.account.data.AccountBlockRequestData;
import com.neptunesoftware.supernova.ws.server.account.data.AmountBlockRequestData;
import com.neptunesoftware.supernova.ws.server.account.data.BalanceEnquiryRequestData;
import com.neptunesoftware.supernova.ws.server.transfer.data.FinancialInstitutionListRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceCreditRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceDebitRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleCreditRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleDebitRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.MandateAdviceRequestData;
import com.neptunesoftware.supernova.ws.server.transfer.data.NameInquiryRequestData;
import com.neptunesoftware.supernova.ws.server.transfer.data.TSQuerySingleRequest;

@WebService(serviceName = "IntegrationSoap", name = "IntegrationSoapName", targetNamespace = "http://www.neptunesoftwareplc.com")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface IntegrationSoap {
	
	@WebMethod(operationName = "nameInquirySubmit")
	@WebResult(name = "NESingleResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	NESingleResponse nameInquirySubmit(NameInquiryRequestData inquiryRequest) throws Exception;

	@WebMethod(operationName = "transactionStatusSubmit")
	@WebResult(name = "TSQuerySingleResponses", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	TSQuerySingleResponses transactionStatusSubmit(TSQuerySingleRequest transactionRequest) throws Exception;

	@WebMethod(operationName = "balanceEnquirySubmit")
	@WebResult(name = "BalanceEnquiryResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	BalanceEnquiryResponse balanceEnquirySubmit(BalanceEnquiryRequestData balEnqRequest) throws Exception;
	
	@WebMethod(operationName = "accountBlockSubmit")  
	@WebResult(name = "AccountBlockResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	AccountBlockResponse accountBlockSubmit(AccountBlockRequestData acctBlockRequest) throws Exception;
	
	@WebMethod(operationName = "accountUnblockSubmit")  
	@WebResult(name = "AccountUnBlockResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	AccountBlockResponse accountUnblockSubmit(AccountBlockRequestData acctUnblockRequest) throws Exception;
	
	@WebMethod(operationName = "amountBlockSubmit")  
	@WebResult(name = "AmountBlockResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	AmountBlockResponse amountBlockSubmit(AmountBlockRequestData amtBlockRequestData) throws Exception;
	
	@WebMethod(operationName = "amountUnblockSubmit")  
	@WebResult(name = "AmountUnblockResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	AmountUnblockResponse amountUnblockSubmit(AmountBlockRequestData amtUnblockRequest) throws Exception;
	
	@WebMethod(operationName = "mandateAdviceSubmit")  
	@WebResult(name = "MandateAdviceResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	MandateAdviceResponse mandateAdviceSubmit(MandateAdviceRequestData mandateAdviceRequest) throws Exception;
	
	@WebMethod(operationName = "fundtransferAdviceDdSubmit")  
	@WebResult(name = "FTAdviceDebitResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	FTAdviceDebitResponse fundtransferAdviceDdSubmit(FundTransferAdviceDebitRequest fundtransferAdvice_ddRequest) throws Exception;
	
	@WebMethod(operationName = "fundTransferAdviceDcSubmit")  
	@WebResult(name = "FTAdviceCreditResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	FTAdviceCreditResponse fundTransferAdviceDcSubmit(FundTransferAdviceCreditRequest fundtransferAdvice_dcRequest) throws Exception;
	
	@WebMethod(operationName = "fundTransferDcSubmit")  
	@WebResult(name = "FTSingleCreditResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	FTSingleCreditResponse fundTransferDcSubmit(FundTransferSingleCreditRequest fundTransferDC) throws Exception;
	
	@WebMethod(operationName = "fundTransferDdSubmit")  
	@WebResult(name = "FTSingleDebitResponse", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	FTSingleDebitResponse fundTransferDdSubmit(FundTransferSingleDebitRequest fundTransferDD) throws Exception;
	
	@WebMethod(operationName = "financialInstListSubmit")  
	@WebResult(name = "FinancialInstitutionListResponses", targetNamespace = "http://www.neptunesoftwareplc.com/complex")
	FinancialInstitutionListResponses financialInstListSubmit(FinancialInstitutionListRequest finInstLstRequest) throws Exception;
	
}
