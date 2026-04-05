package Components;

import Classes.Bullet;
import Classes.Entity;
import util.ReloadTimer;

public class AiFiringComponent extends Component {

    public ReloadTimer timer;

    public AiFiringComponent(Entity entity) {
        super(entity);
    }

    public void setTimer(int delay) {
        timer = new ReloadTimer(delay);
    }

    public int getTimer(){
        return timer.getCounter();
    }

    public void createBullet(){
        var bullet = new Bullet();
        entity.getWorld().addObject(bullet, entity.getX(), entity.getY());
        var entityFraction = entity.getComponent(FractionComponent.class).getFraction();
        bullet.getComponent(FractionComponent.class).setFraction(entityFraction);
        var enemy = entity.getComponent(TargetComponent.class).getTarget();
        bullet.getComponent(MovementComponent.class).setDirection(entity, enemy);
    }

    @Override
    public void update(){
        var target = entity.getComponent(TargetComponent.class).getTarget();
        if (target.getWorld() == null) {
            return;
        }
        timer.update();
        if (timer.tryUse()){
            createBullet();
        }
    }
}
