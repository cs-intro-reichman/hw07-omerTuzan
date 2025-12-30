/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.
		StdDraw.setCanvasSize(800, 800); 
    	// StdDraw.setYscale(0, 1);

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// 	  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		//       Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
       		 StdDraw.line(x1, y1, x2, y2);
        return;
    }
		//// Write the rest of your code below.
		double x3 = (x1 + x2) / 2 + Math.sqrt(3) / 6 * (y1 - y2), y3 = (y1 + y2) / 2 + Math.sqrt(3) / 6 * (x2 - x1);

		double x2_sub = x1 + (x2 - x1) / 3.0;
        double y2_sub = y1 + (y2 - y1) / 3.0;
        
        double x4_sub = x1 + 2.0 * (x2 - x1) / 3.0;
        double y4_sub = y1 + 2.0 * (y2 - y1) / 3.0;

		curve(n - 1, x1, y1, x2_sub, y2_sub);         
    	curve(n - 1, x2_sub, y2_sub, x3, y3);  
    	curve(n - 1, x3, y3, x4_sub, y4_sub);      
    	curve(n - 1, x4_sub, y4_sub, x2, y2);


	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
		double xTop = 0.5, yTop = 0.85;
        double xLeft = 0.1, yLeft = 0.15;
        double xRight = 0.9, yRight = 0.15;

		curve(n, xRight, yRight, xLeft, yLeft);
		curve(n, xLeft, yLeft, xTop, yTop);
		curve(n, xTop, yTop, xRight, yRight);
	}
}
