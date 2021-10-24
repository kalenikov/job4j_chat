package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.repo.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repo;

    public List<Room> findAll() {
        return repo.findAll();
    }

    public Optional<Room> findById(Integer id) {
        return repo.findById(id);
    }

    public void save(Room room) {
        repo.save(room);
    }
}
