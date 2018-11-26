package abstractclass;

public class Triangle extends Shape{
	

	public Triangle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateSurface() {
		// TODO Auto-generated method stub
		return (super.getHeight() * super.getWidth())/2;
	}

}
