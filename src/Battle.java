import java.util.Scanner;

public class Battle {
    private Character player;
    private Enemy enemy;

    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void attack(){
        int damage = player.getAttack() + 40 - player.getWeight();
        if (damage < 0) {
            damage = 0;
        }
        enemy.getDamage(damage);
        System.out.println(player.getName() + " attack the " + enemy.getEnemyName() + " goblin and deal " + damage + " damage");
    }
    public void defend() {
        String armorType = player.getArmorType();
        int damageReduction = 0;
        
        if (armorType != null) {
            if (armorType.equals("light armor")) {
                damageReduction = 30;
            } else if (armorType.equals("heavy armor")) {
                damageReduction = 50;
            }
        }
    
        int damage = enemy.getAttack() - damageReduction;
        if (damage < 0) {
            damage = 0;
        }
        player.reduceHealth(damage);
        System.out.println(enemy.getEnemyName() + " attacking " + player.getName() + " while defending");
    }
    
    public void potion(){
        player.heal(30);
        System.out.println(player.getName() + "drink potion and regenerate health by 30");
    }
    public void start() {
        boolean battleEnd = false;
        Scanner whatChoice = new Scanner(System.in);
    
        System.out.println("\nLet the battle begin!");
    
        do {
            boolean validChoice = false;
    
            System.out.println("First movement, what will you do?");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Drink Potion");
            System.out.println("4. Show " + player.getName() + " Stats");
            System.out.print("Input number: ");
            int movement = whatChoice.nextInt();
    
            switch (movement) {
                case 1:
                    System.out.println("\n "+player.getName()+" You choose to 'attack'");
                    attack();
                    validChoice = true;
                    break;
    
                case 2:
                    System.out.println("\n "+player.getName()+" choose to 'defend'");
                    defend();
                    validChoice = true;
                    break;
    
                case 3:
                    System.out.println("\n "+player.getName()+" choose to drink 'potion'");
                    potion();
                    validChoice = true;
                    break;
    
                case 4:
                    System.out.println("\nShowing stat:");
                    player.printCharacterInfo();
                    validChoice = true;
                    break;
    
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
    
            if (validChoice) {
                enemy.enemyMove();
    
                // Periksa kondisi akhir pertempuran setelah setiap putaran
                if (!player.isAlive() || !enemy.isAlive()) {
                    battleEnd = true;
                }
            }
        } while (!battleEnd);
    
        // Setelah loop selesai, lakukan tindakan yang sesuai jika pertempuran berakhir
        if (!player.isAlive()) {
            System.out.println("You have been defeated. Game over!");
        } else if (!enemy.isAlive()) {
            System.out.println("Congratulations! You have defeated the enemy.");
        } else {
            System.out.println("The battle ended unexpectedly."); // Pesan ini harusnya tidak muncul, kecuali ada bug
        }
    }    
}
