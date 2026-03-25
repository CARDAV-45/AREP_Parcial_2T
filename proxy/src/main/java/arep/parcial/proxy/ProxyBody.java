package arep.parcial.proxy;

public class ProxyBody {
    private String result;
    
    public ProxyBody(String result) {
        this.result = result;
    }
    
    public String getMethod() {
        return result;
    }
}