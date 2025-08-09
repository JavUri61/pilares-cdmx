package mx.cdmx.pilares;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class Application extends javax.ws.rs.core.Application {
    private final Set<Class<?>> classes = new HashSet<>();

    public Application() {
        // Register your JAX-RS components here
        classes.add(mx.cdmx.pilares.controllers.SedeController.class);
        classes.add(mx.cdmx.pilares.controllers.ActividadController.class);
        classes.add(mx.cdmx.pilares.controllers.ChatbotController.class);
        
        // Register exception mappers if needed
        // classes.add(YourExceptionMapper.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        // Register any provider instances here
        Set<Object> singletons = new HashSet<>();
        
        // Enable Jackson for JSON processing
        singletons.add(new org.glassfish.jersey.jackson.JacksonFeature());
        
        // Add CORS filter
        singletons.add(new CorsFilter());
        
        return singletons;
    }
}

// Simple CORS filter for development
class CorsFilter implements javax.ws.rs.container.ContainerResponseFilter {
    @Override
    public void filter(javax.ws.rs.container.ContainerRequestContext requestContext,
                      javax.ws.rs.container.ContainerResponseContext responseContext) {
        responseContext.getHeaders().add(
            "Access-Control-Allow-Origin", "*");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization");
        responseContext.getHeaders().add(
            "Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }
}