package com.example.onlinecourseplatform.user;
import com.example.onlinecourseplatform.Course.Course;
import com.example.onlinecourseplatform.Enrollment.Enrollment;
import com.example.onlinecourseplatform.Role.Role;
import com.example.onlinecourseplatform.Submission.Submission;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean accountNonExpired = true;

    private String resetToken;
    private String verificationToken;
    private LocalDateTime tokenExpiryDate;

    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "user")
    private List<Submission> submissions;

    // Getters and Setters
}
