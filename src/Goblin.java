public class Goblin extends Monster{

    public Goblin(int lvl) {
        super("goblin", 20+lvl*20, (int) (Math.random()*15), 25 + 3 * lvl, 0, 10+2 * lvl, lvl);
    }
}
