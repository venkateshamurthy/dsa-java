package io.github.venkateshamurthy.algos.twopointers;

import static java.lang.Character.*;

public class WordAbbreviation {
    public boolean isAbbreviation(String word, String abbr){
        int w=0,W= word.length(), a=0,A= abbr.length();
        while (w<W && a<A) {
            //increae two pinters until chars match
            while (w<W && a<A && word.charAt(w)==abbr.charAt(a)){
                a++; w++;
            }
            //if all done then return true;
            if (w == W && a == A) return true;
            if (w == W || a == A) return false;

            //chars mismatch
            if(a<A && isLetter(abbr.charAt(a)) && word.charAt(w)!=abbr.charAt(a))
                return false;

            //If there is a Leading '0' return  false
            if(abbr.charAt(a)=='0' && a+1 < A && isDigit(abbr.charAt(a+1)))
                return false;

            // Capture all the
            int digit = 0;
            while (a<A && isDigit(abbr.charAt(a))) {
                int d = digit(abbr.charAt(a++),10);
                digit = 10 * digit + d;
            }
            if(w + digit >= W) return false;
            w += digit;
        }

        return w==W && a==A; // this must have exhausted
    }

    public  static void main(String[] args) {
        WordAbbreviation s = new WordAbbreviation();
        System.out.println("expecting true:"+s.isAbbreviation("abcdefg", "a4fg"));
        System.out.println("expecting true:"+s.isAbbreviation("abc", "abc"));
        System.out.println("expecting true:"+s.isAbbreviation("abc", "a1c"));
        System.out.println("expecting true:"+s.isAbbreviation("WordSmithing in the internationalization world is localization abused",
                "W3S6g in the i18n world is l10n a4d"));
        System.out.println("expecting false:"+s.isAbbreviation("WordSmithing in the internationalization world is localization abused",
                "W03S6g in the i18n world is l10n abused"));
        System.err.println("expecting false:"+s.isAbbreviation("s","s11"));
    }
}
