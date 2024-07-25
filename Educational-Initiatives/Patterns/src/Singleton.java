//Singleton Pattern
//Use Case: Ensuring a single instance of a configuration manager.

class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public void display() {
        System.out.println("ConfigurationManager instance");
    }
}