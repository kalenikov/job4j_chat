package ru.job4j.chat.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.job4j.chat.model.Message;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
public interface MessageRepository extends PagingAndSortingRepository<Message, Integer> {
}
