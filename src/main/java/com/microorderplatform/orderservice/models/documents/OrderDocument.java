package com.microorderplatform.orderservice.models.documents;


import com.microorderplatform.orderservice.enums.StatusOrderEnum;
import com.microorderplatform.orderservice.models.ItemOrder;
import com.microorderplatform.orderservice.utils.order.BaseModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDocument extends BaseModel implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull(message = "userId is required")
    private String userId;

    private StatusOrderEnum status = StatusOrderEnum.PENDING;

    @NotNull(message = "totalPayment is required")
    private BigDecimal totalPayment;
    @NotNull(message = "items is required")
    private List<ItemOrder> items;

    public OrderDocument(String userId, BigDecimal totalPayment, List<ItemOrder> items) {
        this.userId = userId;
        this.totalPayment = totalPayment;
        this.items = items;
    }


}
