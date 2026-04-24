package com.mycompany.smartcampusapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/")
public class DiscoveryResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> getInfo() {

        Map<String, Object> data = new HashMap<>();

        data.put("message", "Smart Campus API is running");
        data.put("version", "v1");
        data.put("rooms", "/api/v1/rooms");
        data.put("sensors", "/api/v1/sensors");

        return data;
    }
}