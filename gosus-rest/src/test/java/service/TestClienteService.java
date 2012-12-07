package service;

import junit.framework.TestCase;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestClienteService extends TestCase{

    // @Resource(type = UserServiceImpl.class)
    // private ServiceDefn service;
	Logger logger = Logger.getLogger(TestClienteService.class);

    @Test
    public void testGetClientes() {
    	/*WebClient wc = WebClient.create("http://localhost:8080/cxf-rest/rs/user-service");
    	wc.accept("application/json");
    	Response res = wc.path("/users").get();
    	System.out.println(res.getEntity().toString());*/
    	
    	System.out.println(invokeService("http://localhost:8080/gosus-rest/rs/cliente-service/clientes"));
    }
    
    @Test
    public void testGetClientesXNombre() {
    	String parametroNombre = "margarita";
    	System.out.println(invokeService("http://localhost:8080/gosus-rest/rs/cliente-service/clientesXNombre/"+parametroNombre));
    }
    
    private String invokeService(String targetURL) {
        WebClient webClient = WebClient.create(targetURL);
        webClient.accept("application/json");
        return webClient.get(String.class);
    }
}
