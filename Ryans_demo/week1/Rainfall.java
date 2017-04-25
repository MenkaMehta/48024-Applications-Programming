public class Rainfall {
	public static void main(String[] args) {
		double[] rainfall = { 110.5, 107, 108.2, 90.1, 97.6, 65, 88.9, 127.3, 101.7, 100.6, 121, 103 };
		double totalRainfall = 0;
		for (int i = 0; i < rainfall.length; i++) {
			totalRainfall += rainfall[i];
		}
		System.out.println("Total rainfall = " + totalRainfall);
	}
}
