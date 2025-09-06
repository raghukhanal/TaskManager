package com.raghukhanal.task_manager.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {

    private @Getter @Setter Long taskId;
    private @Getter @Setter String title;
    private @Getter @Setter boolean completed;

}
