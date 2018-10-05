package com.test.demo.models;

import com.test.demo.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class V1PersonResponse {

    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public static V1PersonResponse fromPerson (Person person) {
        return V1PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .age(person.getAge())
                .build();
    }
}
