
package rsa;

import java.util.Scanner;
/**
 *
 * @author nazmul
 */
public class RSA_CryptoSystem {
    private int gcd(int a, int b){
        int temp;
        if (a<b){
            temp=a;
            a=b;
            b=temp;
        }
        while (b > 0){
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void Big_value(int msg, int p, int q){
        
        try{
            int n = p*q;
            int phi = (p-1)*(q-1);
            int e=2;
            while(e<n){
                if(gcd(e,phi)==1)break;
                else e++;
            }
            int d=1;
            while(true){
                if((e*d)%phi==1) break;
                else d++;
            }
            System.out.println("e:"+e);
            System.out.println("d:"+d);

            int temp=1,k=1;
            while(k<=e){
                temp=(temp*msg)%n;
                k++;
            }System.out.println("Encrypted message:"+temp);

            int _temp=1;
            k=1;
            while(k<=d){
                _temp=(_temp*temp)%n;
                k++;
            }System.out.println("decrypted message:"+_temp);
        }catch(Exception e){System.out.println(e);}

    }
       
    public static void main(String[] args) {
        RSA_CryptoSystem obj=new RSA_CryptoSystem(); 
        Scanner reader=new Scanner(System.in);
        int msg, p,q;
        while(true){
            System.out.print("\nInput a positive number or other numbers to exit: ");
            try{
                msg=reader.nextInt();
                if(msg>0){
                    System.out.print("Input p & q: ");
                    p=reader.nextInt();
                    q=reader.nextInt();
                    
                    obj.Big_value(msg,p,q);
                }else break;
            }catch(Exception e){System.out.println(e);}
        }
    }
    
}
