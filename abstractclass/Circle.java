package abstractclass;

public class Circle extends Shape {

	private int radius;

	public Circle(int width, int height, int radius) {
		super(width, height);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double calculateSurface() {
		// TODO Auto-generated method stub
		super.setHeight(this.radius);
		super.setWidth(this.radius);
		return Math.PI * super.getHeight() * super.getWidth();
	}

}
