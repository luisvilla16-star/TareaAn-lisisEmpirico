package org.example.tareaalgoritmos;

public  class Sumatoria {
    private long n;

    public static long sumatoria0aN(long n){
        long sumatoria=0;
        for(int i=0; i<=n;i++){
            sumatoria+=i;
        }
        return sumatoria;
    }

    public static long sumatoriaGauss(long n){
        long k=0;
        k=n*(n+1)/2;
        return k;
    }

    public static long sumatoriaRecursiva(long n, long cont){
        if(n==0){
            return cont;
        }else{
            return sumatoriaRecursiva(n-1,cont+n);
        }
    }
}