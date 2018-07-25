package com.neptune.supernova;

import java.io.InputStream;

import javax.jws.WebService;

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
import com.neptunesoftware.supernova.ws.client.AccountWebService;
import com.neptunesoftware.supernova.ws.client.AccountWebServiceEndPointPort_Impl;
import com.neptunesoftware.supernova.ws.client.FundsTransferWebService;
import com.neptunesoftware.supernova.ws.client.FundsTransferWebServiceEndPointPort_Impl;
import com.neptunesoftware.supernova.ws.client.TransactionsWebService;
import com.neptunesoftware.supernova.ws.client.TransactionsWebServiceEndPointPort_Impl;
import com.neptunesoftware.supernova.ws.client.TxnProcessWebService;
import com.neptunesoftware.supernova.ws.client.TxnProcessWebServiceEndPointPort_Impl;
import com.neptunesoftware.supernova.ws.server.account.data.AccountBlockRequestData;
import com.neptunesoftware.supernova.ws.server.account.data.AccountBlockResponseData;
import com.neptunesoftware.supernova.ws.server.account.data.AmountBlockRequestData;
import com.neptunesoftware.supernova.ws.server.account.data.AmountBlockResponseData;
import com.neptunesoftware.supernova.ws.server.account.data.BalanceEnquiryRequestData;
import com.neptunesoftware.supernova.ws.server.account.data.BalanceEnquiryResponseData;
import com.neptunesoftware.supernova.ws.server.transfer.data.FinancialInstitutionListRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FinancialInstitutionListResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceCreditRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceCreditResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceDebitRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferAdviceDebitResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleCreditRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleCreditResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleDebitRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.FundTransferSingleDebitResponse;
import com.neptunesoftware.supernova.ws.server.transfer.data.MandateAdviceRequestData;
import com.neptunesoftware.supernova.ws.server.transfer.data.MandateAdviceResponseData;
import com.neptunesoftware.supernova.ws.server.transfer.data.NameInquiryRequestData;
import com.neptunesoftware.supernova.ws.server.transfer.data.NameInquiryResponseData;
import com.neptunesoftware.supernova.ws.server.transfer.data.TSQuerySingleRequest;
import com.neptunesoftware.supernova.ws.server.transfer.data.TSQuerySingleResponse;

@WebService(endpointInterface = "com.neptune.supernova.IntegrationSoap")
public class IntegrationSoapImpl implements IntegrationSoap {


	static AccountWebService accountWebService = null;
	static TransactionsWebService transactionsWebService = null;
	static FundsTransferWebService transferWebService = null;
	static TxnProcessWebService processWebService = null;

	public IntegrationSoapImpl(){
		try {
			String content = getInfo("core_systeminfo.txt", IntegrationSoapImpl.class);
			String[] ipPortDef = content.split(",");
			String ipAddress = ipPortDef[0].split("=")[1];
			String portNo = ipPortDef[1].split("=")[1];

			System.out.println(ipAddress + ", " + portNo);
		
		   accountWebService = new AccountWebServiceEndPointPort_Impl("http://" + ipAddress + ":" + portNo + "/supernovaws/AccountWebServiceBean?wsdl").getAccountWebServiceSoapPort("proxy_user".getBytes(), "proxy_password".getBytes());
           transactionsWebService = new TransactionsWebServiceEndPointPort_Impl("http://" + ipAddress + ":" + portNo + "/supernovaws/TransactionsWebServiceBean?wsdl").getTransactionsWebServiceSoapPort("proxy_user".getBytes(), "proxy_password".getBytes());
           transferWebService = new FundsTransferWebServiceEndPointPort_Impl("http://" + ipAddress + ":" + portNo + "/supernovaws/FundsTransferWebServiceBean?wsdl").getFundsTransferWebServiceSoapPort("proxy_user".getBytes(), "proxy_password".getBytes());
           processWebService = new TxnProcessWebServiceEndPointPort_Impl("http://" + ipAddress + ":" + portNo + "/supernovaws/TxnProcessWebServiceBean?wsdl").getTxnProcessWebServiceSoapPort("proxy_user".getBytes(), "proxy_password".getBytes());

		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

	public static String getInfo(String name, Class<?> clazz) {
		try {
			InputStream is = clazz.getResourceAsStream(name);
			byte[] data = new byte[is.available()];
			is.read(data);
			is.close();
			String content = new String(data);
			return content;
		} 
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public NESingleResponse nameInquirySubmit(NameInquiryRequestData inquiryRequest) throws Exception {
		initialMessage("nameInquirySubmit", inquiryRequest);
			
		NameInquiryResponseData inquiryResponse = transferWebService.nameenquirysingleitem(inquiryRequest);

		showResponse(inquiryResponse);
		
		NESingleResponse response = new NESingleResponse(inquiryResponse.getSessionId()+"", inquiryResponse.getChannelCode()+"", inquiryResponse.getAccountNumber()+"", 
				inquiryResponse.getAccountName()+"", inquiryResponse.getResponseCode()+"", inquiryResponse.getKYCLevel()+"", 
				inquiryResponse.getBankVerificationNumber()+"", inquiryResponse.getDestinationInstitutionCode()+"");
		
		return response;
	}

	@Override
	public TSQuerySingleResponses transactionStatusSubmit(TSQuerySingleRequest transactionRequest) throws Exception {
		initialMessage("transactionStatusSubmit", transactionRequest);

		TSQuerySingleResponse transactStatResponse = transferWebService.transactionStatusQuery(transactionRequest);

		showResponse(transactStatResponse);
		
		TSQuerySingleResponses response = new TSQuerySingleResponses(transactStatResponse.getSourceInstitutionCode() + "",
				transactStatResponse.getChannelCode() + "", transactStatResponse.getSessionId() + "",
				transactStatResponse.getResponseCode() + "");
		
		return response;
	}

	@Override
	public BalanceEnquiryResponse balanceEnquirySubmit(BalanceEnquiryRequestData balEnqRequest) throws Exception {
		initialMessage("balanceEnquirySubmit", balEnqRequest);

		BalanceEnquiryResponseData balEnqResponse = accountWebService.balanceenquiry(balEnqRequest);

		showResponse(balEnqResponse);

		BalanceEnquiryResponse response = new BalanceEnquiryResponse(balEnqResponse.getSessionId() + "",
				balEnqResponse.getDestinationInstitutionCode(), balEnqResponse.getChannelCode(),
				balEnqResponse.getAuthorizationCode(), balEnqResponse.getTargetAccountName(),
				balEnqResponse.getTargetBankVerificationNumber(), balEnqResponse.getTargetAccountNumber(),
				balEnqResponse.getAvailableBalance() + "", balEnqResponse.getResponseCode() + "");
		
		return response;
	}

	@Override
	public AccountBlockResponse accountBlockSubmit(AccountBlockRequestData acctBlockRequest) throws Exception {
		initialMessage("accountBlockSubmit", acctBlockRequest);

		AccountBlockResponseData accBlockResponse = accountWebService.accountblock(acctBlockRequest);

		showResponse(accBlockResponse); 

		AccountBlockResponse response = new AccountBlockResponse(accBlockResponse.getSessionId(),
				accBlockResponse.getDestinationInstitutionCode(), accBlockResponse.getChannelCode(),
				accBlockResponse.getReferenceCode(), accBlockResponse.getTargetAccountName(),
				accBlockResponse.getTargetAccountNumber(), accBlockResponse.getTargetBankVerificationNumber(),
				accBlockResponse.getReasonCode(), accBlockResponse.getNarration(), accBlockResponse.getResponseCode());

		return response;
	}

	@Override
	public AccountBlockResponse accountUnblockSubmit(AccountBlockRequestData acctUnblockRequest) throws Exception {
		initialMessage("accountUnblockSubmit", acctUnblockRequest);

		AccountBlockResponseData accUnblockResponse = accountWebService.accountunblock(acctUnblockRequest);
		
		showResponse(accUnblockResponse);  
		
		AccountBlockResponse response = new AccountBlockResponse(accUnblockResponse.getSessionId(),
				accUnblockResponse.getDestinationInstitutionCode(), accUnblockResponse.getChannelCode(),
				accUnblockResponse.getReferenceCode(), accUnblockResponse.getTargetAccountName(),
				accUnblockResponse.getTargetAccountNumber(), accUnblockResponse.getTargetBankVerificationNumber(),
				accUnblockResponse.getReasonCode(), accUnblockResponse.getNarration(),
				accUnblockResponse.getResponseCode());
		
		return response;
	}

	@Override
	public AmountBlockResponse amountBlockSubmit(AmountBlockRequestData amtBlockRequestData) throws Exception {
		initialMessage("amountBlockSubmit", amtBlockRequestData);

		AmountBlockResponseData amtBlockResponse = accountWebService.amountblock(amtBlockRequestData);

		showResponse(amtBlockResponse);   
		
		AmountBlockResponse response = new AmountBlockResponse(amtBlockResponse.getSessionId(),
				amtBlockResponse.getDestinationInstitutionCode(), amtBlockResponse.getChannelCode(),
				amtBlockResponse.getReferenceCode(), amtBlockResponse.getTargetAccountName(),
				amtBlockResponse.getTargetAccountNumber(), amtBlockResponse.getTargetBankVerificationNumber(),
				amtBlockResponse.getReasonCode(), amtBlockResponse.getNarration(), amtBlockResponse.getAmount() + "",
				amtBlockResponse.getResponseCode());
		
		return response;
	}

	@Override
	public AmountUnblockResponse amountUnblockSubmit(AmountBlockRequestData amtUnblockRequest) throws Exception {
		initialMessage("amountUnblockSubmit", amtUnblockRequest);

		AmountBlockResponseData amtUnblockResponseData = accountWebService.amountblock(amtUnblockRequest);
		
		showResponse(amtUnblockResponseData);   

		AmountUnblockResponse response = new AmountUnblockResponse(amtUnblockResponseData.getSessionId(),
				amtUnblockResponseData.getDestinationInstitutionCode(), amtUnblockResponseData.getChannelCode(),
				amtUnblockResponseData.getReferenceCode(), amtUnblockResponseData.getTargetAccountName(),
				amtUnblockResponseData.getTargetAccountNumber(),
				amtUnblockResponseData.getTargetBankVerificationNumber(), amtUnblockResponseData.getReasonCode(),
				amtUnblockResponseData.getNarration(), amtUnblockResponseData.getAmount() + "",
				amtUnblockResponseData.getResponseCode());
		
		return response;
	}

	@Override
	public MandateAdviceResponse mandateAdviceSubmit(MandateAdviceRequestData mandateAdviceRequest) throws Exception {
		initialMessage("mandateAdviceSubmit", mandateAdviceRequest);
		
		MandateAdviceResponseData mandateAdviceResponse = transferWebService.mandateadvice(mandateAdviceRequest);

		showResponse(mandateAdviceResponse);   
		
		MandateAdviceResponse response = new MandateAdviceResponse(mandateAdviceResponse.getSessionId(),
				mandateAdviceResponse.getDestinationInstitutionCode(), mandateAdviceResponse.getChannelCode(),
				mandateAdviceResponse.getMandateReferenceNumber() + "", mandateAdviceResponse.getAmount() + "",
				mandateAdviceResponse.getDebitAccountName(), mandateAdviceResponse.getDebitAccountNumber(),
				mandateAdviceResponse.getDebitBankVerificationNumber(), mandateAdviceResponse.getDebitKYCLevel() + "",
				mandateAdviceResponse.getBeneficiaryAccountName(), mandateAdviceResponse.getBeneficiaryAccountNumber(),
				mandateAdviceResponse.getBeneficiaryBankVerificationNumber(),
				mandateAdviceResponse.getBeneficiaryKYCLevel() + "", mandateAdviceResponse.getResponseCode());
		
		return response;
	}

	@Override
	public FTAdviceDebitResponse fundtransferAdviceDdSubmit(FundTransferAdviceDebitRequest fundtransferAdvice_ddRequest)
			throws Exception {
		initialMessage("fundtransferAdviceDdSubmit", fundtransferAdvice_ddRequest);

		FundTransferAdviceDebitResponse fundTranseAdvice_ddResponse = transferWebService
				.fundtransferAdvicedd(fundtransferAdvice_ddRequest);

		showResponse(fundTranseAdvice_ddResponse);   

		FTAdviceDebitResponse response = new FTAdviceDebitResponse(fundTranseAdvice_ddResponse.getSessionId(),
				fundTranseAdvice_ddResponse.getNameEnquiryRef() + "",
				fundTranseAdvice_ddResponse.getDestinationInstitutionCode(),
				fundTranseAdvice_ddResponse.getChannelCode(), fundTranseAdvice_ddResponse.getDebitAccountName(),
				fundTranseAdvice_ddResponse.getDebitAccountNumber(),
				fundTranseAdvice_ddResponse.getDebitBankVerificationNumber() + "",
				fundTranseAdvice_ddResponse.getDebitKYCLevel() + "",
				fundTranseAdvice_ddResponse.getBeneficiaryAccountName(),
				fundTranseAdvice_ddResponse.getBeneficiaryAccountNumber() + "",
				fundTranseAdvice_ddResponse.getBeneficiaryBankVerificationNumber() + "",
				fundTranseAdvice_ddResponse.getBeneficiaryKYCLevel() + "",
				fundTranseAdvice_ddResponse.getTransactionLocation() + "",
				fundTranseAdvice_ddResponse.getNarration() + "", fundTranseAdvice_ddResponse.getPaymentReference() + "",
				fundTranseAdvice_ddResponse.getMandateReferenceNumber() + "",
				fundTranseAdvice_ddResponse.getTransactionFee() + "", fundTranseAdvice_ddResponse.getAmount() + "",
				fundTranseAdvice_ddResponse.getResponseCode() + "");
		
		return response;
	}

	@Override
	public FTAdviceCreditResponse fundTransferAdviceDcSubmit(FundTransferAdviceCreditRequest fundtransferAdvice_dcRequest)
			throws Exception {
		initialMessage("fundTransferAdviceDcSubmit", fundtransferAdvice_dcRequest);

		FundTransferAdviceCreditResponse fundTranseAdvice_dcResponse = transferWebService
				.fundtransferAdvicedc(fundtransferAdvice_dcRequest);

		showResponse(fundTranseAdvice_dcResponse);   
		
		FTAdviceCreditResponse response = new FTAdviceCreditResponse(fundTranseAdvice_dcResponse.getSessionId(),
				fundTranseAdvice_dcResponse.getNameEnquiryRef(),
				fundTranseAdvice_dcResponse.getDestinationInstitutionCode(),
				fundTranseAdvice_dcResponse.getChannelCode(), fundTranseAdvice_dcResponse.getBeneficiaryAccountName(),
				fundTranseAdvice_dcResponse.getBeneficiaryAccountNumber(),
				fundTranseAdvice_dcResponse.getBeneficiaryBankVerificationNumber(),
				fundTranseAdvice_dcResponse.getBeneficiaryKYCLevel() + "",
				fundTranseAdvice_dcResponse.getOriginatorAccountName(),
				fundTranseAdvice_dcResponse.getOriginatorAccountNumber(),
				fundTranseAdvice_dcResponse.getOriginatorBankVerificationNumber(),
				fundTranseAdvice_dcResponse.getOriginatorKYCLevel() + "",
				fundTranseAdvice_dcResponse.getTransactionLocation() + "", fundTranseAdvice_dcResponse.getNarration(),
				fundTranseAdvice_dcResponse.getPaymentReference() + "", fundTranseAdvice_dcResponse.getAmount() + "",
				fundTranseAdvice_dcResponse.getResponseCode());
		
		return response;
	}

	@Override
	public FTSingleCreditResponse fundTransferDcSubmit(FundTransferSingleCreditRequest fundTransferDC)
			throws Exception {
		initialMessage("fundTransferDcSubmit", fundTransferDC);

		FundTransferSingleCreditResponse fundTranseDCResponse = transferWebService
				.fundtransfersingleitemdc(fundTransferDC);

		showResponse(fundTranseDCResponse);   

		FTSingleCreditResponse response = new FTSingleCreditResponse(fundTranseDCResponse.getSessionId(),
				fundTranseDCResponse.getNameEnquiryRef(), fundTranseDCResponse.getChannelCode(),
				fundTranseDCResponse.getDestinationInstitutionCode(), fundTranseDCResponse.getBeneficiaryAccountName(),
				fundTranseDCResponse.getBeneficiaryAccountNumber(),
				fundTranseDCResponse.getBeneficiaryBankVerificationNumber(),
				fundTranseDCResponse.getBeneficiaryKYCLevel() + "", fundTranseDCResponse.getOriginatorAccountName(),
				fundTranseDCResponse.getOriginatorAccountNumber(),
				fundTranseDCResponse.getOriginatorBankVerificationNumber(),
				fundTranseDCResponse.getOriginatorKYCLevel() + "", fundTranseDCResponse.getTransactionLocation() + "",
				fundTranseDCResponse.getNarration(), fundTranseDCResponse.getPaymentReference(),
				fundTranseDCResponse.getAmount() + "", fundTranseDCResponse.getResponseCode());
		
		return response;
	}

	@Override
	public FTSingleDebitResponse fundTransferDdSubmit(FundTransferSingleDebitRequest fundTransferDD) throws Exception {
		initialMessage("fundTransferDdSubmit", fundTransferDD);

		FundTransferSingleDebitResponse fundTranseDDResponse = transferWebService
				.fundtransfersingleitemdd(fundTransferDD);
		
		showResponse(fundTranseDDResponse);   

		FTSingleDebitResponse response = new FTSingleDebitResponse(fundTranseDDResponse.getSessionId(),
				fundTranseDDResponse.getNameEnquiryRef(), fundTranseDDResponse.getChannelCode(),
				fundTranseDDResponse.getDestinationInstitutionCode(), fundTranseDDResponse.getDebitAccountName(),
				fundTranseDDResponse.getDebitAccountNumber(), fundTranseDDResponse.getDebitBankVerificationNumber(),
				fundTranseDDResponse.getDebitKYCLevel() + "", fundTranseDDResponse.getBeneficiaryAccountName(),
				fundTranseDDResponse.getBeneficiaryAccountNumber(),
				fundTranseDDResponse.getBeneficiaryBankVerificationNumber(),
				fundTranseDDResponse.getBeneficiaryKYCLevel() + "", fundTranseDDResponse.getTransactionLocation() + "",
				fundTranseDDResponse.getNarration(), fundTranseDDResponse.getPaymentReference(),
				fundTranseDDResponse.getAmount() + "", fundTranseDDResponse.getMandateReferenceNumber() + "",
				fundTranseDDResponse.getTransactionFee() + "", fundTranseDDResponse.getResponseCode());
		
		return response;
	}

	@Override
	public FinancialInstitutionListResponses financialInstListSubmit(FinancialInstitutionListRequest finInstLstRequest)
			throws Exception {
		initialMessage("financialInstListSubmit", finInstLstRequest);
		
		FinancialInstitutionListResponse finInstLstResponse = transferWebService
				.financialInstitutionList(finInstLstRequest);
		
		showResponse(finInstLstResponse);   
		
		FinancialInstitutionListResponses response = new FinancialInstitutionListResponses(
				finInstLstResponse.getBatchNumber() + "", finInstLstResponse.getDestinationInstitutionCode() + "",
				finInstLstResponse.getChannelCode() + "", finInstLstResponse.getNumberOfRecords() + "",
				finInstLstResponse.getResponseCode() + "");
				
		return response;
	}
	
	private void initialMessage(String methodName, Object requestObject){
		System.out.println("In " + methodName + " post method");		
		System.out.println("Request: " + requestObject);		
		System.out.println("Response loading...");
	}
	
	private void showResponse(Object responseObject){
		System.out.println("Response: " + responseObject);
	}
}
