package hu.progtech.bead;

public class Star extends CelestialBody {
    public String brightness;

    public Star(String id, String name, String diameter, String mass, String brightness, String universe_id) {
        this.id = id;
        this.name = name;
        this.diameter = diameter;
        this.mass = mass;
        this.brightness = brightness;
        this.universe_id = universe_id;
    }
}
