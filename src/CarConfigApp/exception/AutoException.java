package CarConfigApp.exception;

import CarConfigApp.model.Automobile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by Tangent Chang on 6/21/15.
 */
public class AutoException extends Exception{
    private ErrorCode error;
    //private String errorMsg;

    public AutoException(){}
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
    public void writeException(){
        Logger logger = Logger.getLogger("AutoExceptionLog");
        FileHandler fh;
        try {
            fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }
        catch (SecurityException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        String str = " Automobile Exception [ErrorCode = " + error + ", ErrorNo = " + error.getNumber() + ", ErrorMsg = " + getErrorMsg() + "]";
        logger.info(timeStamp + " " + str);

    }

    public void fix(int errorNo, Automobile model){
        ModelExceptionHelper fixM = new ModelExceptionHelper();
        fixM.fix(errorNo, model);
    }
    /*public void fix(int errorNo, Driver d){
        DriverExceptionHelper fixD = new DriverExceptionHelper();
        fixD.fix(errorNo, Driver d);
    }*/
}
