import java.util.Scanner;
public class CyReCh
 {
      public static void main(String[] args)
      {
        int nx=0;
        Scanner s=new Scanner(System.in);
        s_r obj=new s_r();
        while(nx!=3){
          System.out.println("\n*********Cyclic Redundancy Check***********");
          System.out.println("1.At sender's side");
          System.out.println("2.At receiver's side");
          System.out.println("3.Exit");
          System.out.println("Enter your choice: ");
          nx=s.nextInt();
          switch(nx)
          {
              case 1:obj.sender();
                     break;
              case 2:obj.receiver();
                     break;
              case 3: System.exit(0);
              default:break;

          }

        }
  }
}
