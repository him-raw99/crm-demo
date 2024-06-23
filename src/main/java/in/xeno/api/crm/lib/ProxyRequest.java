package in.xeno.api.crm.lib;

public class ProxyRequest<T> {
    public String context;
    public T data;

    public ProxyRequest(String context, T data) {
        this.context = context;
        this.data = data;
    }

    public String toString(){
        return "{"+
                    "context: "+this.context+ " ,"+
                    "data: "+this.data+
                "}";
    }
}
