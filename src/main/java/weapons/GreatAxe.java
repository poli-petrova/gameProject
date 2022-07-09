package weapons;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GreatAxe extends Weapon {
    private int defense = -2;
    private int vampirism = 10;

    @Builder(builderMethodName = "axeBuilder")
    public GreatAxe() {
        super(-15, 5);
        this.defense = getDefense();
        this.vampirism = getVampirism();
    }
}
