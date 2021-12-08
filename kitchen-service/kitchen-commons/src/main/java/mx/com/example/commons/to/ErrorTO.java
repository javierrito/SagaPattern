package mx.com.example.commons.to;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class ErrorTO implements Serializable {

    private String errorCode;
    private String errorMessage;
    private String userError;
    private String info;

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getUserError() {
        return userError;
    }

    public String getInfo() {
        return info;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}