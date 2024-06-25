package in.xeno.api.crm.lib;


import in.xeno.api.crm.constants.ProxyAction;
import in.xeno.api.crm.constants.ProxyContext;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ProxyRequest<T> {
    public ProxyContext context;
    public ProxyAction action;
    public T data;
}
