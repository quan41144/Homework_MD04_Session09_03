package ra.pharmacyservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pharmacies")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private Long id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 50, nullable = false, unique = true)
    private String hotline;
}
