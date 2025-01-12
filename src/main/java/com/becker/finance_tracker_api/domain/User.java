package com.becker.finance_tracker_api.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser vazio ou conter apenas espaços em branco.")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "O email não pode ser vazio ou conter apenas espaços em branco.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha não pode ser vazia ou conter apenas espaços em branco.")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "O número de telefone não pode ser vazio ou conter apenas espaços em branco.")
    @Pattern(regexp = "^[1-9]{2}[9]{1}[0-9]{8}$", message = "Número de telefone inválido. O formato correto é DDD + 9 dígitos.")
    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
