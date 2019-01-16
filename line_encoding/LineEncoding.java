
package lineencoding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineEncoding {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<Integer>();
        int n,i,flag=0;
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of bits in data:");
        n=s.nextInt();
        System.out.print("\nEnter the data: ");
        for(i=0;i<n;i++){
            data.add(s.nextInt());
        }
        System.out.println("\n-----Output given for every half clock pulse-----");
         //unipolar nrz
        System.out.println("UNIPOLAR NRZ");
        for(i=0;i<n;i++){
            if(data.get(i)==0)
                System.out.print("0 0 ");
            else
                System.out.print("+ + ");
        }
      //Bipolar AMI
        System.out.println("\nBIPOLAR AMI");
        for(i=0;i<n;i++){
            if(data.get(i)==0)
                System.out.print("0 0 ");
            else{
                if(flag==0){
                 System.out.print("+ + ");
                 flag=1;
                }
                else{
                    System.out.print("- - ");           
                    flag=0;
                }
            }
        }
        flag=0;
       //pseudo ternary
        System.out.println("\nPSEUDO TERNARY");
        for(i=0;i<n;i++){
            if(data.get(i)==1)
                System.out.print("0 0 ");
            else{
                if(flag==0){
                 System.out.print("+ + ");
                 flag=1;
                }
                else{
                    System.out.print("- - ");      
                    flag=0;
                }
                                
                    
            }
            
        }
      //biphase manchester
      System.out.println("\nBIPHASE MANCHESTER");
        for(i=0;i<n;i++){
            if(data.get(i)==0)
                System.out.print("+ - ");
            else
                System.out.print("- + ");
        }
        flag=0;// - +
        System.out.println("\nDIFFERENTIAL MANCHESTER");
       //differential manchester
         for(i=0;i<n;i++){
              if(data.get(i)==1){
                  if(flag==0)
                      System.out.print("+ - ");
                  else
                      System.out.print("- + ");
              }
              else{
                  if(flag==0){
                      System.out.print("- + ");
                      flag=1;
                  }
                  else{
                      System.out.print("+ - ");
                      flag=0;
                  }
              }                   
        }
        //RZ
        System.out.println("\nReturn to zero");
         for(i=0;i<n;i++){
            if(data.get(i)==0)
                System.out.print("- 0 ");
            else
                System.out.print("+ 0 ");
        }
         System.out.print("\n");
    }
}
