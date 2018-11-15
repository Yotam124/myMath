package myMath;


	import java.io.IOException;
import java.util.ArrayList;

import org.knowm.xchart.BitmapEncoder;
	import org.knowm.xchart.BitmapEncoder.BitmapFormat;
	import org.knowm.xchart.QuickChart;
	import org.knowm.xchart.SwingWrapper;
	import org.knowm.xchart.XYChart;
	public class graph {
		
		
		
		public static void main(String[] args) throws IOException { 	
			Polynom p = new Polynom("0.2x^4-1.5x^3+3.0x^2-x-5");
			ArrayList<Double> x = new ArrayList<Double>();
			ArrayList<Double> y = new ArrayList<Double>();
			
			double x0=-2 , x1=6 , eps = 0.01;
			while (x0<x1) {
				x.add(x0);
				y.add(p.f(x0));
				x0 += eps;
			}
			
	 		double[] xData = new double[x.size()]; 
			double[] yData = new double[y.size()];
			
			for (int i=0 ; i<xData.length ; i++) {
				xData[i] = x.get(i);
				yData[i] = y.get(i);
				
			}

			// Create Chart
			XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

			// Show it
			new SwingWrapper(chart).displayChart();

			// Save it
			BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

			// or save it in high-res
			BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
		}
}
