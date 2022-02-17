package com.codecool.mavens.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImportantInfoDto {
    private String username;
    private Long id;
    private boolean isExpert;
}
