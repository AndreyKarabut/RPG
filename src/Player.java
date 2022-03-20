public class Player extends Persona {

    public Player(String name){
        super(name, 100, 0, 33, 0, 10, 0);
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
        return "P";
    }

    public void lvlUp(){
        if(this.exp > 100 + lvl * 150){
            this.maxHp += 50;
            this.setHp(maxHp);
            this.dex += 3;
            this.exp -= 100 + lvl * 150;
            this.power += 4;
            this.lvl += 1;
        }
    }

    public boolean changeGold(int gold){
        if(this.gold + gold > 0){
            this.gold += gold;
            return true;
        } else {
            System.out.println("Недостаточно золота!");
            return false;
        }
    }

    public void changeHp(int hp){
        if (this.getHp() + hp > this.maxHp){
            this.setHp(this.maxHp);
        } else {
            this.setHp(this.getHp() + hp);
        }
    }

    public void changeExp(int exp){
        this.exp += exp;
        this.lvlUp();
    }

    public void printInfo(){
        System.out.println(String.format("Имя - %s,\nздоровье - %s\nзолото - %s\nловкость - %s\nсила - %s\nуровень - %s", name, hp, gold,dex,power,lvl));
    }
}
