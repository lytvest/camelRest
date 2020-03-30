import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Start {

    public static void main(String[] args) throws Exception {


        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("netty-http:http://0.0.0.0:8080/stat")
                        .transform().method(TestBean.class, "stat");
            }
        });
        context.start();
    }


}
