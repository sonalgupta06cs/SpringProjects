package com.baxter.idc.exception;

public class SpringException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String exceptionMsg;
	private String errCode;
	private StackTraceElement[] exceptionPrintStack;
	private String exceptionName;
	   


	public SpringException(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
		  this.errCode="100";
	}
	
	public SpringException(String errCode,String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
		this.errCode = errCode;
	}

	public SpringException(String errCode,String exceptionMsg,StackTraceElement[] exceptionPrintStack) {
		this.exceptionMsg = exceptionMsg;
		this.errCode = errCode;
		this.exceptionPrintStack = exceptionPrintStack;
	}
	
	   
	public SpringException(String errCode, String exceptionMsg, StackTraceElement[] exceptionPrintStack, String exceptionName) {
		this.exceptionMsg = exceptionMsg;
		this.errCode = errCode;
		this.exceptionPrintStack = exceptionPrintStack;
		this.exceptionName = exceptionName;
	}

	public String getExceptionMsg(){
	      return this.exceptionMsg;
	   }
	   
	   public void setExceptionMsg(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }

		public String getErrCode() {
			return errCode;
		}
	
		public void setErrCode(String errCode) {
			this.errCode = errCode;
		}
		
	    public StackTraceElement[] getExceptionPrintStack() {
		   return exceptionPrintStack;
     	}

	    public void setExceptionPrintStack(StackTraceElement[] exceptionPrintStack) {
		   this.exceptionPrintStack = exceptionPrintStack;
	    }

		public String getExceptionName() {
			return exceptionName;
		}

		public void setExceptionName(String exceptionName) {
			this.exceptionName = exceptionName;
		}
	   
	}



/*@Resource(name="error_messages")
private Properties propertyA;

@RequestMapping("/activityLedger")
@ExceptionHandler({SpringException.class})
public String activityLedger(ModelMap model,HttpSession session) throws Exception
{
	System.out.println("Sonal Activity Ledger");
	model.addAttribute("activityLedger", new ActivityHistory());
	IdcUser idcUser =  (IdcUser)session.getAttribute("userDetails");
	commonService.fetchAccessibleEntities(idcUser.getAdUserName(), orgList, portfolioList, projectList);
	
        
	try
	{
		List<ActivityHistoryResultsTO> activityLed = activityLedgerService.listActivityLedgerHistory(idcUser, orgList, portfolioList, projectList);
       	model.addAttribute("dailyUpdatesList",activityLed);
       	model.addAttribute("idcUserAdUserName", idcUser);
       	
	}
	catch(Exception ex)
	{
		//throw new SpringException("2001",propertyA.getProperty("activityLedger"));
		throw new SpringException("101",propertyA.getProperty("101"),ex.getMessage(),ex.toString());
	}
	
	return "activityLedger";
}*/