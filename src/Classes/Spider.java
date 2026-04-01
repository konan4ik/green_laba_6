package Classes;

import Components.AiComponent;
import Components.CollisionDamageComponent;
import Components.MovementComponent;

public class Spider extends Entity {

    public Spider()
    {
        setImage("spider.png");
    }

    @Override
    public void Start() {
        AddComponent(new MovementComponent(this));
        AddComponent(new CollisionDamageComponent(this));
        getComponent(CollisionDamageComponent.class).SetDmg(1);
        AddComponent(new AiComponent(this));
        getComponent(AiComponent.class).Start();
    }

    public void act()
    {
        if (getWorld() != null) {
            try {
                Update();
            } catch (RuntimeException e){
                System.out.println(e);
            }
        }
    }

}
