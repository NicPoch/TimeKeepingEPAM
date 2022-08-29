package com.epam.timekeeping.variant.boot.projectboot.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RequestDto implements Serializable {
    private Integer id;
    private String type;
}
