package ra.warehouseservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.warehouseservice.dto.response.WarehouseResponse;
import ra.warehouseservice.entity.Warehouse;
import ra.warehouseservice.exception.ResourceNotFoundException;
import ra.warehouseservice.repository.WarehouseRepository;
import ra.warehouseservice.service.WarehouseService;
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Override
    public WarehouseResponse getStockById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));
        return WarehouseResponse.builder()
                .id(warehouse.getId())
                .productName(warehouse.getProductName())
                .stockQuantity(warehouse.getStockQuantity())
                .build();
    }
}
