import java.util.Scanner;

public class Character {
    private String name;
    private String weaponName;
    private int weight;
    private int attack;
    private int defend;
    private int health;
    private String armorType;
private boolean defending;

    public Character(String name, String weaponName, int weight, int attack, int defend, int health){
        this.name = name;
        this.weaponName = weaponName;
        this.weight = weight;
        this.attack = attack;
        this.defend = defend;
        this.health = health;
    }

    public void printCharacterInfo() {
        System.out.println("Name  : " + name);
        System.out.println("Weapon: " + weaponName);
        System.out.println("weight:  " + weight);
        System.out.println("Attack: " + attack);
        System.out.println("Defend: " + defend);
        System.out.println("Health: " + health);
    }

    public void setCharacterInfoFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
    }

    public void selectWeapon() {
        Scanner inputWeapon = new Scanner(System.in);
        System.out.println("\nSelect your weapon:");
        System.out.println("1. Sword");
        System.out.println("2. Spear");
        System.out.println("3. Axe");
        System.out.print("input number : ");
        int choice = inputWeapon.nextInt();

        switch (choice) {
            case 1:
                this.weaponName = "Sword";
                this.weight += 10;
                this.attack += 20;
                System.out.println("Weapon 'Sword' is selected. Increase attack by 20, and weight by 10");
                break;
            case 2:
                this.weaponName = "Spear";
                this.weight += 5;
                this.attack += 10;
                System.out.println("Weapon 'Spear' is selected. Increase attack by 10, and weight by 5");
                break;
            case 3:
                this.weaponName = "Axe";
                this.attack += 35;
                this.weight += 15;
                System.out.println("Weapon 'Axe' is selected. Increase attack by 30, and weight by 15");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Sword.");
                this.weaponName = "Sword";
                this.weight =+ 10;
                this.attack += 20;
                System.out.println("Weapon 'Sword' is selected. Increase attack by 20, and weight by 10");
                break;
        }
        System.out.println("Weapon selected: " + weaponName);
    }

    public void armorSelection(){
        Scanner inputArmor = new Scanner(System.in);
        System.out.println("\nSelect your armor:");
        System.out.println("1. Light Armor");
        System.out.println("2. Heavy Armor");
        System.out.print("Enter your choice: ");
        int pickArmor = inputArmor.nextInt();
    
        switch (pickArmor) {
            case 1:
                this.defend += 15;
                this.weight += 10; 
                System.out.println("Light Armor selected. Defense increased by 15, and weight by 10.");
                break;
            
            case 2:
                this.defend += 30;
                this.weight += 20;
                System.out.println("Heavy Armor selected. Defense increased by 30, and weight by 20.");
                break;
            
            default:
                System.out.println("Invalid choice, defaulting to Light ArmorDefense, increased by 30, and weight by 20 .");
                this.defend += 15; 
                this.weight += 10; 
                break;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void heal(int plusHealth) {
       health += plusHealth;
    }

    public int getWeight() {
        return weight;
    }

    public String getName(){
        return name;
    }

    public String getArmorType(){
        return armorType;
    }

    public void reduceHealth(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void defend(){
        this.defending = true;
    }

    public void endDefend() {
        this.defending = false;
    }

    public boolean isDefend() {
        return defending;
    }
    
    public int getDefend(){
        if (defending) {
            return defend; 
        }else {
            return defend;
        }
    }

    public boolean isAlive() {
        return health > 0; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getHealth() {
        return health;
    }
    
}
