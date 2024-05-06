import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Do not change
        
        task1();
        task2();
        task3();
    }
    
    public static void task1(){
        System.out.println("===========================================");
        System.out.println("<b> Alpro Medical Diagnostic Centre</b>");
        System.out.println("-------------------------------------------");
        
        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name : ");
        String name = sc.nextLine();

        System.out.print("Please input your sex ( m / f ) : ");
        String sex = sc.nextLine();
        
        System.out.print("Please input your height ( cm ) : ");
        int height = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Please input your weight ( kg ) : ");
        int weight = sc.nextInt();
        sc.nextLine();
        
        //generating output
        System.out.println("-------------------------------------------");
        
        
        String salutation;
        if(sex.equals("m"))
        {
            salutation = "Mr";
        } else {
            salutation = "Ms";
        }
        
        //computing Body Mass Index (BMI)
        double heightInMeter = height/100.0;
        double bmi = weight/(heightInMeter*heightInMeter);
        String bmiCategory;
        
        // Based on https://www.siloamhospitals.com/en/informasi-siloam/artikel/cara-menghitung-bmi
        if(bmi<18.5)
        {
            bmiCategory = "underweight";
        } else if (bmi>=18.5 && bmi<24.9)
        {
            bmiCategory = "normal";
        } else if (bmi > 25 && bmi <= 29.9)
        {
            bmiCategory = "overweight";
        } else {
            bmiCategory = "obese";
        }
        
        System.out.println("Customer Name\t: "+ salutation + " " + name );
        System.out.println("BMI\t\t: "+ bmi );
        System.out.println("Category\t: <b><font color='b'>"+bmiCategory+"</b></font>");
        System.out.println("===========================================");
         
    }
    
    public static void task2(){
        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your Fullname \t: ");
        String fullName = sc.nextLine();
        System.out.print("Please input your student id \t: ");
        String studentId = sc.nextLine();
        
        //generating output
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("<b>Academic Report</b>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Student ID.: " + studentId + "\t\t\t Fullname:" + fullName);
        System.out.println("===============================================================================");
        System.out.println("<b>No.\tCode\tName\t\t\t\tCredit\tGrade\tScore\tW.Score</b>");
        
        //creating a variable of type Scanner
        Scanner scFile = new Scanner(Main.class.getResourceAsStream("transcript.csv"));
        //declare variable to read file per line
        String line;
        //declare array variable of String
        String[] lineSplit;
        
        //initialize varibles to store credits, total credits, and total to 0
        int credit = 0;
        int totalCredit = 0;
        double totalScore = 0.0;
        
        //declare and initialize the variables
        int no = 1;
        String code;
        String course;
        String grade;
        double score;
        double wscore;
        
        // read the file from beginning to the end
        
        while(scFile.hasNext()){
            //read the current line
            line = scFile.nextLine();
            //split the current line by comma and save to an array variables
            lineSplit = line.split(",");
            
            code = lineSplit[0];
            course = lineSplit[1];
            credit = Integer.parseInt(lineSplit[2]);
            grade = lineSplit[3];
            
            //update the total credit by adding the current line credit
            totalCredit = credit + totalCredit;
            
            score= convertGradeToNumeric(grade);
            wscore= score*credit;
            //update the total score by adding the current line weighted score
            totalScore =  wscore + totalScore;
            
            //print out the current line
            System.out.println(no +"\t"+ code +"\t"+ course +"\t\t"+ credit +"\t"+ grade +"\t"+ score +"\t"+ wscore);
            //update varible no by 1
            no++;
            
        }
        System.out.println("-------------------------------------------------------------------------------");
        
        double cgpa= totalScore/totalCredit;
        String category="";
        if (cgpa >= 2.0)  category="passed";
        else category="failed";
        
        System.out.println("\t\t\t CGPA \t:<b>"+ cgpa +" ("+category+")</b>");
        System.out.println("-------------------------------------------------------------------------------");
        
    }
     public static double convertGradeToNumeric(String grade){
        switch(grade){
            case "A":
                return 4.0;
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "E":
                return 1.0;
        }
        return 0.0;
    }
    
    public static void task3(){
        Scanner scan = new Scanner(Main.class.getResourceAsStream("scores.csv"));
        


        int T = Integer.parseInt(scan.nextLine());

        for(int i = 0; i<T; i++){
            System.out.println("ID Number\t|\tStudent Name\t|\tMathematics\t|\tPhysics\t\t|\tChemistry\t|\tBiology\t\t|");
            System.out.println("===========================================================================================================================================");
            
            double bestScore = 0;
            String bestStudentId = "";
            String bestStudentName = "";
            
            int T2 = Integer.parseInt(scan.nextLine());

            for(int j = 0; j<T2; j++){
                String input = scan.nextLine();
                String[] line = input.split(",");
                
                double[] scores = new double[4];
                for(int k = 0; k<4; k++){
                    if(line[k+2].equals("")){
                        scores[k] = 0;
                    }
                    else scores[k] = Double.parseDouble(line[k+2]);
                }
                
                if(Integer.parseInt(line[0])%2 == 0){
                    double[] arrForMedian = new double[4];
                    for(int k = 0; k<scores.length; k++){
                        arrForMedian[k] = scores[k];
                    }
                    Arrays.sort(arrForMedian);
                    double median = (arrForMedian[1] + arrForMedian[2])/2.0;
                    for(int k = 0; k<4; k++){
                        if(scores[k] == 0){
                            scores[k] = median;
                        }
                    }
                }
    
                else if(Integer.parseInt(line[0])%2 == 1){
                    double sum = 0;
                    
                    for(int k = 0; k<4; k++){
                        sum+=scores[k];
                    }
                    
                    double avg = sum/3;
    
                    for(int k = 0; k<4; k++){
                        if(scores[k] == 0){
                            scores[k] = avg;
                        }
                    }
    
                }    
                
                double sum = 0;
                for(int k = 0; k<4; k++){
                    sum+=scores[k];
                }
                double avg = sum/4;
                if(avg > bestScore){
                    bestStudentId = line[0];
                    bestStudentName = line[1];
                    bestScore = avg;
                }
                System.out.println(line[0]+"\t\t|\t"+line[1]+"\t\t|\t"+String.format("%.1f",scores[0])+"\t\t|\t"+String.format("%.1f",scores[1])+"\t\t|\t"+String.format("%.1f",scores[2])+"\t\t|\t"+String.format("%.1f",scores[3])+"\t\t|");
            }

            System.out.println("======================");
            System.out.println("BEST STUDENT");
            System.out.println("ID Number = " + bestStudentId);
            System.out.println("Name = " + bestStudentName);
            System.out.println("Average Score = " + String.format("%.2f",bestScore));
            System.out.println("======================");
        }
    }
        
}
