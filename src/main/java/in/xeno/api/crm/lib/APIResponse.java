package in.xeno.api.crm.lib;

public class APIResponse<T> {
    public int statusCode;
    public String message;
    public T data;
    public boolean success;

    public APIResponse(int statusCode, String message, T data, boolean success) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.success = success;
    }

    @Override
    public String toString(){
        return "{"+
                "data: "+this.data+ " ,"+
                "message: "+this.message+ " ,"+
                "success: "+this.success+ " ,"+
                "statusCode: "+this.statusCode +
                "}";
    }
}
