/*****************************************************************************
 *  Compilation:  javac GuitarHeroLite.java
 *  Execution:    java  GuitarHeroLite
 *  Dependencies: StdAudio.java StdDraw.java GuitarString.java
 *
 *  Plays two guitar strings (concert A and concert C) when the user
 *  types the lowercase letters 'a' and 'c', respectively in the 
 *  standard drawing window.
 *
 ****************************************************************************/

public class GuitarHero { 

	public static void main(String[] args) {
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		GuitarString[] guitar = new GuitarString[37];
		for (int i = 0; i < guitar.length; i++) {
			guitar[i] = new GuitarString(440 * Math.pow(1.05956, i - 24));
		}

		while (true) {
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				int ind = keyboard.indexOf(key);
				if (ind >= 0 && ind < 37) {
					guitar[ind].pluck();
				}
			}

			double sample = 0.0;
			for (GuitarString string : guitar) {
				sample += string.sample();
			}

			StdAudio.play(sample);
			for (GuitarString string : guitar) {
				string.tic();
			}

		}
	}

}