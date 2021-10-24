package ru.job4j.chat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.chat.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
