package ru.job4j.chat.service;

import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.repo.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository repo;

    public MessageService(MessageRepository repo) {
        this.repo = repo;
    }

    public List<Message> findAllByRoomId(Integer id) {
        return repo.findAllByRoomIdOrderByCreatedDesc(id);
    }

    public void save(Message message) {
        repo.save(message);
    }

    public Optional<Message> findById(Integer id) {
        return repo.findById(id);
    }
}
