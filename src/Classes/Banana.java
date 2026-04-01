package Classes;

import Components.ControlsComponent;
import Components.HealthComponent;
import Components.MovementComponent;

public class Banana extends Entity {

    public HpCounter hpCounter;

    public Banana(HpCounter hpCounter)
    {
        setImage("bananas.png");
        this.hpCounter = hpCounter;
    }

    @Override
    public void Start() {
        AddComponent(new HealthComponent(this));
        getComponent(HealthComponent.class).SetHealth(3);
        AddComponent(new ControlsComponent(this));
        AddComponent(new MovementComponent(this));
        getComponent(ControlsComponent.class).Start();
    }

    public void act()
    {
        Update();
        hpCounter.Update(getComponent(HealthComponent.class).GetHealth());
    }

}
