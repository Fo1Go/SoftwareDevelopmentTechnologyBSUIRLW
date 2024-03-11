package LR4;

import LR4.interfaces.Executable;

public class ExecutableFile extends File implements Executable {
    private boolean isExecutable = true;
    private String version;
    public ExecutableFile(Catalog catalog, String name, Long size) {
        super(catalog, name, size);
    }

    @Override
    public boolean isExecutable() {
        return this.isExecutable;
    }

    @Override
    public void execute() {
        System.out.println("I am execute");
    }

    @Override
    public void switchExecutable() {
        this.isExecutable = !this.isExecutable;
    }
}
