package Classes;

import Components.Component;
import greenfoot.Actor;
import greenfoot.World;

import java.util.HashMap;

public abstract class Entity extends Actor {

    public HashMap<Class<? extends Component>, Component> components = new HashMap<>();

    public abstract void start();

    @Override
    protected void addedToWorld(World world) {
        super.addedToWorld(world);
        start();
    }

    public void setLocation(double x, double y) {
        setLocation((int)(x), (int)(y));
    }

    public <T extends Component> T getComponent(Class<T> target) {

        return (T) components.get(target);
    }

    public <T extends Component> T AddComponent(Class<T> component) {
        var x = components.get(component);
        if (x != null) {
            return (T)x;
        }
        try {
            var com = component.getDeclaredConstructor(Entity.class).newInstance(this);
            components.put(component, com);
            com.start();
            return com;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update() {
        if (getWorld() != null) {
            for (Component component : components.values()) {
                try {
                component.update();
                } catch (RuntimeException e){
                    System.out.println(e);
                    e.printStackTrace();
                }
                if (getWorld() == null) {
                    return;
                }
            }
        }
    }

    public void act() {
        update();
    }
}
