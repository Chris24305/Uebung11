package h3;

public class H3_main {
	public static void main(String[] args) {

	}

	public static int[] mergeSort(int[] a) {
		if (a.length == 1) return a;

		int[] aMerged = new int[a.length];
		int[] aL = new int[a.length / 2];
		int[] aR;


		if (a.length % 2 == 0)
			aR = new int[a.length / 2];
		else
			aR = new int[(a.length / 2) + 1];


		for (int i = 0; i < a.length / 2; i++) {
			aL[i] = a[i];
			if (a.length % 2 == 0)
				aR[i] = a[i + a.length / 2];
			else
				aR[i] = a[i + aR.length - 1];
		}
		aR[aR.length - 1] = a[a.length - 1];


		aL = mergeSort(aL);
		aR = mergeSort(aR);


		int aLIndex = 0, aRIndex = 0;
		for (int i = 0; i < a.length; i++) {
			if (aLIndex == aL.length) {
				aMerged[i] = aR[aRIndex];
				aRIndex++;
				continue;
			}
			if (aRIndex == aR.length) {
				aMerged[i] = aL[aLIndex];
				aLIndex++;
				continue;
			}
			if (aL[aLIndex] <= aR[aRIndex]) {
				aMerged[i] = aL[aLIndex];
				aLIndex++;
			} else {
				aMerged[i] = aR[aRIndex];
				aRIndex++;
			}
		}
		return aMerged;
	}
}
