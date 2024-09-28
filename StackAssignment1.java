/*Given a stack of integers, calculate the sum of all the integers present in the stack. Modify the stack such that the sum is present in the bottom of the stack and all the other integers are present in the stack in the same order. Implement the logic inside calculateSum() method of the Tester class.

The Stack class has been provided.

 

Test the functionalities using the main() method of the Tester class.*/


class Stack {
    
    private int top; 
    private int maxSize; 
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1; 
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return top >= (maxSize - 1);
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        } else {
            arr[++top] = data;
            return true;
        }
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]); // accessing element at position index
            }
        }
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        else
            return arr[top--];
    }
}

class Tester {
      
    public static void main(String args[]) {
            
        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        
        calculateSum(stack);
            
        System.out.println("Updated stack");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }

        int sum = 0;
        Stack tempStack = new Stack(10); // Use a fixed size for the temporary stack

        // Calculate sum and store elements in tempStack
        while (!stack.isEmpty()) {
            int value = stack.pop();
            sum += value;
            tempStack.push(value);
        }

        // Push the sum to the bottom of the stack
        stack.push(sum);

        // Restore the elements back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}


 
