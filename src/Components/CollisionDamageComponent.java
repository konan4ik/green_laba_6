package Components;

import Classes.Entity;

public class CollisionDamageComponent extends Component {
    public int damage = 1;

    public CollisionDamageComponent(Entity entity) {
        super(entity);
    }

    @Override
    public void update() {
        var subjects = entity.getWorld().getObjectsAt(entity.getX(), entity.getY(), Entity.class);
        if (subjects != null) {
            for (var subject : subjects) {
                if (subject.getComponent(FractionComponent.class) != null && subject.getComponent(HealthComponent.class) != null) {
                    if (subject.getComponent(FractionComponent.class).getFraction() != entity.getComponent(FractionComponent.class).getFraction()) {
                        subject.getComponent(HealthComponent.class).decreaseHealth(damage);
                        entity.getWorld().removeObject(entity);
                    }
                }
            }
        }
    }

    public void SetDmg(int dmg) {
        damage = dmg;
    }

}

