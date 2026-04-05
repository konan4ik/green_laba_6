package Components;

import Classes.Entity;
import util.FractionType;

public class FractionComponent extends Component {

    private FractionType fractionType;

    public FractionComponent(Entity entity) {
        super(entity);
    }

    public void setFraction(FractionType fractionType) {
        this.fractionType = fractionType;
    }

    public FractionType getFraction() {
        return fractionType;
    }


}
