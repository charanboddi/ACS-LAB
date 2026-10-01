import java.util.*;

class ServerRequestValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack<>();

        System.out.print("Enter server request: ");
        String str = sc.nextLine();

        boolean valid = true;

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {

                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty())
            valid = false;

        if (valid)
            System.out.println("Request is VALID");
        else
            System.out.println("Request is INVALID");

        sc.close();
    }
}