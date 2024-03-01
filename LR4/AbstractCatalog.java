package LR4;

import LR4.interfaces.Nameable;
import LR4.interfaces.PathToCatalog;
import LR4.interfaces.Sizable;

import java.nio.file.Path;
import java.util.ArrayList;

abstract public class AbstractCatalog implements PathToCatalog, Sizable, Nameable {
    abstract public String getLocation();

    @Override
    abstract public void setLocation(String location);

    @Override
    abstract public String getName();

    @Override
    abstract public void setName(String name);

    @Override
    abstract public Long getSize();

    abstract public void countSize();

    abstract public void appendFile(File file);

    abstract public void appendFiles(File... file);

    abstract public void appendCatalog(Catalog catalog);

    abstract public void appendCatalogs(Catalog... catalogs);
    abstract public ArrayList<Catalog> getCatalogs();
    abstract public ArrayList<File> getFiles();
}
