class Solution {
    Set<String> result = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int leftR = 0;
        int rightR = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftR++;
            } else if (c == ')') {
                if (leftR > 0) {
                    leftR--;
                } else {
                    rightR++;
                }
            }
        }

        dfs(s, 0, leftR, rightR, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int leftR,
                     int rightR, int bal, StringBuilder path) {

        if (bal < 0) return;

        if (index == s.length()) {
            if (leftR == 0 && rightR == 0 && bal == 0) {
                result.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);

        path.append(c);

        if (c == '(') {
            dfs(s, index + 1, leftR, rightR,
                bal + 1, path);
        } else if (c == ')') {
            if (bal > 0) {
                dfs(s, index + 1, leftR, rightR,
                    bal - 1, path);
            }
        } else {
            dfs(s, index + 1, leftR, rightR,
                bal, path);
        }

        path.deleteCharAt(path.length() - 1);

        if (c == '(' && leftR > 0) {
            dfs(s, index + 1, leftR - 1, rightR,
                bal, path);
        }

        if (c == ')' && rightR > 0) {
            dfs(s, index + 1, leftR, rightR - 1,
                bal, path);
        }
    }
}