public class App {
    public static void main(String[] args) {
        // Inisialisasi karakter
        Character player = new Character("", "", 40, 100, 100, 150);

        System.out.println("\nCharacter information:");
        player.setCharacterInfoFromInput();
        
        // Set nama dan nama senjata setelah mendapatkan input dari pengguna
        player.setName(player.getName());
        player.setWeaponName(player.getName());

        // Choose Armor
        player.armorSelection();

        // Choose Weapon
        player.selectWeapon();

        // Initial Stat
        System.out.println("\nInitial Stats:");
        System.out.println("Weight: 40");
        System.out.println("Attack: 100");
        System.out.println("Defend: 100");
        System.out.println("Health: 150");

        // New Stat
        System.out.println("\nYour Stats:");
        player.printCharacterInfo();

        // Enemy Stat
        System.out.println("\nEnemy Stats:");
        Enemy enemy = new Enemy("Goblin", 90, 100, 100, 150, player);
        enemy.enemyInfo();

        // Memulai pertarungan
        System.out.println("\nYou will fight the enemy until one of you is defeated");
        Battle battle = new Battle(player, enemy);
        battle.start();
    }
}
