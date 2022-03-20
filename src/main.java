import java.util.Scanner;

public class main {
    static boolean end = false;
    public static void main(String[] args) {
        while (!end) {
            int answer = printMenu();
            switch (answer) {
                case 1:
                    startGame();
                case 2:
                    end = true;
            }
        }
        System.out.println("Пока!");
    }

    private static void startGame() {
        World world = new World();
        end = world.isEndGame();
    }

    private static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                1. Новая игра
                2. Выход.
                """);
        return sc.nextInt();
    }
}
