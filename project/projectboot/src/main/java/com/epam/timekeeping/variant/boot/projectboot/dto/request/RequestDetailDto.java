package com.epam.timekeeping.variant.boot.projectboot.dto.request;

import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDetailDto implements Serializable {
    private Integer id;
    private ClientDto client;
    private ActivityDto activity;
    private String type;
}
