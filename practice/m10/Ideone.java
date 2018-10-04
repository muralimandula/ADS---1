class Ideone {

	public static String sameStar(String s) {
		int n = s.length();
		if (n < 2) {
			return s;
		}
		if (s.charAt(0) == s.charAt(1)) {
			return s.charAt(0) + "*" + sameStar(s.substring(1));
		}
		return s.charAt(0) + sameStar(s.substring(1));
	}

	public static void main(String[] args) {
		System.out.println(sameStar("hello"));
		System.out.println(sameStar("xxyy"));
		System.out.println(sameStar("aaaa"));
	}
}