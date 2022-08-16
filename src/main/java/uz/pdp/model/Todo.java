package uz.pdp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Todo {
    private Long id;
    private String todo;
    private String time;
    private String date;
    private boolean completed;

}
