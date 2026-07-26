package ra.pharmacyservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BillResponse {
    private Double totalPrice;
    private Double vatRate;
    private Double vatAmount;
    private Double finalAmount;
}
