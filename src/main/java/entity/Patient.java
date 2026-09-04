package entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "phone", length = 30)
    private String phone;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;


    @OneToMany(
            mappedBy = "patient",
            fetch = FetchType.LAZY
    )
    private List<Note> notes;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}

//"Patient.notes is mapped by the patient field in the Note entity."
//This tells Hibernate that Note owns the database relationship.
//The foreign key is:
//    note.patient_id → patient.patient_id
//    Therefore Note is the owning side.

//    4. Why is Note the owning side?
//
//    Because the foreign key physically exists in the note table:
//
//    patient_id BIGINT NOT NULL
//
//    So this:
//
//    @JoinColumn(name = "patient_id")
//
//    controls the actual database relationship.
//
//            Whereas this:
//
//    @OneToMany(mappedBy = "patient")
//
//    doesn't create another foreign key.
//
//    It's basically saying:
//            "I know that the relationship is already managed by Note.patient."
