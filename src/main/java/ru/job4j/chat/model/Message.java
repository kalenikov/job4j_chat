package ru.job4j.chat.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    private Timestamp created = Timestamp.valueOf(LocalDateTime.now());
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}