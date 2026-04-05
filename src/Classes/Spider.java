package Classes;

import Components.*;
import util.FractionType;

public class Spider extends Entity {

    public Spider()
    {
        setImage("spider.png");
    }

    @Override
    public void start() {
        AddComponent(HealthComponent.class).setHealth(1);
        AddComponent(MovementComponent.class).setSpeed(3);
        AddComponent(CollisionDamageComponent.class);
        AddComponent(TargetComponent.class);
        AddComponent(PersecutionComponent.class);
        AddComponent(FractionComponent.class).setFraction(FractionType.Enemy);
        AddComponent(AiFiringComponent.class).setTimer(90);
    }

}
