package Components;

import Classes.Entity;
import util.Vector2;

public class MovementComponent extends Component {
    public int speed = 4;

    public Vector2 direction = new Vector2(0, 0);

    public MovementComponent(Entity entity) {
        super(entity);
    }

    public void setSpeed(int value) {
        speed = value;
    }

    public void setDirection(Vector2 v2) {
        direction = v2;
    }

    public void setDirection(Vector2 v2, Vector2 v22) {
        var newDirection = v2.sub(v22).normalize();
        setDirection(newDirection);
    }
    public void setDirection(Entity entity, Entity target) {
        var x = entity.getX();
        var y = entity.getY();
        var targetLocation = new Vector2(target.getX(),target.getY());
        var objectLocation = new Vector2(x, y);
        var newDirection = targetLocation.sub(objectLocation).normalize();
        setDirection(newDirection);
    }

    public void update() {
        double x = entity.getX();
        double y = entity.getY();
        entity.setLocation(x+direction.getX()*speed, y+ direction.getY()*speed);
        if (entity.isAtEdge()) {
            entity.getWorld().removeObject(entity);
        }
    }
}
