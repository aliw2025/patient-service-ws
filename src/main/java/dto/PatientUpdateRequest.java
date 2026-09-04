package dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PatientUpdateRequest {

    @NotBlank(message = "{patient.firstName.required}")
    @Size(max = 100, message = "{patient.firstName.maxLength}")
    private String firstName;

    @NotBlank(message = "{patient.lastName.required}")
    @Size(max = 100, message = "{patient.lastName.maxLength}")
    private String lastName;

    private LocalDate dateOfBirth;

    @Size(max = 20, message = "{patient.gender.maxLength}")
    private String gender;

    @Size(max = 30, message = "{patient.phone.maxLength}")
    private String phone;

    @Email(message = "{patient.email.invalid}")
    @Size(max = 150, message = "{patient.email.maxLength}")
    private String email;
}
