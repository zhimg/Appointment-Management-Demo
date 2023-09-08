package com.example.x3t.api.x3tapidemo.controller;

import com.example.x3t.api.x3tapidemo.dto.AppointmentRequest;
import com.example.x3t.api.x3tapidemo.dto.AppointmentResponse;
import com.example.x3t.api.x3tapidemo.entity.Appointment;
import com.example.x3t.api.x3tapidemo.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/appointments")
@RequiredArgsConstructor

public class AppointmentController {

    // Dependency for service class
    private final AppointmentService appointmentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create Appointment",
            description= "Creating And Storing Appointment Details")
    @ApiResponse(responseCode = "200", description = "Created Successfully")
    public void createApointment(@RequestBody AppointmentRequest appointmentRequest){
        // Validating Date Logic
        appointmentService.createApointment(appointmentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Appointment",
            description= "Get All the Appointment Details")
    @ApiResponse(responseCode = "200", description = "Get Records successfully")
    public List<AppointmentResponse> getAllAppointment(){
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete Appointment",
            description= "Delete Appointments By Id")
    @Parameter(name = "Id",description = "Appointment that need to be deleted", required = true)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Successfully"),
            @ApiResponse(responseCode = "400", description = "Request URI is not proper"),
            @ApiResponse(responseCode = "404", description = "Requested URL can not be found on the server")})
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Appointment",
            description= "Update Existing Appointments By passing the updated values for particular user")
    @Parameter(name = "Id",description = "Appointment that need to be updated", required = true)
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        return appointmentService.updateAppointment(id, updatedAppointment);
        // Exception Handling
    }

}
