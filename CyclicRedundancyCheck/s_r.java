import java.util.Scanner;
public class s_r
{
  int gpol[]=new int[15];
  int gbits;
  int rem[]=new int[15];
  int data[] = new int[25];
  int code[]=new int[25];
  int i=0,n,nc,flag=0,f=0,k,new_n,new_nc,l;
  Scanner x=new Scanner(System.in);
void clear_var()
{
  for(i=0;i<15;i++)
     {
       gpol[i]=0;
       rem[i]=0;
       data[i]=0;
       code[i]=0;
     }
  for(i=15;i<25;i++)
  {
        data[i]=0;
        code[i]=0;
  }
  gbits=0;i=0;n=0;flag=0;f=0;k=0;new_n=0;l=0;
}
int exor(int a,int b)
  {
    if((a==1)&&(b==1))
      return 0;
    else if((a==0)&&(b==1))
        return 1;
    else if((a==1)&&(b==0))
          return 1;
    else
      return 0;
  }


void divide(int nk,int[] odata)
 {
    for(i=0;i<gbits;i++)
       rem[i]=odata[i];

    for(i=0;i<nk;i++)
     {
       System.out.print("\nfor iter "+i +" :");
       for(int m=0;m<gbits;m++)
           System.out.print(rem[m]);
         if(rem[0]==1)
            {
              // We have to xor the remainder bits with divisor bits
              for(int j=0;j<gbits;j++)
                 rem[j]=exor(rem[j],gpol[j]);
            }
        else     // We have to exor the remainder bits with 0
            for(int j=0;j<gbits;j++)
                rem[j]=exor(rem[j],0);
        for(l=0;l<(gbits-1);l++)
        {
          int g=rem[l+1];
          rem[l]=g;
        }
        rem[gbits-1]=odata[i+gbits];
    }
  }

void sender()
  {
    flag=0;
    //read the data bits
    System.out.print("\nEnter the data(enter 9 to stop):");
    while(flag!=1)
    {
      data[i]=x.nextInt();
      if(data[i]==9)
        flag=1;
      i++;
    }
    n=i-1;//[0 to n)(inclusive)
    flag=0;
    i=0;
    //read the generator polynomial
    System.out.print("\nEnter the generator polynomial(enter 9 to stop):");
    while(flag!=1)
    {
      gpol[i]=x.nextInt();
      if(gpol[i]==9)
        flag=1;
      i++;
    }
    gbits=i-1;//[0 to gbits)
    new_n=n+gbits-1;//new data is [0 new_n) exclusive of new_n
    for(i=n;i<new_n;i++)
      data[i]=0;
    divide(n,data);
    System.out.print("\nCRC : ");
      for(i=0;i<(gbits-1);i++)
        System.out.print(rem[i]);
      for(i=0,k=n;i<(gbits-1);i++,k++)
          data[k]=rem[i];
    System.out.print("\nData : ");
      for(i=0;i<new_n;i++)
        System.out.print(data[i]);
    clear_var();
  }


void receiver()
 {
   flag=0;
   //read the data bits
   System.out.print("\nEnter the codeword(enter 9 to stop):");
   while(flag!=1)
   {
     code[i]=x.nextInt();
     if(code[i]==9)
       flag=1;
     i++;
   }
   nc=i-1;//[0 to n)(inclusive)
   flag=0;
   i=0;
   //read the generator polynomial
   System.out.print("\nEnter the generator polynomial(enter 9 to stop):");
   while(flag!=1)
   {
     gpol[i]=x.nextInt();
     if(gpol[i]==9)
       flag=1;
     i++;
   }
   gbits=i-1;//[0 to gbits)
   new_nc=nc-gbits+1;//new data is [0 new_n) exclusive of new_n
   divide(new_nc,code);
   System.out.print("\nRemainder : ");
     for(i=0;i<(gbits-1);i++)
       System.out.print(rem[i]);
   for(i=0;i<(gbits-1);i++)
       {
             if(rem[i]!=0)
               {
                 System.out.println("\nThe data received is not correct!");
                 break;
               }
            else
               f=1;
       }

   if(f==1)
    {
      System.out.print("\nData : ");
            for(i=0;i<new_nc;i++)
              System.out.print(code[i]);
    }
    clear_var();
  }
}




