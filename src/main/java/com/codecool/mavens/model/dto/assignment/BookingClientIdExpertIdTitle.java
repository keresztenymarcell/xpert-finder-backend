package com.codecool.mavens.model.dto.assignment;

import com.codecool.mavens.model.entity.Booking;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingClientIdExpertIdTitle {
    private Long clientId;
    private Long expertId;
    private String title;
    private Booking booking;
}
