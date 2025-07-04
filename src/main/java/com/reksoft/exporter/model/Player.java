package com.reksoft.exporter.model;

import lombok.Data;

//todo: заменить data на другое
@Data
public class Player {
    private Integer id;
    private String fullName;
    private String nickname;
    private Integer country;
    private String teamName;
}
