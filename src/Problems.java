public class Problems {
    public static void main(String[] args) {
        Problems p1 = new Problems();
        
        String [] tests = new String[]{"()","()[]{}"};
        for (int i = 0; i < tests.length; i++) {
            System.out.println(p1.isParenthesesVaild(tests[i]));
        }
    }

    public boolean isParenthesesVaild(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();


        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
