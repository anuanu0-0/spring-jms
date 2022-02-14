package com.anuanu.springjms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GreetingMessage implements Serializable {
    static final long serialVersionUID = -7462433555964441775L;
    private UUID id;
    private String message;
}
