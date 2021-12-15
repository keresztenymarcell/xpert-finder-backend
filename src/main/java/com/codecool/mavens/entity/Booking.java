package com.codecool.mavens.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Booking {
    private Long id;
    private boolean showMyContact;
    private String content;
}
