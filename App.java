import javax.swing.JOptionPane;

public class App {
	public static String s = "";

	public static int check(String temp, int sz) {
		for (int i = 0; i < sz - temp.length() + 1; i++) {
			boolean c = true;
			for (int j = 0; j < temp.length() && c; j++) {
				if (s.charAt(i + j) != temp.charAt(j))
					c = false;
			}
			if (c == true)
				return i;
		}
		return -1;
	}

	public static int bits(int x) {
		int res = 0;
		while (x > 0) {
			x /= 2;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		s=JOptionPane.showInputDialog("please enter ur data :");
		int i = 0;
		int maxPointer = 0, maxLenght = 0, tags = 0;
		while (i < s.length()) {
			String tmp = "";
			int start = i;
			tmp += s.charAt(i);
			while (check(tmp, i) != -1) {
				i++;
				if (i >= s.length())
					break;
				tmp += s.charAt(i);
			}

			System.out.print(tmp + "  ");
			if (tmp.length() == 1) {
				System.out.print("< 0 , 0 , '" + tmp + "' >");
				tags++;
			} else {
				int pos = check(tmp.substring(0, tmp.length() - 1), i);
				// System.out.print( pos +"  " +i );
				if ((start - pos) > maxPointer)
					maxPointer = (start - pos);
				if ((tmp.length() - 1) > maxLenght)
					maxLenght = (tmp.length() - 1);
				tags++;
				System.out.print("< " + (start - pos) + " , "
						+ (tmp.length() - 1) + ", '"
						+ tmp.charAt(tmp.length() - 1) + "' >");
			}
			System.out.println();
			i++;
		}

		System.out.println("Before : " + s.length() * 7);
		System.out.println("After : " + tags
				* (bits(maxPointer) + bits(maxLenght) + 7));

	}

}
