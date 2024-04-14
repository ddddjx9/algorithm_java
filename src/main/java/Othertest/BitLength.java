package Othertest;

public class BitLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitLength bitLength=new BitLength();
		System.out.println(bitLength.BigLength(2));
	}

	public int BigLength(int x) {
		int d = 0;
        while (x > 0) {
            x >>= 1;
            d++;
        }
        return d;
	}
}
