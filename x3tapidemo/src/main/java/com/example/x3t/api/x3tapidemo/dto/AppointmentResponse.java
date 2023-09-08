package com.example.x3t.api.x3tapidemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime appointmentSlot;
}
