package pja.edu.s18591.multiAspect.module;

public class ResourceBase extends Strategic {
    private int resources;

    public ResourceBase(int resources) {
        setResources(resources);
    }

    public int getResources() {
        return resources;
    }

    private void setResources(int resources) {
        this.resources = resources;
    }
}
