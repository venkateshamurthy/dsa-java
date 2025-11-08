package io.github.venkateshamurthy.algos.twopointers;

public class WordAbbreviation {
    public boolean isAbbreviation(String completeWord, String abbreviation) {
        char[] word = completeWord.toCharArray();
        char[] abbr = abbreviation.toCharArray();
        int w=0, W = word.length, a=0, A = abbr.length;

        while (w < W && a < A) {
            //increase two pointers ('a' and 'w') until chars match
            while (w < W && a < A && word[w] == abbr[a]){
                a++; w++;
            }

            //if all done then true;
            if (w == W && a == A) return true;

            //if only one of word or abbreviation is done then false
            if (w == W || a == A) return false;

            //if char mismatch then false
            if(Character.isLetter(abbr[a]) && word[w] != abbr[a]) return false;

            // if char is a '0' then false
            if(abbr[a] == '0') return false;

            // Capture all the digits - checking if each char is a digit to move the 'a' pointer
            int number = 0;
            while (a < A && Character.isDigit(abbr[a]) ) {
                final int digit = Character.digit(abbr[a++],10);
                number = 10 * number + digit;
            }

            // check if the number is too high that exceeds the word length; or else move the 'w' pointer
            if(w + number >= W) return false;
            w += number;
        }

        return w == W && a == A; // this must have exhausted both pointers to return true; isn't it?
    }

    public  static void main(String[] args) {
        WordAbbreviation s = new WordAbbreviation();
        System.out.println("expecting true:"+s.isAbbreviation("abcdefg", "a4fg"));
        System.out.println("expecting true:"+s.isAbbreviation("abc", "abc"));
        System.out.println("expecting true:"+s.isAbbreviation("abc", "a1c"));

        System.out.println("expecting true:"+s.isAbbreviation(
                "WordSmithing in the internationalization world is localization abused",
                "W3S6g in the i18n world is l10n a4d"));

        System.out.println("expecting false:"+s.isAbbreviation(
                "WordSmithing in the internationalization world is localization abused",
                "W03S6g in the i18n world is l10n abused"));

        System.out.println("expecting false:"+s.isAbbreviation("s","s11"));
    }
}
