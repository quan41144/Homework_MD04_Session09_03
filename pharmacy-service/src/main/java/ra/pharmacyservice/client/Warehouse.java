package ra.pharmacyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "warehouseService", url = "http://localhost:8082")
public interface Warehouse {
    @GetMapping("/api/v1/warehouses/stock/{id}")
    String getWarehouseStockById(@PathVariable Long id);
}
