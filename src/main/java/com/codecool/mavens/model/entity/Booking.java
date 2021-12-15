package com.codecool.mavens.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {
    private Long id;
    private boolean showMyContact;
    private String content;
}
