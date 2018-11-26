package abstractclass;

public class Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape[] shapes = {new Triangle(4,3), new Rectangle(5,10), new Circle(0,0,3)};
		
		double[] areas = new double[shapes.length];
		
		for(int i = 0; i < shapes.length; i++) {
			areas[i] = shapes[i].calculateSurface();
			System.out.print(areas[i] + " ");
		}
		
		

	}

}
