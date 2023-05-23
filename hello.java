import java.util.Scanner;
public class hello {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String[] arr = new String[4];
        // arr[0] = "Car";
        // arr[1] = "Car1";
        // arr[2] = "Car2";
        // arr[3] = "Car3";

        // System.out.println(arr.length);
        // System.out.println("*********************");
        // for(String s : arr){
        //     System.out.println(s);
        // }

        // String[][] arr2 = new String[3][2];
        // arr2[0][0] = "Car1";
        // arr2[0][1] = "Car2";

        // arr2[1][0] = "Car3";
        // arr2[1][1] = "Car4";

        // arr2[2][0] = "Car5";
        // arr2[2][1] = "Car6";
        // for(String[] i : arr2){
        //     System.out.println(i[0]);
        //     System.out.println(i[1]);
        // }
        // String str = "hello";
        // Integer num = 5;
        // Integer num2 = 2;
        // num = 10;
        // num += 10 + 10;

        // num = num /num2;

        // System.out.println(num);
        // System.out.println(str);
        // System.out.println("Comparing:: String");
        // System.out.println(str.equals("hello"));

        // String a1 = "A";
        // String a2 = "B";
        // System.out.println(a1==a2);
        // System.out.println("Comparing:: Integer");
        // Integer no1 = 1;
        // Integer no2 = 2;
        // System.out.println(no1<no2);
        // System.out.println(no1!=no2);

        //for loop***********************************************************************
        // for (int i = 0; i <= 10; i+=1){
        //     System.out.println(i);
        //     if(i==3){
        //         break;
        //     }
            
        // }

        // for (int i = 10; i >= 0; i--){
        //     System.out.println(i);
        // }


        // String[] arr = {"A","B","C","D"};

        // for(String x : arr){
        //     System.out.println(x);
        // }

        // int i = 0;

        // while(i < arr.length){
        //     System.out.println(arr[i]);
        //     i++;
        // }

        // do{
        //     System.out.println(i);
        //     i++;
        // }while(i < 5);

        //IF***********************************************************
        
        // String name = "a";
        // String name2 = "a";
        // int num = 1234;
        // int num2 = 1234;

        // if(name == name2 && (num == num2 || num != 333)){
        //     System.out.println("Correct!");
        // }else{
        //     System.out.println("Not Correct!");
        // }

        // if(name == "B"){
        //     System.out.println("1 B!");
        // }else if(name == "a"){
        //     System.out.println("2 a!");
        // }else if(name2 == "a"){
        //     System.out.println("3 a!");
        // }else{
        //     System.out.println("Not Found!");
        // }

        // String firstName = "Sevasit";
        // String lastName = null;

        // String getLastName = lastName == null ? "": lastName;
        // System.out.println(getLastName);

        // int datNum = 1;
        // switch(datNum){
        //     case 1:
        //     System.out.println("Monday");
        //     break;
        //     case 2:
        //     System.out.println("Tuesday");
        //     break;
        //     case 3:
        //     System.out.println("Wednesday");
        //     break;
        //     case 4:
        //     System.out.println("Thursday");
        //     break;
        //     case 5:
        //     System.out.println("Friday");
        //     break;
        //     case 6:
        //     System.out.println("Saturday");
        //     break;
        //     case 7:
        //     System.out.println("Sunday");
        //     break;
        //     default:
        //     System.out.println("Not Found Day!");
        // }

        // int score = 49;
        // if(score > 100){
        //     System.out.println("Not Found!");
        //     }else{
        //         if(score >= 80 && score <= 100){
        //             System.out.println("Grade A");
        //         }else if(score >= 70){
        //             System.out.println("Grade B");
        //         }
        //         else if(score >= 60){
        //             System.out.println("Grade C");
        //         }
        //         else if(score >= 50){
        //             System.out.println("Grade D");
        //         }else{
        //             System.out.println("Grade F!");
        //     }
        //  }









        


        //การบ้าน
        //ข้อ1
        System.out.print("Enter your number: ");
        Integer num = Integer.parseInt(scanner.next());
        int ct = 0;

            if(num > 1){
                for(int i = 1; i <= num; i++){
                    if(num % i == 0){
                        ct++;
                    }
                }
            }else{
                System.out.println("num is invalid");
            }

            if(ct == 2){
                System.out.println("num is valid");
            }else{
                System.out.println("num is invalid");
            }

        //ข้อ2
        System.out.println("**********************************************");
        System.out.print("Enter your age: ");
        Integer age = Integer.parseInt(scanner.next());
        if(age >= 18){
            System.out.println("You can vote!");
        }else{
            System.out.println("You can't vote!");
        }

        //ข้อ3
        System.out.print("Enter your number: ");
        Integer num3 = Integer.parseInt(scanner.next());
        int ct3 = 0;

            if(num3 > 1){
                for(int i = 1; i <= num3; i++){
                    if(num3 % i == 0){
                        ct3++;
                    }
                }
            }else{
                System.out.println("num is invalid and is not even");
            }

            if(ct3 == 2 && num3 % 2 == 0){
                System.out.println("num is valid and is even!!");
            }else{
                System.out.println("num is invalid and is not even");
            }

        //ข้อ4
        System.out.println("**********************************************");
        int rows = 5;

        for (int i = rows - 1; i >= 0 ; i--){
            for (int j = 0; j <= i; j++){
                System.out.print("*" + " ");
            }
        System.out.println();
        }

        //ข้อ5
        System.out.println("**********************************************");
        for (int i = 0; i <= rows - 1 ; i++){
            for (int j = 0; j < i; j++){
                System.out.print(" ");
            }
            for (int k = i; k <= rows - 1; k++) { 
                System.out.print("*" + " "); 
            } 
        System.out.println(""); 
        } 
        for (int i = rows - 1; i >= 0; i--){
            for (int j = 0; j < i ;j++){
                System.out.print(" ");
            }
                for (int k = i; k <= rows - 1; k++){
                    System.out.print("*" + " ");
                }
            System.out.println("");
        }

    }
}