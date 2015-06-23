package CarConfigApp.exception;

/**
 * Created by Tangent Chang on 6/21/15.
 */
public class AutoException extends Exception{
    private ErrorCode error;
    //private String errorMsg;

    public AutoException(ErrorCode error){
        this.error = error;
    }

    public ErrorCode getErrorCode(){
        return error;
    }
    public void setErrorCode(ErrorCode error) {
        this.error = error;
    }
    /*public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }*/
    public String getErrorMsg(){
        return error.getMessage();
    }


    public void printException(){
        System.out.println("Automobile Exception [ErrorCode = " + error + ", ErrorNo = " + error.getNumber() + ", ErrorMsg = " + getErrorMsg()+"]");
    }
}
