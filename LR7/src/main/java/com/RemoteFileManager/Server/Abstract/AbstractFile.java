package com.RemoteFileManager.Server.Abstract;

import com.RemoteFileManager.Server.Catalog;

abstract public class AbstractFile {
    abstract public Catalog getCatalog();

    abstract public void setCatalog(Catalog catalog);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public Long getSize();
    abstract public void setSize(Long size);
}
