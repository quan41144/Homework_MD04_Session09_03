package ra.pharmacyservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.pharmacyservice.dto.response.ApiResponse;
import ra.pharmacyservice.service.PharmacyService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RefreshScope
public class PharmacyController {
    private final PharmacyService pharmacyService;
    @PostMapping("/bill")
    public ResponseEntity<ApiResponse<?>> getBill(@RequestParam("total_price") Double totalPrice) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Tính tổng tiền thành công!",
                pharmacyService.getBill(totalPrice),
                null,
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
    @GetMapping("/pharmacies/stock/{id}")
    public ResponseEntity<ApiResponse<?>> getPharmaciesStockById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Kiểm tra tồn kho thành công!",
                pharmacyService.checkWarehouseStock(id),
                null,
                LocalDateTime.now()
        ), HttpStatus.OK);
    }
}
