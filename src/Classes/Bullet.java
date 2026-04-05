package Classes;

import Components.CollisionDamageComponent;
import Components.FractionComponent;
import Components.MovementComponent;

public class Bullet extends Entity {

    public Bullet(){
        setImage("bullet.png");
    }

    @Override
    public void start() {
        AddComponent(MovementComponent.class).setSpeed(5);
        AddComponent(FractionComponent.class);
        AddComponent(CollisionDamageComponent.class);
    }

}
