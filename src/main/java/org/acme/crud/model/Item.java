package org.acme.crud.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Item {

    private Long id;
    private String name;
    private String count;
    private String status;
}
