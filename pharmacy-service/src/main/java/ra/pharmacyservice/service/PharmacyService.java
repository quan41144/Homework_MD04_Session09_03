package ra.pharmacyservice.service;

import ra.pharmacyservice.dto.response.BillResponse;
import ra.pharmacyservice.entity.Pharmacy;

public interface PharmacyService {
    void savePharmacy();
    BillResponse getBill(Double totalPrice);
    void checkWarehouseStock(Long productId);
}
