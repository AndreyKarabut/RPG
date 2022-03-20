public abstract class Persona {
    public String name;
    public int maxHp;
    public int hp;
    public int gold;
    public int dex;
    public int exp;
    public int power;
    public int lvl;

    public Persona(String name, int hp, int gold, int dex, int exp, int power, int lvl) {
        this.name = name;
        this.maxHp = hp;
        this.setHp(hp);
        this.gold = gold;
        this.dex = dex;
        this.exp = exp;
        this.power = power;
        this.lvl = lvl;
    }

    public abstract int attack();

    public abstract String getSymbol();

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
