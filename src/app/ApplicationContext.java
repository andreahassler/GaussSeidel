package app;

import logic.Plate;

/**
 * This class is the central container for the main data structures and other information that is
 * used throughout the application. This way, only the application context needs to be passed
 * around the various classes instead of many individual variables.
 */
public class ApplicationContext {
    private String version;
    private String name;
    private Plate plate;


    public ApplicationContext(String version, String name) {
        this.version = version;
        this.name = name;
        //plate = new Plate(3,3);
        //imageModel = new SimpleImageModel(gridData);

    }

    public String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

}
