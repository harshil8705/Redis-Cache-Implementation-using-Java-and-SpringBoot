package com.harshilInfotech.cacheTut.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, scale = 1)
    private Double experience;

    @Column(nullable = false)
    private Double salary;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "department_fk_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Department department;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

}
