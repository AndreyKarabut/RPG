public class Monster extends Persona {

    public Monster(String name, int hp, int gold, int dex, int exp, int power, int lvl){
        super(name, hp, gold, dex, exp, power, lvl);
    }

    @Override
    public int attack() {
        if(this.dex > Math.random()*100){
            return this.power;
        }
        return 0;
    }

    @Override
    public String getSymbol(){
        return "M";
    }
}