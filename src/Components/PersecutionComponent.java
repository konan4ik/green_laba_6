package Components;

import Classes.Entity;

public class PersecutionComponent extends Component {
    private MovementComponent movementComponent;
    private TargetComponent targetComponent;

    public PersecutionComponent(Entity entity) {
        super(entity);
    }

    @Override
    public void update() {
        var target = entity.getComponent(TargetComponent.class).getTarget();
        if (target.getWorld() == null) {
            return;
        }
        movementComponent.setDirection(entity, targetComponent.getTarget());
    }

    public void start(){
        movementComponent = entity.getComponent(MovementComponent.class);
        targetComponent = entity.getComponent(TargetComponent.class);
    }
}
