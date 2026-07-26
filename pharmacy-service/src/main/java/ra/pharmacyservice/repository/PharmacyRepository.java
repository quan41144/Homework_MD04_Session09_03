package ra.pharmacyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.pharmacyservice.entity.Pharmacy;
@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    Boolean existsPharmacyByHotline(String hotline);
}
