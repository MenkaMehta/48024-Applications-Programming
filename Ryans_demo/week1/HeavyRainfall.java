public class HeavyRainfall {
	public static void main(String[] args) {
		double[] rainfall = { 110.5, 107, 108.2, 90.1, 97.6, 65, 88.9, 127.3, 101.7, 100.6, 121, 103 };
		int count = 0;
		for (int i = 0; i < rainfall.length; i++) {
			if (rainfall[i] > 100)
				count++;
		}
		System.out.println("Months with heavy rainfall = " + count);
	}
}
