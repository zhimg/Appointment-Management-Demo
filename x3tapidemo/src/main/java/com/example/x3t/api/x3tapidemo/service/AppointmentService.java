package com.example.x3t.api.x3tapidemo.service;

import com.example.x3t.api.x3tapidemo.dto.AppointmentRequest;
import com.example.x3t.api.x3tapidemo.dto.AppointmentResponse;
import com.example.x3t.api.x3tapidemo.entity.Appointment;
import com.example.x3t.api.x3tapidemo.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppointmentService {

    private final AppointmentRepository appointmentRepo;

    public void createApointment(AppointmentRequest appointmentRequest){
        Appointment appointment = Appointment.builder().name(appointmentRequest.getName())
                .email(appointmentRequest.getEmail())
                .phone(appointmentRequest.getPhone())
                .appointmentSlot(appointmentRequest.getAppointmentSlot())
                .build();

        appointmentRepo.save(appointment);
        log.info("Appointment is Saved " +  appointment.getId());
    }

    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepo.findAll();
        return appointments.stream().map(this::mapToAppointment).toList();
    }

    private AppointmentResponse mapToAppointment(Appointment appointment) {
        return AppointmentResponse.builder().id(appointment.getId()).name(appointment.getName())
                .email(appointment.getEmail()).phone(appointment.getPhone())
                .appointmentSlot(appointment.getAppointmentSlot()).build();
    }

    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(String.valueOf(id));
    }


    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existAppointment = getAppointmentById(id).orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));;

        existAppointment.setEmail(existAppointment.getEmail());
        existAppointment.setName(existAppointment.getName());
        existAppointment.setPhone(existAppointment.getPhone());
        existAppointment.setAppointmentSlot(existAppointment.getAppointmentSlot());
        return appointmentRepo.save(existAppointment);
    }

    private Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepo.findById(String.valueOf(id));
    }
}
