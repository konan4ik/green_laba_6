package Components;

import Classes.Bullet;
import Classes.Entity;
import greenfoot.Greenfoot;
import util.Event;
import util.ReloadTimer;
import util.Vector2;

public class PlayerFiringComponent extends Component {

    public ReloadTimer timer;
    public Event<Integer> onReload = new Event<>();

    public PlayerFiringComponent(Entity entity) {
        super(entity);
    }

    public void setTimer(int delay) {
        timer = new ReloadTimer(delay);
    }

    public int getCounter(){
        return timer.getCounter();
    }

    public void createBullet(){
        var bullet = new Bullet();
        entity.getWorld().addObject(bullet, entity.getX(), entity.getY());
        var entityFraction = entity.getComponent(FractionComponent.class).getFraction();
        bullet.getComponent(FractionComponent.class).setFraction(entityFraction);
        var mouseVector = new Vector2(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        bullet.getComponent(MovementComponent.class).setDirection(mouseVector, new Vector2(entity.getX(), entity.getY()));
    }

    @Override
    public void update(){
        timer.update();
        onReload.invoke(getCounter());
        var mouse = Greenfoot.getMouseInfo();
        if (Greenfoot.mousePressed(null) && mouse.getButton() == 1 && timer.tryUse()){
            createBullet();
        }
    }
}
