package LR4;

import java.util.Objects;

public class File extends AbstractFile {
    private Catalog catalog = null;
    private String name = null;
    private Long size;
    private String content = null;

    public File(Catalog catalog, String name, Long size) {
        this.size = size;
        this.catalog = catalog;
        this.name = name;
    }

    @Override
    public Catalog getCatalog() {
        return this.catalog;
    }

    @Override
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
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
        return this.size;
    }

    @Override
    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(Long content) {
        this.content = String.valueOf(content);
    }

    public boolean equals(File object) {
        return Objects.equals(object.getName(), this.name) && Objects.equals(object.getCatalog(), this.catalog);
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
