package Components;

import Classes.Entity;
import greenfoot.Greenfoot;
import util.Vector2;

public class ControlsComponent extends Component {

    public MovementComponent movementComponent;

    public ControlsComponent(Entity entity) {
        super(entity);
    }

    @Override
    public void update()
    {
        var direction = new Vector2(0,0 );

        if (Greenfoot.isKeyDown("D")) {
            direction = direction.add(new Vector2(1, 0));
        }

        if (Greenfoot.isKeyDown("A")) {
            direction = direction.add(new Vector2(-1, 0));
        }

        if (Greenfoot.isKeyDown("W")) {
            direction = direction.add(new Vector2(0, -1));
        }

        if (Greenfoot.isKeyDown("S")) {
            direction = direction.add(new Vector2(0, 1));
        }

        movementComponent.setDirection(direction);
    }

    public void start() {
        movementComponent = entity.getComponent(MovementComponent.class);
    }
}
