package Components;

import Classes.Entity;

public class HealthComponent extends Component {
    public int health;

    public HealthComponent(Entity entity) {
        super(entity);
    }

    public void DecreaseHealth() {
        health -= 1;
    }

    public void DecreaseHealth(int dmg) {
        health -= dmg;
    }

    public void Update() {
        if (health < 0) {
            var world = entity.getWorld();
            world.removeObject(entity);
        }
    }

    public void SetHealth(int hp) {
        health = hp;
    }

    public int GetHealth() {
        return health;
    }

    public void Start() {

    }

}
