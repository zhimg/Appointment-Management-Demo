package com.example.x3t.api.x3tapidemo.repository;

import com.example.x3t.api.x3tapidemo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String> {
}
