package com.distribuida.rest;

import com.distribuida.db.Author;
import com.distribuida.servicios.AuthorService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@ApplicationScoped
@Path("/author")
@RequiredArgsConstructor
public class AuthorRest {
    private final AuthorService authorService;
    @GET
    @Produces("application/json")
    public List<Author> lista(){
        return authorService.encontrarTodos();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Author get(@PathParam("id") Long id){
        return authorService.encontrarAutor(id);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Author author){
        try{
            authorService.guardarAutor(author);
        }catch (Exception ex){
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, Author author) throws Exception{
        try{
            authorService.actualizarAutor(id, author);
        }catch (Exception e){
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }
        return Response.status((Response.Status.OK)).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response delete(@PathParam("id") Long id) {
        try {
            authorService.borrarAutor(id);
        } catch (Exception ex) {
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }
        return Response.status((Response.Status.OK)).build();
    }
}
