class MinStack {

    public Stack<Integer> minstack;

    public Stack<Integer> stack;

    public MinStack()

    {

        minstack = new Stack<Integer>();

        stack = new Stack<Integer>();

    }

    public void push(int x) {

        if(minstack.isEmpty() || getMin() >= x)

            minstack.push(x);

        stack.push(x);

    }



    public void pop() {

        int n = stack.pop();

        if(n == getMin())

            minstack.pop();

    }



    public int top() {

        return stack.peek();

    }



    public int getMin() {

        return minstack.peek();

    }

}


