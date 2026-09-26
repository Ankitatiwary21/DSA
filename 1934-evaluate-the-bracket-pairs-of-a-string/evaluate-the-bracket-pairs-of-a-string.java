class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        Map<String, String> mp = new HashMap<>();

        for (List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean bracketOpened = false;
        int i = 0;

        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                bracketOpened = true;
            } else if (c == ')') {
                result.append(mp.getOrDefault(temp.toString(), "?"));
                bracketOpened = false;
                temp = new StringBuilder();
            } else if (bracketOpened) {
                temp.append(c);
            } else {
                result.append(c);
            }

            i++;
        }

        return result.toString();
    }
}
