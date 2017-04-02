/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khp.pba.dbassignment3;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Kasper
 */
public class getRunTime {

    public static void main(String[] args) {
        neo4j n4j = new neo4j();
        mysql ms = new mysql();
        long millis;
        long result;
        Random ran = new Random();
        int id;
        long results1[] = new long[20];
        long results2[] = new long[20];
        long results3[] = new long[20];
        long results4[] = new long[20];
        long results5[] = new long[20];

        System.out.println("NEO4J");
        for (int i = 0; i < 20; i++) {
            id = ran.nextInt(500000);
            millis = System.currentTimeMillis();
            n4j.firstDepth(id);
            result = System.currentTimeMillis() - millis;
            results1[i] = result;
            System.out.println("Time to run first depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            n4j.secondDepth(id);
            result = System.currentTimeMillis() - millis;
            results2[i] = result;
            System.out.println("Time to run second depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            n4j.thirdDepth(id);
            result = System.currentTimeMillis() - millis;
            results3[i] = result;
            System.out.println("Time to run third depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            n4j.fourthDepth(id);
            result = System.currentTimeMillis() - millis;
            results4[i] = result;
            System.out.println("Time to run fourth depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            n4j.fifthDepth(id);
            result = System.currentTimeMillis() - millis;
            results5[i] = result;
            System.out.println("Time to run fifth depth endorsements with id " + id + ": " + result);
        }
        System.out.println("Average for depth 1: " + getAverage(results1));
        Arrays.sort(results1);
        System.out.println("Median for depth 1: " + ((results1[9] + results1[10]) / 2));
        System.out.println("Average for depth 2: " + getAverage(results2));
        Arrays.sort(results2);
        System.out.println("Median for depth 2: " + ((results2[9] + results2[10]) / 2));
        System.out.println("Average for depth 3: " + getAverage(results3));
        Arrays.sort(results3);
        System.out.println("Median for depth 3: " + ((results3[9] + results3[10]) / 2));
        System.out.println("Average for depth 4: " + getAverage(results4));
        Arrays.sort(results4);
        System.out.println("Median for depth 4: " + ((results4[9] + results4[10]) / 2));
        System.out.println("Average for depth 5: " + getAverage(results5));
        Arrays.sort(results5);
        System.out.println("Median for depth 5: " + ((results5[9] + results5[10]) / 2));
        
        System.out.println("MYSQL:");
        for (int i = 0; i < 20; i++) {
            id = ran.nextInt(500000);
            millis = System.currentTimeMillis();
            ms.firstDepth(id);
            result = System.currentTimeMillis() - millis;
            results1[i] = result;
            System.out.println("Time to run first depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            ms.secondDepth(id);
            result = System.currentTimeMillis() - millis;
            results2[i] = result;
            System.out.println("Time to run second depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            ms.thirdDepth(id);
            result = System.currentTimeMillis() - millis;
            results3[i] = result;
            System.out.println("Time to run third depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            ms.fourthDepth(id);
            result = System.currentTimeMillis() - millis;
            results4[i] = result;
            System.out.println("Time to run fourth depth endorsements with id " + id + ": " + result);
            millis = System.currentTimeMillis();
            ms.fifthDepth(id);
            result = System.currentTimeMillis() - millis;
            results5[i] = result;
            System.out.println("Time to run fifth depth endorsements with id " + id + ": " + result);
        }
        System.out.println("Average for depth 1: " + getAverage(results1));
        Arrays.sort(results1);
        System.out.println("Median for depth 1: " + ((results1[9] + results1[10]) / 2));
        System.out.println("Average for depth 2: " + getAverage(results2));
        Arrays.sort(results2);
        System.out.println("Median for depth 2: " + ((results2[9] + results2[10]) / 2));
        System.out.println("Average for depth 3: " + getAverage(results3));
        Arrays.sort(results3);
        System.out.println("Median for depth 3: " + ((results3[9] + results3[10]) / 2));
        System.out.println("Average for depth 4: " + getAverage(results4));
        Arrays.sort(results4);
        System.out.println("Median for depth 4: " + ((results4[9] + results4[10]) / 2));
        System.out.println("Average for depth 5: " + getAverage(results5));
        Arrays.sort(results5);
        System.out.println("Median for depth 5: " + ((results5[9] + results5[10]) / 2));

    }

    public static long getAverage(long results[]) {
        long temp = 0;
        for (int i = 0; i < results.length; i++) {
            temp += results[i];
        }
        temp = temp / results.length;
        return temp;
    }
}
