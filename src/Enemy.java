import java.util.Random;
import java.util.Scanner;

public class Enemy {
    private String enemyName;
    private int enemyAttack;
    private int enemyWeight;
    private int enemyDefend;
    private int enemyHealth;
    private Character player;
    private boolean isDefending;

    public Enemy(String enemyName, int enemyAttack, int enemyDefend, int enemyHealth, int enemyWeight, Character player, boolean isDefending){
        this.enemyName = enemyName;
        this.enemyAttack = enemyAttack;
        this.enemyDefend = enemyDefend;
        this.enemyHealth = enemyHealth;
        this.enemyWeight = enemyWeight;
        this.player = player;
        this.isDefending = false;
    }

    public void enemyInfo(){
        System.out.println("enemy name   : " + enemyName);
        System.out.println("enemy attack : " + enemyAttack);
        System.out.println("enemy defend : " + enemyDefend);
        System.out.println("enemy health : " + enemyHealth);
        System.out.println("enemy weight : " + enemyWeight);
    }

    public int getAttack() {
        return enemyAttack;
    }
    
    public String getEnemyName() {
        return enemyName;
    }

    public void getDamage(int damage) {
        enemyHealth -= damage;
        if (enemyHealth < 0) {
            enemyHealth = 0;
        }
    }

    public void attack(Character player) {
        int damage = 0;
        if (player.isDefend()) {
            damage = Math.max(0, enemyAttack - player.getDefend());
        } else {
            damage = enemyAttack;
        }
        player.reduceHealth(damage);
        System.out.println("\nEnemy : "+ enemyName + " attacks " + player.getName() + " and deals " + damage + " damage.");
    }

    public void defend(){
        isDefending = true;
        System.out.println(enemyName + "is defending");
    }
    public void setPlayer(Character player) {
        this.player = player;
    }
    public void enemyMove() {
        Random enemyTactic = new Random();
        int moveEnemy = enemyTactic.nextInt(2);
    
        switch (moveEnemy) {
            case 0:
                attack(player); // Ubah null menjadi objek player yang valid
                break;
            
            case 1:
                defend();
                break;
            default:
                break;
        }
    }
    

    public boolean isAlive() {
        return enemyHealth > 0;
    }
}
