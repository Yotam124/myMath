package myMath;


	import java.io.IOException;
import java.text.DecimalFormat;
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
			ArrayList<Double> xExtremeMax = new ArrayList<Double>();
			ArrayList<Double> yExtremeMax = new ArrayList<Double>();
			ArrayList<Double> xExtremeMin = new ArrayList<Double>();
			ArrayList<Double> yExtremeMin = new ArrayList<Double>();
			double x0=-2 , x1=6 , eps = 0.01;
			while (x0<x1) {
				x.add(x0);
				y.add(p.f(x0));
				x0 += eps;
				if(p.f(x0)>p.f(x0-eps)&&p.f(x0)>p.f(x0+eps)) {
					xExtremeMax.add(x0);
					yExtremeMax.add(p.f(x0));
				}
				if(p.f(x0)<p.f(x0-eps)&&p.f(x0)<p.f(x0+eps)) {
					xExtremeMin.add(x0);
					yExtremeMin.add(p.f(x0));
				}
			}
			
	 		double[] xData = new double[x.size()]; 
			double[] yData = new double[y.size()];
			
			
			
			for (int i=0 ; i<xData.length ; i++) {
				xData[i] = x.get(i);
				yData[i] = y.get(i);
			}
			String extremePointsMax = "";
			String extremePointsMin = "";
			DecimalFormat tooLong =new DecimalFormat("####.###");
			for (int i=0 ; i<xExtremeMax.size() ; i++) {
				extremePointsMax += "\n" +"("+tooLong.format(xExtremeMax.get(i))+" ,"+tooLong.format(yExtremeMax.get(i))+")";
			}
			for (int i=0 ; i<xExtremeMin.size() ; i++) {
				extremePointsMin += "\n" +"("+tooLong.format(xExtremeMin.get(i))+" ,"+tooLong.format(yExtremeMin.get(i))+")";
			}
			double area = p.area(-0.941, 4.831, 0.01);
			
			
			
			
			

			// Create Chart
			XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)" +"\n Max:"+extremePointsMax+"\n Min:"+extremePointsMin+"\n The area below x is: "+area , xData, yData);

			// Show it
			new SwingWrapper(chart).displayChart();

			// Save it
			BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapFormat.PNG);

			// or save it in high-res
			BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapFormat.PNG, 300);
		}
}
