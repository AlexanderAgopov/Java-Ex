package abstractclass;

public class Rectangle extends Shape {

	public Rectangle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateSurface() {
		// TODO Auto-generated method stub
		return super.getWidth() * super.getHeight();
	}

}
