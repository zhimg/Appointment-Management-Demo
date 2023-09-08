package com.example.x3t.api.x3tapidemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Appointment {

    @Id
    @Column(name = "Id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private String Id;


    private String name;
    private String email;
    private String phone;
    private LocalDateTime appointmentSlot;
}
