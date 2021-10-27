package ru.job4j.chat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {
    @NotBlank(message = "Text must be not empty")
    private String text;
    @NotNull(message = "Room id must be non null")
    private int roomId;
}