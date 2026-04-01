package Components;

import Classes.Entity;

public abstract class Component {

    public Entity entity;
    public void Update() {

    }

    public Component(Entity entity) {
        this.entity = entity;
    }
}
