package in.xeno.api.crm.lib;


import in.xeno.api.crm.constants.ProxyAction;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ProxyRequest<T> {
    public ProxyAction action;
    public T data;
}
