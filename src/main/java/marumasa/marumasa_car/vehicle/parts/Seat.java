package marumasa.marumasa_car.vehicle.parts;

import marumasa.marumasa_car.vehicle.Vehicle;
import marumasa.marumasa_car.vehicle.VehicleController;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.util.Vector;

public class Seat extends TrackingDisplay {

    public Interaction seat;

    public Seat(Vector vector) {
        super(vector, EntityType.ITEM_DISPLAY);
    }

    @Override
    public Display create(World world, Location location, Vehicle vehicle) {
        final ItemDisplay itemDisplay = (ItemDisplay) super.create(world, location, vehicle);

        itemDisplay.setTeleportDuration(2);

        seat = (Interaction) new Part(
                vector,
                EntityType.INTERACTION
        ).create(world, location, vehicle);

        itemDisplay.addPassenger(seat);
        VehicleController.SeatList.add(seat);

        return itemDisplay;
    }
}