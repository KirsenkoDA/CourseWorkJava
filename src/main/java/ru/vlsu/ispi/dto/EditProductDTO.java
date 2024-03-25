package ru.vlsu.ispi.dto;

import lombok.Data;
import ru.vlsu.ispi.model.Characteristic;

import java.util.List;

@Data
public class EditProductDTO {
    private Long id;
    private String name;
    private Long groupId;
    private List<Characteristic> characteristicList;
}
