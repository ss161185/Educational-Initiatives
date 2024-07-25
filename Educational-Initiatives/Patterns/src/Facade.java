//Facade Pattern
//Use Case: Simplifying access to a complex subsystem for home theater components.

class Amplifier {
    public void on() { System.out.println("Amplifier on"); }
    public void off() { System.out.println("Amplifier off"); }
}

class DVDPlayer {
    public void play() { System.out.println("DVD playing"); }
    public void stop() { System.out.println("DVD stopped"); }
}

// Facade
class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;

    public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd) {
        this.amp = amp;
        this.dvd = dvd;
    }

    public void watchMovie() {
        amp.on();
        dvd.play();
    }

    public void endMovie() {
        dvd.stop();
        amp.off();
    }
}
