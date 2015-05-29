package lab2.Exception;

/**
 * Created by Tangent Chang on 5/28/15.
 */
public class CustomException extends Exception{
    private int errorNo;
    private String errorMsg;

    public CustomException(){
        super();
        printException();
    }

    public CustomException(int errorno){
        super();
        errorNo = errorno;
        printException();
    }

    public CustomException(String errormsg){
        super();
        errorMsg = errormsg;
        printException();
    }

    public CustomException(int errorno, String errormsg){
        super();
        errorNo = errorno;
        errorMsg = errormsg;
        printException();
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public String getErrorMsg(){
        return errorMsg;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }
    public int getErrorNo(){
        return errorNo;
    }

    public void printException(){
        System.out.println("Custom Exception [ErrorNo=" + errorNo + ", ErrorMsg=" + errorMsg +"]");
    }
}
