package ru.ithub.delivery.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ithub.delivery.entity.EOrderStatus;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private Long customerId;
    private Long driverId;
    private Set<Long> productsId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String startPoint;
    private String currentPoint = startPoint;
    private String finishPoint;
    private EOrderStatus status = EOrderStatus.WAITING;
}
