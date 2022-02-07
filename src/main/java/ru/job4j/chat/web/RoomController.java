package ru.job4j.chat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.service.RoomService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody Room dto) {
        roomService.save(new Room(dto.getName()));
    }

    @PatchMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void edit(@Valid @RequestBody Room dto) {
        Optional<Room> room = roomService.findById(dto.getId());
        if (room.isEmpty()) {
            throw new EntityNotFoundException("Room not found");
        }
        roomService.save(Room.of(dto.getId(), dto.getName()));
    }

}
