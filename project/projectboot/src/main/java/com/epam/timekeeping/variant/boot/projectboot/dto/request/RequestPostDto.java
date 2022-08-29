package com.epam.timekeeping.variant.boot.projectboot.dto.request;

import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPostDto implements Serializable {
    private Integer id;
    private Integer client;
    private Integer activity;
    private String type;
}
