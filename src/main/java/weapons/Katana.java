package weapons;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Katana extends Weapon {

    private int defense = 5;
    private int vampirism = 50;

    @Builder(builderMethodName = "katanaBuilder")
    public Katana() {
        super(-20,6);
        this.defense = getDefense();
        this.vampirism = getVampirism();
    }

}
