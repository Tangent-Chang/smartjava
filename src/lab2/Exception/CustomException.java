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

    public CustomException(int errorNo){
        super();
        this.errorNo = errorNo;
        printException();
    }

    public CustomException(String errorMsg){
        super();
        this.errorMsg = errorMsg;
        printException();
    }

    public CustomException(int errorNo, String errorMsg){
        super();
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
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
