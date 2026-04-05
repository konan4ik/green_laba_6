package Components;

import Classes.Entity;

public class TargetComponent extends Component {

    public Entity target;

    public TargetComponent(Entity entity) {
        super(entity);
    }

    public void setTarget(Entity target){
        this.target = target;
    }

    public Entity getTarget() {
        return target;
    }

}
