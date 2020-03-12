package com.igor;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        String s = "";
        Boolean valid = false;

        if(args.length > 0){

            s = args[0];

            valid = validateString(s,0);

        }

        while(!valid){

            Scanner sc = new Scanner(System.in);

            System.out.print("Enter your input: ");

            s = sc.nextLine();

            System.out.println();

            valid = validateString(s,0);

            if(!valid){
                System.out.println("Input " + s +  " is empty or contain invalid characters!");
                System.out.println();
            }

        }



        Stack<Character> bracketsStack = new Stack<>();
        Stack<Character> parenthesisStack = new Stack<>();
        Stack<Character> bracesStack = new Stack<>();




        valid = checkBalancedBrackets(s,0,bracketsStack,parenthesisStack,bracesStack);

        if(valid){

            System.out.println(s + " is valid");

        } else {

            System.out.println(s + " is not valid");

        }

    }


    /*

        A ideia aqui é criar uma pilha para cada tipo de pares de caracteres que queremos balancear ([],{},()).
        Com isso o algoritmo percorre a string recursivamente e ao encontrar [, { ou ( , insere na pilha correspondente.
        Se encontrar ], } ou ) e a pilha correspondente estiver vazia, significa que houve um ou mais pares fechados que não foram abertos,
        logo a string não é válida.
        Se o algoritmo chegar no final da string e alguma das pilhas não estiver vazia, significa que um ou mais pares foram abertos e não foram fechados,
        logo a string não é válida.


     */
    private static Boolean checkBalancedBrackets(String s, int charPos, Stack<Character> bracketsStack, Stack<Character> parenthesisStack, Stack<Character> bracesStack){

        if(charPos == s.length()){

            return bracesStack.empty() && parenthesisStack.empty() && bracketsStack.empty();

        }

        char c = s.charAt(charPos);

        switch (c){

            case '{':

                bracesStack.push('{');

                break;

            case '[':

                bracketsStack.push('[');

                break;

            case '(':

                parenthesisStack.push('(');

                break;

            case '}':

                if(bracesStack.empty()){

                    return false;

                }

                bracesStack.pop();

                break;

            case ']':

                if(bracketsStack.empty()){

                    return false;

                }

                bracketsStack.pop();

                break;

            case ')':

                if(parenthesisStack.empty()){

                    return false;

                }

                parenthesisStack.pop();

                break;
        }

        return checkBalancedBrackets(s,charPos + 1, bracketsStack,parenthesisStack,bracesStack);

    }

    //Esse método serve para validar se a entrada do algoritmo contém apenas [,{,(,),} e ] e é diferente de vazio
    private static Boolean validateString(String s, int charPos){

        if(s == null || s.length() == 0){

            return false;

        }

        if(charPos == s.length() - 1){

            return true;

        }

        if(!validateChar(s.charAt(charPos))){

            return false;

        }

        return validateString(s,charPos + 1);

    }

    private static Boolean validateChar(char c){

        return ((c == '{' || c == '}') ||
                (c == '[' || c == ']') ||
                (c == '(' || c == ')'));

    }
}
