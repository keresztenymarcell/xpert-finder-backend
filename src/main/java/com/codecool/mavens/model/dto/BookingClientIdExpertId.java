package com.codecool.mavens.model.dto;

import com.codecool.mavens.model.entity.Booking;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingClientIdExpertId {
    private Long clientId;
    private Long expertId;
    private Booking booking;
}
