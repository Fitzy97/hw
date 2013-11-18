//Sean Fitzgerald
//pd09
//hw27
//2013-11-19

public class Rational {

	private int p;
	private int q;
	private double rational;

	public Rational() {
	    p = 0;
	    q = 1;
	    rational = p / q;
	}

	public Rational(int num, int den) {
	    p = num;
	    if (den == 0) {
	        rational = 0 / 1;
		System.out.println("Invalid denominator");
	    }
	    else {
		q = den;
		rational = p / q;
	    }
	}

	public String toString() {
	    return "" + p + "/" + q;
	}

	public double floatValue() {
	    double ret = (double)p/(double)q;
	    return ret;
	}

	public void multiply(Rational number) {
	    p *= Integer.parseInt(number.toString().substring(0,1));
	    q *= Integer.parseInt(number.toString().substring(2));
	}

	public void divide(Rational number) {
	    p *= Integer.parseInt(number.toString().substring(2));
	    q *= Integer.parseInt(number.toString().substring(0,1));
	}

	public void add(Rational number) {
	    int op = Integer.parseInt(number.toString().substring(0,1));
	    int oq = Integer.parseInt(number.toString().substring(2));
	    int ogp = p;
	    int ogq = q;
	    q *= oq;
	    p *= oq;
	    oq *= ogq;
	    op *= ogq;
	    p += op;
	}

	public void subtract(Rational number) {
	    int op = Integer.parseInt(number.toString().substring(0,1));
	    int oq = Integer.parseInt(number.toString().substring(2));
	    int ogp = p;
	    int ogq = q;
	    q *= oq;
	    p *= oq;
	    oq *= ogq;
	    op *= ogq;
	    p -= op;
	}

	public int gcd() {
	    int lesser;
	    int i = 1;
	    int retInt = 0;
	    if (p >= q) {
		lesser = q;
	    }
	    else {
		lesser = p;
	    }
	    if (p == q) {
		retInt =  p;
	    }
	    while (i <= lesser) {
		if ( p % i == 0 && q % i == 0 ) {
		    retInt = i;
		}
		i += 1;
	    }
	    return retInt;
	}

	public void reduce() {
	    int op = p / this.gcd();
	    int oq = q / this.gcd();
	    p = op;
	    q = oq;
	}

	public static int gcd(int p, int q) {
	    int lesser;
	    int retInt = 0;
	    if (p >= q) {
		lesser = q;
	    }
	    else {
		lesser = p;
	    }
	    if (p == q) {
		retInt =  p;
	    }
	    else {
		retInt = gcd(lesser, (Math.max(p, q) - lesser));
	    }
	    return retInt;
	}

	public int compareTo( Rational number ) {
	    int op = Integer.parseInt(number.toString().substring(0,1));
	    int oq = Integer.parseInt(number.toString().substring(2));
	    if (p/q == op/oq) {
		return 0;
	    }
	    else if (p/q > op/oq) {
		return 1;
	    }
	    else {
		return -1;
	    }
	}

    public static void main(String [] args) {
	
	Rational r = new Rational(2, 3);
	Rational s = new Rational(1, 2);
	Rational t = new Rational(3, 0);

	System.out.println( "2/3: " + r );
	System.out.println( "0.5: " + s.floatValue() );

	r.multiply(s);

	System.out.println( "2/6: " + r );
	System.out.println( "1/2: " + s );

	s.divide( r );

	System.out.println( "2/6: " + r );
	System.out.println( "6/4: " + s );

	r.add( s );

	System.out.println( "44/24: " + r );
	System.out.println( "6/4: " + s );

	r.reduce();
	s.reduce();
	r.subtract( s );

	System.out.println( "4/12: " + r );
	System.out.println( "3/2: " + s );

	System.out.println( "4: " + r.gcd() );
	System.out.println( "1: " + s.gcd() );

	r.reduce();

	System.out.println( "1/3: " + r );

	System.out.println( "3: " + Rational.gcd(6, 9) );

	System.out.println( "1: " + s.compareTo( r ) );
	System.out.println( "-1: " + r.compareTo( s ) );
    }

}
