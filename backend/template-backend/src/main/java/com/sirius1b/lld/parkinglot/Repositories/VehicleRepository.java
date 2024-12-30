package parkinglot.Repositories;

import java.util.HashMap;
import java.util.Map;

import parkinglot.Models.Vehicle;
import parkinglot.Models.VehicleType;

public class VehicleRepository {
    
        
    Map<String, Vehicle> vehicles;
    
    VehicleRepository(){
        vehicles = new HashMap<>();
    }

    public Vehicle getById(String id){
        return vehicles.get(id);
    }

    public Vehicle addVehicle(String num, VehicleType type){
        Vehicle v = new Vehicle();
        v.setType(type);
        v.setVehicleNo(num);
        v.setVehicleId(num);

        vehicles.put(num, v);
        return v;
        
    }
}
