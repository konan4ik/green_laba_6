package Classes;

import Components.Component;
import greenfoot.Actor;
import greenfoot.World;
import java.util.HashMap;

public abstract class Entity extends Actor {

    public HashMap<Class<? extends Component>, Component> components = new HashMap<>();

    public abstract void Start();

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        Start();
    }

    public void setLocation(double x, double y) {
        setLocation((int)(x), (int)(y));
    }

    public <T extends Component> T getComponent(Class<T> target) {

        return (T) components.get(target);
    }

    public void AddComponent(Component component) {
        components.put(component.getClass(), component);
    }

    public void Update() {
        for (Component component : components.values()) {
            component.Update();
        }
    }
}
