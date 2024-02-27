
package model;


public class Search {
    public void Linearsearch(float[] arr, float k){
        int n = arr.length;
        int s=0;
        for (int i=0;i<=n-1;i++){
            if (arr[i]==k){
                s = i+1;
                break;
            };
        }
        if (s==0){
            System.out.println("Unfound!");
        }
        else {
            System.out.println("Number need to be search stay at "+s);
        }
            
    }
    
    public void Binarysearch(float[] arr,float k){
        int head=0;
        int tail=arr.length;
        int s=0;
        int avr=0;
        while (s==0){
            avr = (head+tail)/2;
            if (k>arr[avr]){
                head =avr;
            }
            else
            if (k<arr[avr]){
                tail=avr;
            }
            else
            if (k==arr[avr] ){
                break;
            }
            else if(head==avr || tail==avr){
                s=1;
            }
        }
        if (s==1){
            System.out.println("Unfound!");
        }
        else System.out.println("Number need to be search stay at "+ avr);
    }
}
