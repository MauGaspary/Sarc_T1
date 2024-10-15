// package com.mauriciogaspary.sarc_springboot.service;

// import org.hibernate.mapping.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.mauriciogaspary.sarc_springboot.model.Recurso;
// import com.mauriciogaspary.sarc_springboot.model.Reserva;

// @Service
// public class ReservaService {
    
//     @Autowired
//     private ReservaRepository reservaRepository;

//     public Reserva criarReserva(Reserva reserva) {
//         // Verificar se o recurso já está reservado no horário e data fornecidos
//         for (Recurso recurso : reserva.getRecursos()) {
//             boolean recursoOcupado = reservaRepository.existsByDataAndHorarioAndRecursosContains(
//                 reserva.getData(), reserva.getHorario(), recurso);
//             if (recursoOcupado) {
//                 throw new RuntimeException("Recurso já reservado nesse horário");
//             }
//         }
//         return reservaRepository.save(reserva);
//     }

//     public List<Reserva> listarReservasPorData(LocalDate data) {
//         return reservaRepository.findByData(data);
//     }
// }
