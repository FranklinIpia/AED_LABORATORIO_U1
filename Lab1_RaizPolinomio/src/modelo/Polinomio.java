package modelo;

import java.util.ArrayList;
import java.util.List;

public class Polinomio {

	private double[] coefficientN;
	private int[] roots;
	
	private double r0;
	private double s0;
	private double re[];
	private double im[];//raices complejas
	
	int cont=0;
	int cont2=0;

	public Polinomio(double[] coefficientN) {
		this.coefficientN=coefficientN;
		  re = new double[coefficientN.length]; 
		  im = new double[coefficientN.length];
		  r0=-1;
		  s0=-1;
	}
	
	
	
	  public void Bairstow( )
	  {
		  

	    int n = coefficientN.length; 
	    int iter =0;
	    double b[] = new double[n], c[] = new double[n];
	    double ea1 = 1, ea2 = 1, T = 0.00001;
	    double r=r0, s=s0,det, ds, dr;
	    int MaxIter = 100, i;

	   for(iter=0; iter< MaxIter && n>3; iter++)
	   {
		   System.out.println(cont);
		   cont=0;

	      do {
	    	  cont++;
	    	  System.out.println("do: "+cont);
	        Division_Derivada(coefficientN, b, c, r, s, n);
	        
	        det = c[2]*c[2] - c[3]*c[1];

	        if(det!=0)
	        {

	          dr = (-b[1]*c[2] + b[0]*c[3])/det;
	          ds = (-b[0]*c[2] + b[1]*c[1])/det;

	          r = r+dr;
	          s = s+ds;

	          if(r!=0) 
	        	  ea1 = Math.abs(dr/r)*100.0;
	          if(s!=0) 
	        	  ea2 = Math.abs(ds/s)*100.0;

	        }

	        else
	        {

	          r = 5*r+1;
	          s = s+1;
	          iter = 0;

	        }

	      }

	      while ((ea1 > T) && (ea2 > T));
	      raices(r, s, re, im, n);
	      n = n-2;

	      for(i=0; i<n; i++)
	        coefficientN[i] = b[i+2];
	      if (n < 4) break;

	    }

	    if(n==3)
	    {

	      r = -coefficientN[1]/coefficientN[2];
	      s = -coefficientN[0]/coefficientN[2];
	      raices(r, s, re, im, n);

	    }

	    else
	    {

	      re[n-1] = -coefficientN[0]/coefficientN[1];
	      im[n-1] = 0;

	    }
//      IMPRIME RAICES
//	    for(i=1; i<re.length; i++) {
//	        int raiz=(int) Math.round(re[i]);
//	        System.out.println("las raices modificadas son: "+ "X["+i+"]= " + raiz + " j " + im[i]);
//	    }
//	    for(i=1; i<re.length; i++) {
//	        int raiz=(int) Math.round(re[i]);
//	      System.out.println("las raices modificadas son: "+ "X["+i+"]= " + raiz + " j " + im[i]);
//	    }
	  }
	
	
	
	 public static void raices(double r, double s, double re[], double im[], int n)
	  {

	    double d = r*r + 4*s;

	    if(d > 0)
	    {

	      re[n-1] = (r + Math.sqrt(d))/2.0;
	      re[n-2] = (r - Math.sqrt(d))/2.0;

	      im[n-1] = 0;
	      im[n-2] = 0;

	    }

	    else
	    {

	      re[n-1] = r/2.0;
	      re[n-2] = re[n-1];
	      im[n-1] = Math.sqrt(-d)/2.0;
	      im[n-2] = -im[n-1];

	    }

	  }

	 public static void Division_Derivada(double a[], double b[], double c[], double r, double s, int n)
	  {

	    int i;

	    b[n-1] = a[n-1];
	    b[n-2] = a[n-2] + r*b[n-1];

	    c[n-1] = b[n-1];
	    c[n-2] = b[n-2] + r*c[n-1];

	    for(i=n-3; i>=0; i--)
	    {

	      b[i] = a[i] + r*b[i+1] + s*b[i+2];
	      c[i] = b[i] + r*c[i+1] + s*c[i+2];

	    }

	  }
	 
	 
//	 public static void imprime(double x[], int n)
//	  {
//
//	    int i;
//
//	    for (i = n - 1; i >= 0; i--)
//
//	      if(x[i] > 0) System.out.print("+ " +x[i] + "x"+i+" ");
//	      else System.out.print("- " + -x[i] + "x"+i+" ");
//	    System.out.println("");
//
//	  }

	 

	  public String getRoots(){
		  String roots="las raices del polinomio son: \n";
		  for(int i=1; i<re.length; i++) {
		        int raiz=(int) Math.round(re[i]);
		     roots+= "X["+i+"]= " + raiz + " j " + im[i]+"\n";
		    }
		  
return roots;
	  }

	
	  
	  
	  public void MetodoCuadratica() {
		  
		  int a=(int) coefficientN[0];
		  int b=(int) coefficientN[1];		
		  int c=(int) coefficientN[2];

   	   double x1 = (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);

          double x2 = (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
          
          
          
   }

}
