public class Skeleton extends Monster{

    public Skeleton(int lvl) {
        super("skeleton", 30+lvl*15, (int) (Math.random()*15), 15 + 2*lvl, 0, 15+5*lvl, lvl);
    }
}
