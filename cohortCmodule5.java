 import java.util.Scanner;
 import java.lang.*;

public class Main {
    
    
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }
    
    static void task1(){
        
        //read the file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("matrix.txt"));
        //get the number of matrix
        int nm = sc.nextInt();
        
        //loop for each matrix
        for(int t = 0;  t<nm ; t++){
            //read the number of row and colomn;
            int row = sc.nextInt();
            int column = sc.nextInt();
            
            //declare the original matrix
            int [][] matrix = new int[row][column];
            //declare the transpose matrix
            int [][] transposeMatrix = new int[column][row];
            
            //declare varible to hold the number
            int val;
            
            //assign the number into the 2D matrix
            for(int i = 0;i<row;i++){
                for(int j = 0;j < column;j++){
                    val = sc.nextInt();
                    matrix[i][j] = val;
                    transposeMatrix[j][i] = val;
                }
            }
            
            // Print the original matrix
            System.out.println("M:");
            for(int i = 0;i<row;i++){
                for(int j = 0;j < column;j++){
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
            
            // Print the tranpose matrix
            System.out.println("M':");
            for(int i = 0;i<column;i++){
                for(int j = 0;j<row;j++){
                    System.out.print(transposeMatrix[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        
    }
    
    static void task2(){
        //read the input file and the number of test case
        Scanner scan = new Scanner(Main.class.getResourceAsStream("board.txt"));
        int t = scan.nextInt();
        //loop for each test case
        for(int n=0;n<t;n++){
            int xP = 0;
            int yP = 0;
            int xQ = 0;
            int yQ = 0;
            //decalre the needed variable
            int board[][] = new int[8][8];
            //loop to assign the number into 2D array and find the position of queen and Pawn
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    board[i][j] = scan.nextInt();
                    if(board[i][j] == 1){
                        xQ = i;
                        yQ = j;
                    }
                    else if(board[i][j] == 2){
                        xP = i;
                        yP = j;
                    }
             }
           }
           
        
         //decalare any required variables here
         boolean isThreaten = false;
            
         //check whether the pawn is threatened or not and update board
         if (xP == xQ){
             isThreaten = true;
             if(yP < yQ){
                 for(int i = yP+1; i<yQ; i++){
                     board[xP][i] = 3;
                 }
             } else{
                 for(int i = yQ + 1; i<yP; i++){
                     board[xP][i] = 3;
                 }
             }
         } else if(yP == yQ){
             isThreaten = true;
             if(xP > xQ){
                 for(int i = xQ + 1; i<xP; i++){
                     board[i][yP] = 3;
                 }
             }
             else{
                 for(int i = xP + 1; i < xQ; i++){
                     board[i][yP] = 3;
                 }
             }
         }   else if(Math.abs(xP-xQ) == Math.abs(yP - yQ) ){
             isThreaten = true;
             if(xQ < xP && yQ < yP){
                 for(int i = 1; i< xP - xQ; i++){
                     board[xQ + i][xQ + i] = 3;
                 }
             }
             else if(xQ < xP && yQ > yP){
                 for(int i = 1; i< xP - xQ; i++){
                     board[xQ + i][xQ - i] = 3;
                 }
             }
             else if(xQ > xP && yQ > yP){
                 for(int i = 1; i< xQ - xP; i++){
                     board[xQ - i][xQ - i] = 3;
                 }
             }
             else if(xQ > xP && yQ < yP){
                 for(int i = 1; i< xQ - xP; i++){
                     board[xQ + i][xQ - i] = 3;
                 }
             }
         }

         if(isThreaten){
             System.out.println("YES");
             for(int i = 0; i<board.length; i++){
                 for(int j = 0; j<board[i].length; j++){
                     if(board[i][j] == 1){
                         System.out.print("Q\t");
                     }
                     else if(board[i][j] == 2){
                         System.out.print("P\t");
                     }
                     else if(board[i][j] == 3){
                         System.out.print("X\t");
                     }
                     else System.out.print("0\t");
                 }
                 System.out.println();
             }
         } else System.out.println("NO");
         }
         System.out.println();
    }
    
    static void task3(){
        Scanner scan = new Scanner(Main.class.getResourceAsStream("bingo.txt"));
        
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();
            int nums[] = new int[t];
            int bingo[][] = new int[5][5];
    
            for (int j = 0; j < t; j++) {
                nums[j] = scan.nextInt();
            }
    
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    bingo[j][k] = scan.nextInt();
                }
            }
    
            for (int j = 0; j < t; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingo[k][l] == nums[j]) {
                            bingo[k][l] = 0;
                        }
                    }
                }
            }
    
            boolean bingoFound = false;
            for (int j = 0; j < 5; j++) {
                int zeroCount = 0;
                for (int k = 0; k < 5; k++) {
                    if (bingo[j][k] == 0) {
                        zeroCount++;
                    }
                }
                if (zeroCount == 5) {
                    bingoFound = true;
                    break;
                }
            }
    
            for (int k = 0; k < 5; k++) {
                int zeroCount = 0;
                for (int j = 0; j < 5; j++) {
                    if (bingo[j][k] == 0) {
                        zeroCount++;
                    }
                }
                if (zeroCount == 5) {
                    bingoFound = true;
                    break;
                }
            }

            int zeroCount1 = 0;
            int zeroCount2 = 0;
                for (int j = 0; j < 5; j++) {
                    if (bingo[j][j] == 0) {
                        zeroCount1++;
                    }
                    if (bingo[j][4 - j] == 0) {
                        zeroCount2++;
                    }
                }
                if (zeroCount1 == 5 || zeroCount2 == 5) {
                    bingoFound = true;
                }
    
            if(bingoFound){
                System.out.println("WIN");
            }
            else{
                System.out.println("LOSE");
            }
        }
    }
    
    
}
