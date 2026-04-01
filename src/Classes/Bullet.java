package Classes;

import Components.MovementComponent;

public class Bullet extends Entity {

    public Bullet(){
        setImage("bullet.png");
    }

    @Override
    public void Start() {
        AddComponent(new MovementComponent(this));
        getComponent(MovementComponent.class).SetSpeed(5);

    }
}
