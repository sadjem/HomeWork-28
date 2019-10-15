package com.lepet.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lepet.dao.ImageDao;
import com.lepet.model.Image;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

@Path("/")
public class ImageApi {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewImage (@FormParam("image") String image, @FormParam("aboutImage") String aboutImage) throws SQLException {
        Image newImage = new Image(image, aboutImage, ImageDao.getInstance().generateId());
        ImageDao.getInstance().addImage(newImage);
        return Response
                .status(Response.Status.OK)
                .entity("Image add to posgresql")
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getImage (@PathParam("id") int id) throws SQLException {
        List<Image> images = ImageDao.getInstance().getAllImages();
        String result = gson.toJson(images.get(id));
        byte [] arr = Base64.getDecoder().decode(result);

        return Response
                .status(Response.Status.OK)
                .entity(arr)
                .build();
    }
}
