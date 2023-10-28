import java.io.Serializable;

public class Request implements Serializable {
    private String operationType;
    private Object data;

    public Request(String operationType, Object data) {
        this.operationType = operationType;
        this.data = data;
    }

    public String getOperationType() {
        return operationType;
    }

    public Object getData() {
        return data;
    }
}
