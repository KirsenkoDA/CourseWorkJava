package ru.vlsu.ispi.dto;

import lombok.Data;

@Data
public class EditProductDTO {
    private Long id;
    private String name;
    private Long groupId;
}
