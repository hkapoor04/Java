package com.uis.assignments.cs501.week3;


import java.util.Scanner;

public class Exercise03_13 {

    /*
     * Main Method
     */

    public static void main(String args[]) {

        //-- Reading Filing Status from the keyboard
        Scanner readFilingStatus = new Scanner(System.in);

        //-- Display input field for filing status
        System.out.println("Enter the filing status (0 for single filers, 1 for married filing jointly, 2 for married filing separately, and 3 for head of household): ");

        //-- Declaring and assigning input filing status
        int filingStatus = readFilingStatus.nextInt();

        //-- Reading taxable income from the keyboard
        Scanner readTaxableIncome = new Scanner(System.in);

        //-- Display input field for taxable income
        System.out.println("Enter the taxable income: ");

        //-- Declaring and assigning input taxable income
        double taxableIncome = readTaxableIncome.nextDouble();

        //-- Checking taxable income to be non negative
        if (taxableIncome < 0) {
            System.err.println("Taxable Income is negative");
            System.exit(-1);
        }

        //-- Declaring variable for storing tax and initializing it to 0
        double tax = 0.0;

        switch (filingStatus) {

            case 0: { //-- Calculating tax for single filers

                tax += (taxableIncome <= 8350) ? taxableIncome * 0.10 : 8350 * 0.10;

                if (taxableIncome > 8350)

                    tax += (taxableIncome <= 33950) ? (taxableIncome - 8350) * 0.15 : 25600 * 0.15;

                if (taxableIncome > 33950)

                    tax += (taxableIncome <= 82250) ? (taxableIncome - 33950) * 0.25 : 48300 * 0.25;

                if (taxableIncome > 82250)

                    tax += (taxableIncome <= 171550) ? (taxableIncome - 82250) * 0.28 : 89300 * 0.28;

                if (taxableIncome > 171550)

                    tax += (taxableIncome <= 372950) ? (taxableIncome - 171550) * 0.33 : 201400 * 0.33;

                if (taxableIncome > 372950)

                    tax += (taxableIncome - 372950) * 0.35;

                break;
            }
            case 1: { //-- Calculating tax for Married Filing Jointly or Qualified Widow(er)

                tax += (taxableIncome <= 16700) ? taxableIncome * 0.10 : 16700 * 0.10;

                if (taxableIncome > 16700)

                    tax += (taxableIncome <= 67900) ? (taxableIncome - 16700) * 0.15 : (67900 - 16700) * 0.15;

                if (taxableIncome > 67900)

                    tax += (taxableIncome <= 137050) ? (taxableIncome - 67900) * 0.25 : (137050 - 67900) * 0.25;

                if (taxableIncome > 137050)

                    tax += (taxableIncome <= 208850) ? (taxableIncome - 137050) * 0.28 : (208850 - 137050) * 0.28;

                if (taxableIncome > 208850)

                    tax += (taxableIncome <= 372950) ? (taxableIncome - 208850) * 0.33 : (372950 - 208850) * 0.33;

                if (taxableIncome > 372950)

                    tax += (taxableIncome - 372950) * 0.35;
                break;
            }
            case 2: { //-- Calculating tax for Married Filing Separately

                tax += (taxableIncome <= 8350) ? taxableIncome * 0.10 : 8350 * 0.10;

                if (taxableIncome > 8350)

                    tax += (taxableIncome <= 33950) ? (taxableIncome - 8350) * 0.15 : (33950 - 8350) * 0.15;

                if (taxableIncome > 33950)

                    tax += (taxableIncome <= 68525) ? (taxableIncome - 33950) * 0.25 : (68525 - 33950) * 0.25;

                if (taxableIncome > 68525)

                    tax += (taxableIncome <= 104425) ? (taxableIncome - 68525) * 0.28 : (104425 - 68525) * 0.28;

                if (taxableIncome > 104425)

                    tax += (taxableIncome <= 186475) ? (taxableIncome - 104425) * 0.33 : (186475 - 104425) * 0.33;

                if (taxableIncome > 186475)

                    tax += (taxableIncome - 186475) * 0.35;
                break;
            }
            case 3: { //-- Calculating tax for Head of Household
                tax += (taxableIncome <= 11950) ? taxableIncome * 0.10 : 11950 * 0.10;

                if (taxableIncome > 11950)

                    tax += (taxableIncome <= 45500) ? (taxableIncome - 11950) * 0.15 : (45500 - 11950) * 0.15;

                if (taxableIncome > 45500)

                    tax += (taxableIncome <= 117450) ? (taxableIncome - 45500) * 0.25 : (117450 - 45500) * 0.25;

                if (taxableIncome > 117450)

                    tax += (taxableIncome <= 190200) ? (taxableIncome - 117450) * 0.28 : (190200 - 117450) * 0.28;

                if (taxableIncome > 190200)

                    tax += (taxableIncome <= 372950) ? (taxableIncome - 190200) * 0.33 : (372950 - 190200) * 0.33;

                if (taxableIncome > 372950)

                    tax += (taxableIncome - 372950) * 0.35;
                break;
            }
            default: {
                System.out.println("Invalid Filing Status");
                System.exit(-1);
            }
        }
        System.out.println("Tax is " + tax);
    }
}


