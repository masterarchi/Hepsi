package product.repository;

import product.entity.VehicleDetail;
import product.util.MyRepositoryFactory;

public class VehicleDetailRepository extends MyRepositoryFactory<VehicleDetail,Long> {
    public VehicleDetailRepository() {
        super(VehicleDetail.class);
    }
}
