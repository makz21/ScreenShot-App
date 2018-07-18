package sample;

@SuppressWarnings("serial")
public class WebException extends RuntimeException {
    private StatusCode code;

    public WebException(StatusCode code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public WebException(StatusCode code)
    {
        this(code, null);
    }

    public WebException(int httpCode, Throwable cause)
    {
        this(StatusCode.getStatus(httpCode), cause);
    }

    public WebException(int httpCode)
    {
        this(httpCode, null);
    }

    public StatusCode getStatusCode()
    {
        return code;
    }

    @Override
    public String getMessage()
    {
        return code.getDescription();
    }
}