package org.acme.crud.resource;

import org.acme.crud.model.Item;
import org.acme.crud.service.ItemService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {

    @Inject
    ItemService itemService;

    @GET
    public List<Item> get(){
        return itemService.get();
    }

    @GET
    @Path("/{itemId}")
    public Item get(@PathParam("itemId") Long itemId){
        return itemService.get(itemId);
    }

    @POST
    public void create(Item item){
        itemService.create(item);
    }

    @PUT
    @Path("/{itemId}")
    public void update(@PathParam("itemId") Long itemId, Item item){
        itemService.update(itemId, item);
    }

    @DELETE
    @Path("{itemId}")
    public void delete(@PathParam("itemId") Long itemId){
        itemService.delete(itemId);
    }
}