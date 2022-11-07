package com.greatlearning.lab3.q1;

import java.util.*;


public class MatchingBrackets 
{
	static boolean checkBrackets(String expr)
    {
        Deque<Character> stack
            = new ArrayDeque<Character>();
  
        for (int i = 0; i < expr.length(); i++) 
        {
            char x = expr.charAt(i);
  
            if (x == '(' || x == '[' || x == '{') 
            {
                stack.push(x);
                continue;
            }
  
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
  
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
  
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
  
        // Check Empty Stack
        return (stack.isEmpty());
    }
  
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the brackets");
        String expr = sc.nextLine();
    	
        
        // Function call
        if (checkBrackets(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}