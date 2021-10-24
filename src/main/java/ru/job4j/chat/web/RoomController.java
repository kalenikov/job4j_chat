package ru.job4j.chat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {
    @Autowired
    public RoomService roomService;

    @GetMapping("/")
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody String name) {
        roomService.save(new Room(name));
    }
}
