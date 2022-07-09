package weapons;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MagicWand extends Weapon {

    private int healPower = 3;

    @Builder(builderMethodName = "magicWandBuilder")
    public MagicWand() {
        super(30, 3);
        healPower = getHealPower();
    }
}
