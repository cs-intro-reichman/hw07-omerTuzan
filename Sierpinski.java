/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		

		StdDraw.setCanvasSize(800, 800); 
    	StdDraw.setXscale(0, 1);
    	StdDraw.setYscale(0, 1);

		sierpinski(Integer.parseInt(args[0]));

	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		if (n == 0) {
            return;
        }
		double x1 = 0.0, y1 = 0.0;
    	double x2 = 1.0, y2 = 0.0;
    	double x3 = 0.5, y3 = Math.sqrt(3) / 2.0;

		StdDraw.setPenColor(StdDraw.BLACK);
    	StdDraw.line(x1, y1, x2, y2);
   	    StdDraw.line(x2, y2, x3, y3);
    	StdDraw.line(x3, y3, x1, y1);		

		//// Replace this comment with your code
		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		//// Replace this comment with your code
		if (n == 0) {
            return;
        }

		double midX12 = (x1 + x2) / 2, midY12 = (y1 + y2) / 2;
		double midX23 = (x2 + x3) / 2, midY23 = (y2 + y3) / 2;
		double midX31 = (x1 + x3) / 2, midY31 = (y1 + y3) / 2;

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(midX12, midY12, midX23, midY23);
   	    StdDraw.line(midX23, midY23, midX31, midY31);
    	StdDraw.line(midX31, midY31, midX12, midY12);
		

		sierpinski(n - 1, x1, midX12, midX31, y1, midY12, midY31);
		sierpinski(n - 1, midX12, x2, midX23, midY12, y2, midY23);
		sierpinski(n - 1, midX31, midX23, x3, midY31, midY23, y3);
		
	}
}
