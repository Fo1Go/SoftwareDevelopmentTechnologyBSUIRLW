package com.RemoteFileManager.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@Entity(name="catalogs")
public class Catalogs {
    @Id
    @SequenceGenerator(name = "catalogsSecGen", sequenceName = "catalogs_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "catalogsSecGen")
    private Long id;

    @Column(length = 2048, name = "name")
    private String name;

    @JoinColumn(name = "catalog_id")
    @ManyToOne
    private Catalogs subCatalog;

    @OneToMany(mappedBy = "subCatalog", fetch = FetchType.EAGER)
    private Collection<Catalogs> subCatalogs;

    @OneToMany(mappedBy = "subCatalog", fetch = FetchType.EAGER)
    private Collection<Files> files;
}
