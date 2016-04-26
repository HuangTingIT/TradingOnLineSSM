package TOL2.exception;

/**
 * Created by HuangTing on 2016/4/25.
 */
public class GoodsException extends Exception{
    //异常信息
    public String message;

    public GoodsException(String message){
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
