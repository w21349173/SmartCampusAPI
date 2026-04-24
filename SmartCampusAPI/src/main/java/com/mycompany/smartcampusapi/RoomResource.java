package com.mycompany.smartcampusapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RoomResource {

    // GET all rooms
    @GET
    public Collection<Room> getRooms() {
        return DataStore.rooms.values();
    }

    // POST create room
    @POST
    public String addRoom(Room room) {
        DataStore.rooms.put(room.getId(), room);
        return "Room added successfully";
    }

    // GET one room
    @GET
    @Path("/{id}")
    public Room getRoom(@PathParam("id") String id) {
        return DataStore.rooms.get(id);
    }

    // DELETE room
    @DELETE
    @Path("/{id}")
    public String deleteRoom(@PathParam("id") String id) {

        Room room = DataStore.rooms.get(id);

        if (room != null && !room.getSensorIds().isEmpty()) {
            return "Cannot delete room. It has sensors.";
        }

        DataStore.rooms.remove(id);
        return "Room deleted";
    }
}