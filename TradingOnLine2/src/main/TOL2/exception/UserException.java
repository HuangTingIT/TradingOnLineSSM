package TOL2.exception;

/**
 * Created by HuangTing on 2016/4/24.
 */
public class UserException extends Exception {

    //异常信息
    public String message;

    public UserException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
