package Classes;

import Components.*;
import util.FractionType;

public class Banana extends Entity {

    public Banana()
    {
        setImage("bananas.png");
    }

    @Override
    public void start() {
        AddComponent(HealthComponent.class).setHealth(3);
        AddComponent(MovementComponent.class);
        AddComponent(ControlsComponent.class);
        AddComponent(FractionComponent.class).setFraction(FractionType.Player);
        AddComponent(PlayerFiringComponent.class).setTimer(30);
    }

}
