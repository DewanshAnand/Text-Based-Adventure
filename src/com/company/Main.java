package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //System Objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game Variables
        String[] enemies = {"Skeleton","Zombie","Warrior","Assassin"};
        int maxEnemyHealth= 100;
        int enemyAttackDamage= 75;

        //Player Variables
        int health= 100;
        int attackDamage= 50;
        int numHealthPotions= 3;
        int healthPotionHealAmount= 30;
        int healthPotionDropChance= 50; //Percentage

        boolean running = true;

        System.out.println("Welcome to the Dungeon!");

        GAME:
        while(running){
            System.out.println("----------------------------------");

            int enemyHealth= rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy +" has appeared! #\n");

            while(enemyHealth>0){
                System.out.println("\tYour HP: "+ health);
                System.out.println("\t"+ enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Drink Health Potion");
                System.out.println("\t3. Run!");

                String input = in.nextLine();
                if (input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth = enemyHealth-damageDealt;
                    health = health-damageTaken;

                    System.out.println("\tYou strike the "+ enemy+ " for "+ damageDealt + " damage. " );
                    System.out.println("\tYou receive " + damageTaken + " in retailiation.");

                    if(health<1){
                        System.out.println("\tYou have taken too much damage, you are  too weak to go on!");
                        break;
                    }

                }
                else if(input.equals("2")){
                    if(numHealthPotions>0){
                        health= health+healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\tYou drank a health potion, healing yourself for "+ healthPotionHealAmount +"."
                        +"\n\tYou now have " + health + " HP." + "\t\nYou have "+ numHealthPotions + " health potions left.\n" );
                    }
                    else{
                        System.out.println("You have no health potions left, Defeat enemies to get one!");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("You ran away from the "+ enemy+ "!");
                    continue GAME;
                }
                else{
                    System.out.println("\tInvalid command!");
                }
            }
            if (health<1){
                System.out.println("\tYou limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("--------------------------------------------------------");
            System.out.println(" # "+ enemy+ " was defeated! #");
            System.out.println("You have "+ health + " HP left #");
            if(rand.nextInt(100)<healthPotionDropChance){
                numHealthPotions++;
                System.out.println("The" + enemy + " dropped a health potion! ");
                System.out.println("You now have "+ numHealthPotions + " health potion. ");
            }
            System.out.println("-----------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting ");
            System.out.println("2. Exit dungeon");

            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid Command!");
                input = in.nextLine();
            }
            if (input.equals("1")){
                System.out.println("Continue on your Adventure");
            }
            else if(input.equals("2")){
                System.out.println("You exit from dungeon");
                break;
            }
        }
        System.out.println("Thanks for playing");
    }
}
