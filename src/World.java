import java.util.Scanner;

public class World extends Thread {
    static Scanner sc = new Scanner(System.in);
    Player player;
    static boolean endGame = false;
    static boolean inForest = false;

    public boolean isEndGame() {
        return endGame;
    }


    public World() {

        System.out.println("Введите имя: ...");
        String name = sc.nextLine();
        player = new Player(name);
        while (!endGame) {
            int answer = printWorld();
            switch (answer) {
                case 1:
                    goToTrader();
                    break;
                case 2:
                    goToForest();
                    break;
                case 0:
                    endGame = true;
                    break;
                default:
                    System.out.println("Неправильный ответ");
            }
        }
    }

    private void goToForest() {
        boolean inForest = true;
        System.out.println("На первый взгляд, лес как лес");
        while (inForest) {
            int answer = printForest();
            switch (answer) {
                case 1:
                    double r = Math.random();
                    int lvl = 0;
                    if (r <= 0.45) {
                        if (r < 0.15) {
                            lvl = player.lvl - 1;
                            if (lvl < 0) {
                                lvl = 0;
                            }
                        } else if (r < 0.4) {
                            lvl = player.lvl;
                        } else {
                            lvl = player.lvl + 1;
                        }
                        Skeleton skeleton = new Skeleton(lvl);
                        System.out.println("Вы встретили скелет " + lvl + " уровня.");
                        Battle battle = new Battle(player, skeleton);
                        player.setHp(battle.attack());
                    } else if (r <= 0.9) {
                        if (r < 0.6) {
                            lvl = player.lvl - 1;
                            if (lvl < 0) {
                                lvl = 0;
                            }
                        } else if (r < 0.85) {
                            lvl = player.lvl;
                        } else {
                            lvl = player.lvl + 1;
                        }
                        Goblin goblin = new Goblin(lvl);
                        System.out.println("Вы встретили гоблина " + lvl + " уровня.");
                        Battle battle = new Battle(player, goblin);
                        player.setHp(battle.attack());
                    } else {
                        r = Math.random();
                        if (r < 0.8) {
                            int gold = (int) (r * 15);
                            System.out.println("Вы нашли " + gold + "золота!");
                            player.changeGold(gold);
                        } else {
                            System.out.println("Вы нашли зелье лечения! Здоровье восстановлено на 50 единиц");
                            player.changeHp(50);
                        }
                    }
                    if (player.getHp() > 0) {
                        player.changeExp(30 + lvl * 27 + 3);
                    }else{
                        System.out.println("Вы погибли в лесу!");
                        inForest = false;
                    }
                    break;
                case 2:
                    inForest = false;
                    break;
                case 0:
                    player.printInfo();
                    break;
                default:
                    System.out.println("Неправильный ответ");
            }
        }
    }

    public int printForest() {
        System.out.println("""
                1. Остаться в лесу.
                2. Выйти в мир.
                                
                0. Посмотреть инфо.
                                   """);
        return sc.nextInt();
    }

    private void goToTrader() {
        System.out.println("Позже...");
    }

    public int printWorld() {
        System.out.println("""
                1. Пойти к торговцу.
                2. В темный лес.
                                
                0. Выход.
                """);
        return sc.nextInt();
    }
}
