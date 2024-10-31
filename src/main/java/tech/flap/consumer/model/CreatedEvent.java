package tech.flap.consumer.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreatedEvent {
    private String mail;
    private String name;
    private String surname;
}