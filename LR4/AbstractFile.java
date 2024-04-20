package LR4;

import LR4.interfaces.LocationInCatalog;
import LR4.interfaces.Nameable;
import LR4.interfaces.Sizable;

abstract public class AbstractFile implements LocationInCatalog, Sizable, Nameable {
    abstract public Catalog getCatalog();

    abstract public void setCatalog(Catalog catalog);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public Long getSize();
    abstract public void setSize(Long size);
}
