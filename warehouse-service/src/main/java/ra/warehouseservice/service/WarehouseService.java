package ra.warehouseservice.service;

import ra.warehouseservice.dto.response.WarehouseResponse;

public interface WarehouseService {
    WarehouseResponse getStockById(Long id);
}
