package Components;

import Classes.Entity;

public class AiComponent extends Component {
    private Entity target;
    private MovementComponent movementComponent;

    public AiComponent(Entity entity) {
        super(entity);
    }

    public void SetTarget(Entity target){
        this.target = target;
    }

    public void Update() {
        movementComponent.SetDirection(entity, target);
    }

    public void Start(){
        movementComponent = entity.getComponent(MovementComponent.class);
    }
}
