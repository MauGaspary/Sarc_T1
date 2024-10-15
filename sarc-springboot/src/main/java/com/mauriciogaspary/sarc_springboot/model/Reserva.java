// package com.mauriciogaspary.sarc_springboot.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.IdClass;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;

// import java.time.LocalDate;
// import java.util.List;

// @Entity
// @IdClass(ReservaId.class)
// public class Reserva {

//     @Id
//     private LocalDate data;

//     @Id
//     private String horario;

//     @Id
//     @ManyToOne
//     @JoinColumn(name = "turma_id", nullable = false)
//     private Turma turma;

//     @ManyToMany
//     @JoinTable(
//         name = "reserva_recursos",
//         joinColumns = {
//             @JoinColumn(name = "data"),
//             @JoinColumn(name = "horario"),
//             @JoinColumn(name = "turma_id")
//         },
//         inverseJoinColumns = @JoinColumn(name = "recurso_id")
//     )
//     private List<Recurso> recursos;

//     // Construtores, Getters e Setters
// }
