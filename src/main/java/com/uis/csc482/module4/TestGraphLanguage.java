package com.uis.csc482.module4;

import java.io.IOException;

public class TestGraphLanguage {

    public static void main(String[] args) throws IOException{

        GraphLanguage graphLanguage = new GraphLanguage();

        System.out.println("***************** Testing directed weighted graph - start *******************************");

        graphLanguage.processFile("/src/main/java/com/uis/csc482/module4/graph_directed_weighted.gl");

        System.out.println("***************** Testing directed weighted graph - end *********************************");

        System.out.println("-----------------------------------------------------------------------------------------");


        System.out.println("***************** Testing directed un-weighted graph - start ****************************");

        GraphLanguage graphLanguage1 = new GraphLanguage();

        graphLanguage1.processFile("/src/main/java/com/uis/csc482/module4/graph_directed_unweighted.gl");


        System.out.println("***************** Testing directed un-weighted graph - end ******************************");


        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("************************* Testing invalid file - start **********************************");

        GraphLanguage graphLanguage2 = new GraphLanguage();

        graphLanguage2.processFile("/src/main/java/com/uis/csc482/module4/invalid.gl");


        System.out.println("********************** Testing invalid file - end ***************************************");



    }
}
