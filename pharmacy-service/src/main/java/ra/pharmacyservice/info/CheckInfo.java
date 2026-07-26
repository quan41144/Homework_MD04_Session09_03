package ra.pharmacyservice.info;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ra.pharmacyservice.repository.PharmacyRepository;
import ra.pharmacyservice.service.PharmacyService;

@Component
@RequiredArgsConstructor
public class CheckInfo {
    private final PharmacyService pharmacyService;
    @Value("${app.branch-name}")
    private String branchName;
    @Value("${app.hotline}")
    private String hotline;
    @PostConstruct
    public void init() {
        System.out.println("Application started!");
        System.out.println("Branch: " + branchName);
        System.out.println("Hotline: " + hotline);
        pharmacyService.savePharmacy();
    }
}
