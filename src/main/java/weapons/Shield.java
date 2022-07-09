package weapons;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Shield extends Weapon {

    private int defense = 2;

    @Builder(builderMethodName = "shieldBuilder")
    public Shield() {
        super(20, -1);
        this.defense = getDefense();
    }
}
