package Components;

import Classes.Entity;
import util.Vector2;

public class MovementComponent extends Component {
    public int speed = 4;

    public Vector2 direction = new Vector2(1, 1);

    public MovementComponent(Entity entity) {
        super(entity);
    }

    public void SetSpeed (int value) {
        speed = value;
    }

    public void SetDirection(Vector2 v2) {
        direction = v2;
    }

    public void SetDirection(Entity entity, Entity target) {
        var x = entity.getX();
        var y = entity.getY();
        var targetLocation = new Vector2(target.getX(),target.getY());
        var objectLocation = new Vector2(x, y);
        var newDirection = targetLocation.sub(objectLocation).normalize();
        SetDirection(newDirection);
    }

    public void Update() {
        double x = entity.getX();
        double y = entity.getY();
        entity.setLocation(x+direction.getX()*speed, y+ direction.getY()*speed);
    }
}
