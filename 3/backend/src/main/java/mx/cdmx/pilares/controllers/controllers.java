package mx.cdmx.pilares.controllers;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import mx.cdmx.pilares.models.Sede;
import mx.cdmx.pilares.services.SedeService;
import java.util.List;

@Path("/sedes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SedeController {
    
    private final SedeService sedeService = new SedeService();

    @GET
    public Response getAllSedes() {
        List<Sede> sedes = sedeService.getAllSedes();
        return Response.ok(sedes).build();
    }

    @GET
    @Path("/{id}")
    public Response getSedeById(@PathParam("id") Long id) {
        Sede sede = sedeService.getSedeById(id);
        return Response.ok(sede).build();
    }

    @GET
    @Path("/recomendaciones")
    public Response getRecomendaciones(
            @QueryParam("latitud") Double latitud,
            @QueryParam("longitud") Double longitud,
            @QueryParam("actividad") String actividad) {
        
        List<Sede> recomendaciones = sedeService.getRecomendaciones(latitud, longitud, actividad);
        return Response.ok(recomendaciones).build();
    }
}