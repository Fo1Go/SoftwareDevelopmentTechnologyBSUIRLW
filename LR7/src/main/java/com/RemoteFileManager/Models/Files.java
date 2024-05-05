package com.RemoteFileManager.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "files")
public class Files {
    @Id
    @SequenceGenerator(name = "filesSecGen", sequenceName = "files_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "filesSecGen")
    private Long id;

    @Column(length = 2048, name = "name")
    private String name;

    @Column(length = 2048, name = "size")
    private Long size;

    public Files(String name, Long size) {
        this.name = name;
        this.size = size;
    }
}
