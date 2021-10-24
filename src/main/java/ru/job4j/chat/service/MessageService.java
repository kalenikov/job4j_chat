package ru.job4j.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.chat.model.Message;
import ru.job4j.chat.repo.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repo;

    public List<Message> findAllByRoomId(Integer id) {
        return repo.findAllByRoomIdOrderByCreatedDesc(id);
    }

    public void save(Message message) {
        repo.save(message);
    }
}
