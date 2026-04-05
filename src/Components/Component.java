package Components;

import Classes.Entity;

public abstract class Component {

    public Entity entity;
    public void update() {

    }

    public Component(Entity entity) {
        this.entity = entity;
    }

    public void start() {

    }
}
