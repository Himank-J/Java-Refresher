package Recursion;
class PalindromeRecursive {
    public static void main(String[] args) {
        String str = "himank";
        boolean result = isPalindrome(str);
        System.out.println("Is \"" + str + "\" a palindrome? " + result);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        int lastPos = str.length() - 1;
        if (str.charAt(0) != str.charAt(lastPos)) {
            return false;
        }

        String newStr = str.substring(1, lastPos);
        return isPalindrome(newStr);
    }
}
