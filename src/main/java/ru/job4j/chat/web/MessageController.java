package ru.job4j.chat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.model.MessageDto;
import ru.job4j.chat.model.Room;
import ru.job4j.chat.service.MessageService;
import ru.job4j.chat.service.RoomService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;
    private final RoomService roomService;

    public MessageController(MessageService messageService, RoomService roomService) {
        this.messageService = messageService;
        this.roomService = roomService;
    }

    @GetMapping("/{roomId}")
    public List<Message> findAllByRoomId(@PathVariable @NotBlank Integer roomId) {
        return messageService.findAllByRoomId(roomId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody MessageDto messageDto) {
        Optional<Room> room = roomService.findById(messageDto.getRoomId());
        if (room.isEmpty()) {
            throw new EntityNotFoundException("Room not found");
        }
        messageService.save(new Message(messageDto.getText(), room.get()));
    }

    @PatchMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void edit(@RequestBody Map<String, String> body) {
        Optional<Message> message = messageService.findById(Integer.valueOf(body.get("id")));
        if (message.isEmpty()) {
            throw new EntityNotFoundException("Message not found");
        }
        message.get().setText(body.get("text"));
        messageService.save(message.get());
    }
}
