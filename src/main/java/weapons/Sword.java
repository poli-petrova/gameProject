package weapons;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Sword extends Weapon {

    @Builder(builderMethodName = "swordBuilder")
    public Sword() {
        super(5, 2);
    }
}
