package com.uis.csc482.module5;

import java.io.IOException;

public class PrimAlgorithmTest {
    public static void main (String args []) throws IOException {

        System.out.println("-------------- Testing Prim_000 start -------------------");
        PrimAlgorithm primAlgorithm = new PrimAlgorithm();

        String inputFileName = "/src/main/java/com/uis/csc482/module5/Prim_000.gl";

        String outputFileName = "/src/main/java/com/uis/csc482/module5/Prim_000_output.gl";

        primAlgorithm.processPrimAlgorithm(inputFileName, outputFileName) ;

        System.out.println("-------------- Testing Prim_000 end -------------------");


        System.out.println("-------------- Testing Prim_001 start -------------------");
        PrimAlgorithm primAlgorithm1 = new PrimAlgorithm();

        String inputFileName1 = "/src/main/java/com/uis/csc482/module5/Prim_000.gl";

        String outputFileName1 = "/src/main/java/com/uis/csc482/module5/Prim_000_output.gl";

        primAlgorithm1.processPrimAlgorithm(inputFileName1, outputFileName1) ;

        System.out.println("-------------- Testing Prim_001 end -------------------");


        System.out.println("-------------- Testing Prim_002 start -------------------");
        PrimAlgorithm primAlgorithm2 = new PrimAlgorithm();

        String inputFileName2 = "/src/main/java/com/uis/csc482/module5/Prim_000.gl";

        String outputFileName2 = "/src/main/java/com/uis/csc482/module5/Prim_000_output.gl";

        primAlgorithm2.processPrimAlgorithm(inputFileName2, outputFileName2) ;

        System.out.println("-------------- Testing Prim_002 end -------------------");

    }
}
