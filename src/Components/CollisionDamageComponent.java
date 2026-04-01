package Components;

import Classes.Banana;
import Classes.Entity;

public class CollisionDamageComponent extends Component {
    public int damage;

    public CollisionDamageComponent(Entity entity) {
        super(entity);
    }

    public void Update() {
        var subjects = entity.getWorld().getObjectsAt(entity.getX(), entity.getY(), Banana.class);
        if (subjects != null) {
            for (var subject : subjects) {
                subject.getComponent(HealthComponent.class).DecreaseHealth(damage);
                entity.getWorld().removeObject(entity);
            }
        }
    }

    public void SetDmg(int dmg) {
        damage = dmg;
    }

    public void Start() {

    }

}

