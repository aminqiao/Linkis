package com.bmsoft.datadev.config;

        import com.bmsoft.datadev.restful.HelloRestful;
        import org.glassfish.jersey.server.ResourceConfig;
        import org.springframework.stereotype.Component;
        import sun.misc.Resource;


@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(HelloRestful.class);
    }
}
