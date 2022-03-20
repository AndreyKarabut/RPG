
public class Battle {
    Persona player;
    Persona monster;
    String nowPlayer;

    public Battle(Persona player, Persona monster) {
        this.player = player;
        this.monster = monster;
        nowPlayer = player.getSymbol();
    }

    public int attack() {
        int dmg;
        while (player.getHp() > 0 && monster.getHp() > 0) {
            if (this.nowPlayer.equals(player.getSymbol())) {
                dmg = player.attack();
                monster.setHp(monster.getHp() - dmg);
                System.out.println("Вы нанесли " + dmg + " урона! Здоровье монстра - " + monster.getHp());
            } else {
                dmg = monster.attack();
                player.setHp(player.getHp() - dmg);
                System.out.println("Вам нанесли " + dmg + " урона! Здоровье - " + player.getHp());
            }
            this.nowPlayer = this.nowPlayer.equals(player.getSymbol()) ? monster.getSymbol() : player.getSymbol();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return player.getHp();
    }

}
