package Components;

import Classes.Entity;
import util.EmptyArg;
import util.Event;

public class HealthComponent extends Component {
    private int health;

    public Event<EmptyArg> onDeath = new Event<>();
    public Event<Integer> onHpChange = new Event<>();

    public HealthComponent(Entity entity) {
        super(entity);
    }

    public void checkDeath() {
        if (health <= 0) {
            onDeath.invoke(new EmptyArg());
            var world = entity.getWorld();
            world.removeObject(entity);
            onDeath.clear();
        }
    }

    public void decreaseHealth(int dmg) {
        health -= dmg;
        onHpChange.invoke(health);
        checkDeath();
    }

    public void setHealth(int hp) {
        health = hp;
        onHpChange.invoke(health);
        checkDeath();
    }

    public int getHealth() {
        return health;
    }


}
