public class Solution {

    public int evalRPN(List<String> tokens) {

        if(tokens.size() == 0)

            return 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(String s : tokens)

        {

            if(!Character.isDigit(s.charAt(0)) && s.length() == 1)

            {

                int a = stack.pop();

                int b = stack.pop();

                if(s.charAt(0) == '+')

                    stack.push(a+b);

                else if(s.charAt(0) == '-')

                	stack.push(b-a);

                else if(s.charAt(0) == '*')

                	stack.push(a*b);

                else if(s.charAt(0) == '/')

                	stack.push(b/a);

            }

            else

                stack.push(Integer.parseInt(s));

        }

        return stack.pop();

    }

}
