package ra.warehouseservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.warehouseservice.dto.response.ApiResponse;
import ra.warehouseservice.service.WarehouseService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;
    @GetMapping("/stock/{id}")
    public ResponseEntity<ApiResponse<?>> getWarehouseStock(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Lấy thông tin tồn kho thành công!",
                warehouseService.getStockById(id),
                null,
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
