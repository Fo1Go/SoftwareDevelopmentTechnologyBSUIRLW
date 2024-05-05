package com.RemoteFileManager.Server.Abstract;

import com.RemoteFileManager.Server.Catalog;
import com.RemoteFileManager.Server.File;

import java.util.ArrayList;

abstract public class AbstractCatalog {
    abstract public String getLocation();

    abstract public void setLocation(String location);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public Long getSize();

    abstract public void countSize();

    abstract public void appendFile(File file);

    abstract public void appendFiles(File... file);

    abstract public void appendCatalog(Catalog catalog);

    abstract public void appendCatalogs(Catalog... catalogs);
    abstract public ArrayList<Catalog> getCatalogs();
    abstract public ArrayList<File> getFiles();
}
