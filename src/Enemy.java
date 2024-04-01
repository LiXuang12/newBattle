import java.util.Random;
import java.util.Scanner;

public class Enemy {
    private String enemyName;
    private int enemyAttack;
    private int enemyWeight;
    private int enemyDefend;
    private int enemyHealth;
    private Character player;

    public Enemy(String enemyName, int enemyAttack, int enemyDefend, int enemyHealth, int enemyWeight, Character player2){
        this.enemyName = enemyName;
        this.enemyAttack = enemyAttack;
        this.enemyDefend = enemyDefend;
        this.enemyHealth = enemyHealth;
        this.enemyWeight = enemyWeight;
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

    public void getDamage(int damage) {
        enemyHealth -= damage;
        if (enemyHealth < 0) {
            enemyHealth = 0;
        }
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void attack(Character player) {
        int damage = 0;
        if (player.isDefend()) {
            damage = Math.max(0, enemyAttack - player.getDefend());
        } else {
            damage = enemyAttack;
        }
        player.reduceHealth(damage);
        System.out.println(enemyName + " attacks " + player.getName() + " and deals " + damage + " damage.");
    }

    public void defend(){

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
