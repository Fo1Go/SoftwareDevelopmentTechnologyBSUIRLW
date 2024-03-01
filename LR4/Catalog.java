package LR4;

import java.util.ArrayList;
import java.util.Objects;

public class Catalog extends AbstractCatalog {
    private String location = null;
    private String name = null;
    private Long size;
    private ArrayList<File> files = new ArrayList<File>();
    private ArrayList<Catalog> catalogs = new ArrayList<Catalog>();

    public Catalog(String location, String name) {
        this.location = location;
        this.name = name;
    }

    @Override
    public String getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getSize() {
        this.countSize();
        return this.size;
    }

    @Override
    public void countSize() {
        Long totalSize = 0L;
        for (File file : this.files) {
            totalSize += file.getSize();
        }
        for (Catalog catalog : this.catalogs) {
            totalSize += catalog.getSize();
        }
        this.size = totalSize;
    }

    @Override
    public void appendFile(File file) {
        this.files.add(file);
    }

    @Override
    public void appendFiles(File... files) {
        for (File file : files) {
            this.appendFile(file);
        }
    }

    @Override
    public void appendCatalog(Catalog catalog) {
        this.catalogs.add(catalog);
    }

    @Override
    public void appendCatalogs(Catalog... catalogs) {
        for (Catalog catalog : catalogs) {
            this.appendCatalog(catalog);
        }
    }

    @Override
    public ArrayList<Catalog> getCatalogs() {
        return this.catalogs;
    }

    @Override
    public ArrayList<File> getFiles() {
        return this.files;
    }

    public ArrayList<File> findFilesByExtension(String extension, boolean recursively) {
        ArrayList<File> foundFiles = new ArrayList<File>();
        for (File file : this.files) {
            if (file.getName().endsWith(extension)) {
                foundFiles.add(file);
            }
        }
        if (recursively && !this.catalogs.isEmpty()) {
            for (Catalog catalog : this.catalogs) {
                foundFiles.addAll(catalog.findFilesByExtension(extension, true));
            }
        }
        return foundFiles;
    }

    public boolean equals(Catalog object) {
        return Objects.equals(object.getName(), this.name) && Objects.equals(object.getLocation(), this.location);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "File(filename: " + this.name + ", size: " + this.size.toString() + ")";
    }
}
