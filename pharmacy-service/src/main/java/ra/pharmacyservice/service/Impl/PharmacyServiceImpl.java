package ra.pharmacyservice.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ra.pharmacyservice.dto.response.BillResponse;
import ra.pharmacyservice.entity.Pharmacy;
import ra.pharmacyservice.repository.PharmacyRepository;
import ra.pharmacyservice.service.PharmacyService;

@Service
@RequiredArgsConstructor
public class PharmacyServiceImpl implements PharmacyService {
    @Value("${app.branch-name}")
    private String branchName;
    @Value("${app.hotline}")
    private String hotline;
    @Value("${pharmacy.vat-rate}")
    private Double vatRate;
    private final PharmacyRepository pharmacyRepository;
    private final PharmacyManagementServiceImpl pharmacyManagementServiceImpl;

    @Override
    public void savePharmacy() {
        if (!pharmacyRepository.existsPharmacyByHotline(hotline)) {
            Pharmacy pharmacy = Pharmacy.builder()
                    .name(branchName)
                    .hotline(hotline)
                    .build();
            pharmacyRepository.save(pharmacy);
        }
    }

    @Override
    public BillResponse getBill(Double totalPrice) {
        Double vatAmount = vatRate * totalPrice;
        Double finalAmount = vatAmount + totalPrice;
        return BillResponse.builder()
                .totalPrice(totalPrice)
                .vatRate(vatRate)
                .vatAmount(vatAmount)
                .finalAmount(finalAmount)
                .build();
    }

    @Override
    public void checkWarehouseStock(Long productId) {
        pharmacyManagementServiceImpl.callWarehouseService(productId);
    }

}
