package ra.pharmacyservice.service.Impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.pharmacyservice.client.Warehouse;

@Service
@RequiredArgsConstructor
public class PharmacyManagementServiceImpl {
    private final Warehouse warehouse;
    @CircuitBreaker(name = "warehouseCB")
    public Object callWarehouseService(Long id) {
        return warehouse.getWarehouseStockById(id);
    }
}
