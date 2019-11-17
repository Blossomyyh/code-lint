public class matchWildCard {
    /**
     * todo wildcard matching
     */

    public boolean isMatch(String s, String p) {
        if (s.length() == 0) return p.length() == 0 || isStar(p);
        if (p.length() == 0) return s.length() == 0;
        if (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?')) {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.length() > 0  && p.charAt(0) == '*') {
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        } else {
            return false;
        }
    }

    public boolean isStar(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') return false;
        }
        return true;
    }
}
