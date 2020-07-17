package bat.ke.qq.com.forkjoin.util;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Utils {

	public static void doCpuIntensiveCalculation() {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		for (int i = 0; i <= 500; i++) {
			digest.update((byte) i);
			digest.digest();
		}
	}

	public static int[] buildRandomIntArray(final int size) {
		int[] arrayToCalculateSumOf = new int[size];
		Random generator = new Random();
		for (int i = 0; i < arrayToCalculateSumOf.length; i++) {
			arrayToCalculateSumOf[i] = generator.nextInt(1000); //Integer.MAX_VALUE);
		}
		return arrayToCalculateSumOf;
	}

	public static int[] buildRandomIntArray() {
		return buildRandomIntArray(200000);
	}

	public static int[] buildRandomIntArrayForLogging() {
		int[] arrayToCalculateSumOf = new int[10];
		Random generator = new Random();
		for (int i = 0; i < arrayToCalculateSumOf.length; i++) {
			arrayToCalculateSumOf[i] = generator.nextInt(500000);
		}
		return arrayToCalculateSumOf;
	}

	public static long calculateSumOfArray(final int[] arrayToCalculateSumOf) {
		long expected = 0;
		for (int value : arrayToCalculateSumOf) {
			expected += value;
		}

		return expected;
	}

	public static BufferedReader getBufferedReaderOldFashionedly(final String resourceName) throws IOException {
		InputStream inStream = new FileInputStream(resourceName);
		return new BufferedReader(new InputStreamReader(inStream));
	}

	public static BufferedReader getBufferedReaderByNIO(final String resourceName) throws IOException {
		Path path = FileSystems.getDefault().getPath(resourceName);
		return Files.newBufferedReader(path, Charset.defaultCharset());
	}
}