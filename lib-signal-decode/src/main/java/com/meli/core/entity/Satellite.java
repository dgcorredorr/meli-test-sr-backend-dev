package com.meli.core.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Satellite {
    private String name;
    private double x;
    private double y;
    private String[] message;
}

