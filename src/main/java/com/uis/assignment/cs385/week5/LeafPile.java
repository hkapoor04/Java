package com.uis.assignment.cs385.week5;

import java.util.Stack;

public class LeafPile {
    public static void main(String[] args) {
        Ground map[][] = new Ground[7][11];
        generateRandomGround(map);
        printMap(map);
        System.out.println(largestLeafPile(map));
    }

    /**********Student code here***************************/
    private static int largestLeafPile(Ground map[][]) {

        //-- variable to store the number of rows
        int rowCount = map.length;

        //-- variable to store the number of columns
        int colCount = map[0].length;

        //-- variable to store the size of one leaf
        int leafSize = 0;

        //-- variable to store maximum leaf size and initializing it to minimum value
        int maxLeafSize = Integer.MIN_VALUE;

        //-- variable to store if the position is already visited
        boolean[][] visited = new boolean[rowCount][colCount];

        //-- Marking all positions as not visited initially
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                visited[i][j] = false;
            }
        }

        //-- declaring stack to store the position object
        Stack<Position> stack = new Stack<>();

        //-- iterating through the map
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {

                //-- Checking if the current position is a leaf and is not visited
                if (map[row][col] == Ground.LEAF && !visited[row][col]) {

                    //-- pushing the position object into the stack in case it's a leaf and is not visited
                    stack.push(new Position(row, col));
                    leafSize = getLeafSize(stack, map, visited);

                    //-- finding the maximum size of the leaf pile
                    if (leafSize > maxLeafSize) {
                        maxLeafSize = leafSize;
                    }
                }
            }
        }
        return maxLeafSize;

    }

    /*
     * This method finds the size of leaf pile
     *
     * @param stack - The stack of position object
     * @param Ground - The array
     * @param processed - boolean variable having the state of position (visited/not visited)
     *
     */
    private static int getLeafSize(Stack<Position> stack, Ground[][] map, boolean[][] visited) {

        //-- variable to store the row size
        int rowLength = map.length;

        //-- variable to store the column size
        int columnLength = map[0].length;

        //-- variable to store the leaf size
        int sizeOfLeaf = 0;

        //-- iterating through the stack until its not empty
        while (!stack.isEmpty()) {

            //-- popping the top object from stack
            Position position = stack.pop();

            //-- variable to store the row location of leaf
            int row = position.row;

            //-- variable to store the column location of leaf
            int col = position.column;

            //-- check for invalid entries in the popped object from stack
            if (row < 0 || col < 0 || row >= rowLength || col >= columnLength || map[row][col] == Ground.GRASS || visited[row][col])
                continue;

            //-- updating the visited location to true
            visited[row][col] = true;

            //-- calculating the size of stack to determine the leaf pile
            sizeOfLeaf++;

            //-- pushing the Position objects present in left, right, top and bottom into the stack
            stack.push(new Position(row, col - 1)); //-- go towards left from current position
            stack.push(new Position(row, col + 1)); //-- go towards right from current position
            stack.push(new Position(row - 1, col)); //-- go upwards from current position
            stack.push(new Position(row + 1, col)); //-- go downwards from current position

        }

        return sizeOfLeaf;
    }

    /***************End Student Code************************/
    private static void printMap(Ground map[][]) {
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                System.out.print(map[r][c]);
                if (c < map[r].length - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    private static void generateRandomGround(Ground map[][]) {
        double randGround;
        double randMax = 100;
        double percentGrass = .70;
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                randGround = (Math.random() * randMax) + 1;
                map[r][c] = randGround <= randMax * percentGrass ? Ground.GRASS : Ground.LEAF;
            }
        }
    }
}
