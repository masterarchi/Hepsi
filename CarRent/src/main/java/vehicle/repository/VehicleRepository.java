package product.repository;

import product.entity.Vehicle;
import product.util.MyRepositoryFactory;

public class VehicleRepository extends MyRepositoryFactory<Vehicle,Long> {
    public VehicleRepository() {
        super(Vehicle.class);
    }
}
