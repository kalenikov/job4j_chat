package ru.job4j.chat.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor(staticName = "of")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Room(String name) {
        this.name = name;
    }
}
