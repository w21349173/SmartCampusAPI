package com.mycompany.smartcampusapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorReadingResource {

    @GET
    public List<SensorReading> getReadings(@PathParam("id") String id) {
        return DataStore.readings.getOrDefault(id, new ArrayList<>());
    }

    @POST
    public String addReading(@PathParam("id") String id, SensorReading reading) {

        Sensor sensor = DataStore.sensors.get(id);

        if (sensor == null) {
            return "Sensor not found";
        }

        if ("MAINTENANCE".equalsIgnoreCase(sensor.getStatus())) {
            return "Sensor is in maintenance and cannot accept readings";
        }

        DataStore.readings.putIfAbsent(id, new ArrayList<>());
        DataStore.readings.get(id).add(reading);

        sensor.setCurrentValue(reading.getValue());

        return "Reading added successfully";
    }
}