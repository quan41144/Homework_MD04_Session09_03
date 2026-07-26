package ra.warehouseservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warehouses")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name", length = 200, nullable = false)
    private String productName;
    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;
}
