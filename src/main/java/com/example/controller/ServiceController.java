package main.java.com.example.controller;

import com.google.gson.Gson;
import main.java.com.example.dao.IServiceDao;
import main.java.com.example.models.Service;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/services")
public class ServiceController {
    Gson gson = new Gson();
    @EJB
    IServiceDao serviceDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listService() {
        List<Service> services = serviceDao.all();
        return gson.toJson(services);
    }
}
