package com.mycompany.smartcampusapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.stream.Collectors;

@Path("/sensors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorResource {

    // GET all sensors (with optional filter)
    @GET
    public Collection<Sensor> getSensors(@QueryParam("type") String type) {

        if (type == null) {
            return DataStore.sensors.values();
        }

        return DataStore.sensors.values()
                .stream()
                .filter(s -> s.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    // POST create sensor
    @POST
    public String addSensor(Sensor sensor) {

        if (!DataStore.rooms.containsKey(sensor.getRoomId())) {
            return "Room does not exist";
        }

        DataStore.sensors.put(sensor.getId(), sensor);
        return "Sensor added successfully";
    }

    // Sub-resource for readings
    @Path("/{id}/readings")
    public SensorReadingResource getReadingResource() {
        return new SensorReadingResource();
    }
}