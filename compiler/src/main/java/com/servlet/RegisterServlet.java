package com.servlet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
  PrintWriter pw=res.getWriter();
  
  res.setContentType("text/html");
   String val=req.getParameter("ip");
     
  List<Token> tokens = tokenize(val);
  List<List<String>> value=expressionEvaluation(val);
  
  pw.println("<html lang=\"en\">");
  pw.println("  <head>");
  pw.println("   <meta charset=\"UTF-8\" />");
  pw.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />");
  pw.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />");
  pw.println("   <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\" />");
  pw.println(" <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin />");
  pw.println("<link href=\"https://fonts.googleapis.com/css2?family=Outfit:wght@400;700&display=swap\"  rel=\"stylesheet\" />");
  pw.println("   <script src=\"./js/script.js\"></script>");
  pw.println("<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,600;0,700;0,800;1,200;1,300;1,400;1,500;1,600;1,700&family=Varela+Round&display=swap\" rel=\"stylesheet\">");
  pw.println("<link rel=\"icon\" type=\"image/x-icon\" href=\"./img/fevicon.png\" />");
  pw.println("    <link rel=\"stylesheet\" href=\"./style.css\" />");
  pw.println(" <title>Online Compiler</title>");
  pw.println(" <script language=\"text/javascript\"></script>");
  pw.println(" <style>");
  pw.println("* {");
  pw.println("box-sizing: border-box;");
  pw.println("font-family: poppins; }");
  pw.println("html { margin: 0; }");
  pw.println("body {  margin: 0;  background-color: #2c3333; }");
  pw.println(".head {");
  pw.println("  background-color: #e7f6f2;");
  pw.println("  background: linear-gradient(90deg, #e7f6f2, #adbeb9);");
  pw.println("  display: flex;");
  pw.println("  justify-content: space-between;");
  pw.println(" align-items: center; }");
  pw.println(".head-toggle {"); 
  pw.println("  display: inline-block;");
  pw.println("  margin: 1.5rem 3rem;");
  pw.println(" align-items: center; }");
  pw.println(".head-toggle a {");
  pw.println("  padding: 0.5rem 2rem;");
  pw.println("  font-weight: 700;");
  pw.println("  margin: 0rem 1rem;");
  pw.println(" border-radius: 3px;");
  pw.println(" text-decoration: none;");
  pw.println("  background-color: #395b64;");
  pw.println(" color: white;");
  pw.println("border: 2px solid #395b64; }");
  pw.println(".head-toggle a:hover, .coders a:hover, .head-toggle a.current {");
  pw.println("color: #395b64;");
  pw.println("border: 2px solid #395b64;");
  pw.println(" background-color: white; }");
  pw.println(".coders a {");
  pw.println("  border-radius: 3px;");
  pw.println(" font-weight: 700;");
  pw.println(" padding: 0.5rem 2rem;");
  pw.println("  color: white;");
  pw.println("  background-color: #395b64;");
  pw.println("  text-decoration: none; }");
  pw.println(".coders { margin-right: 4rem; }");
  pw.println(".main-container {");
  pw.println("  display: flex;");
  pw.println("  width: 100%;");
  pw.println("justify-content: space-between; }");
  pw.println(".main-function { width: 50%; }");
  pw.println(".nav {");
  pw.println("  display: flex;");
  pw.println(" justify-content: space-between;");
  pw.println("  padding: 0.5rem 2rem;");
  pw.println(" background-color: #395b64;");
  pw.println("color: white;");
  pw.println("align-items: center; }");
  pw.println(".nav2 {");
  pw.println("  border-left: 1px solid rgb(255, 255, 255); }");
  pw.println(".nav p {  font-weight: 700; }");
  pw.println(".nav div button {");
  pw.println("  margin: 0rem 0.1rem;");
  pw.println("  padding: 0.2rem 1.5rem;");
  pw.println("  font-weight: 700;");
  pw.println("border: 1px solid #395b64;");
  pw.println(" background-color: #d2e3de;");
  pw.println("border-radius: 3px; }");
  pw.println(".nav div button:hover {");
  pw.println(" background-color: #395b64;");
  pw.println("border-color: #e7f6f2;");
  pw.println("color: #e7f6f2;");
  pw.println(" cursor: pointer; }");
  pw.println("#textarea-input {");
  pw.println("padding: 1rem;");
  pw.println("width: 100%;");
  pw.println("height: 80vh;");
  pw.println("background-color: transparent;");
  pw.println("resize: none;");
  pw.println(" outline: none;");
  pw.println("background-color: #2c3333;");
  pw.println("color: white;");
  pw.println(" outline: none;");
  pw.println("line-height: 1.2rem;");
  pw.println("letter-spacing: 0.08rem;");
  pw.println("font-size: 1rem;");
  pw.println("font-family: ui-monospace,SFMono-Regular,SF Mono,Menlo,Consolas,Liberation Mono,monospace !important; }");
  pw.println("#textarea-output {");
  pw.println(" padding: 1rem;");
  pw.println(" width: 100%;");
  pw.println("height: 80vh;");
  pw.println("background-color: transparent;");
  pw.println("resize: none;");
  pw.println("outline: none;");
  pw.println(" background-color: #2c3333;");
  pw.println("color: white;");
  pw.println("outline: none;");
  pw.println("line-height: 1.2rem;");
  pw.println(" letter-spacing: 0.08rem;");
  pw.println("font-size: 1rem;");
  pw.println("font-family: ui-monospace,SFMono-Regular,SF Mono,Menlo,Consolas,Liberation Mono,monospace !important; }");
  pw.println(".output-function {  width: 50%; }");
  pw.println("</style>");
  pw.println("</head>");
  pw.println("<body>");
  pw.println("<form class=\"form\" action=\"register\" method=\"post\" target=\"_self\"\">");
  pw.println("<header>");
  pw.println(" <div class=\"head\">");
  pw.println("<div class=\"head-toggle\">");
  pw.println("<a href=\"#\" id=\"c\" class=\"\"  onclick=\"c()\">C</a>");
  pw.println("  </div>");
  pw.println("<div class=\"coders\">");
  pw.println(" <a href=\"#\">Simplytry</a>");
  pw.println(" </div>");
  pw.println(" </div>");
  pw.println("<div class=\"main-container\">");
  pw.println("<div class=\"main-function\">");
  pw.println("<div class=\"nav\">");
  pw.println(" <p id=\"code_inp\">Code in C</p>");
  pw.println(" <div>");
  pw.println(" <button \">Run</button>");
  pw.println("</div>");
  pw.println("</div>");
  pw.println("<textarea name=\"\" id=\"textarea-input\">");
  pw.println(val);
  pw.println("</textarea>");
  pw.println("</div>");
  pw.println("<div class=\"output-function\">");
  pw.println("<div class=\"nav nav2\">");
  pw.println("<p>Output</p>");
  pw.println("</div>");
  pw.println("<textarea name=\"\" id=\"textarea-output\" >");
  pw.println("Tokenization"+ "          \r\n");
  for (Token token : tokens) {
	    pw.println(token);
	 }

  pw.println("          \r\n"+"Expession Evaluation"+ "          \r\n");

  for(int i=0;i<3;i++)
  {   
	  List<String> s=value.get(i);
	  pw.println(s);
	  if(i==2) {
		  for(int j=0;j<s.size();j++) {
			  pw.println(s.get(j));
	        String astString= AST(s.get(j));
	        pw.println(astString);
  	  }
	        
	 }
	  
  }
  
  		pw.println("</textarea>");

  
  pw.println("</div>");
  pw.println("</div>");
  
  pw.println("</header></form>");
  pw.println("  </body>");
  pw.println("</html>");
  
  pw.close() ;
  }


@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}


enum TokenType {
    IDENTIFIER,
    KEYWORD,
    CONSTANT,
    SEPERATOR,
    UNKNOWN
}

static class Token {
    TokenType type;
    String value;

    Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}


    public static List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();

        String pattern = "\\b(if|else|while|for|int|return)\\b|[a-zA-Z_][a-zA-Z0-9_]*|[0-9]+\\.?[0-9]*|\\S";
        Pattern tokenPattern = Pattern.compile(pattern);
       Matcher matcher = tokenPattern.matcher(input);
       matcher.reset(input);

        while (matcher.find()) {
            String tokenValue = matcher.group();
            TokenType tokenType;

            if (tokenValue.matches("\\b(if|else|while|for|int|return)\\b")) {
                tokenType = TokenType.KEYWORD;
            } else if (tokenValue.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                tokenType = TokenType.IDENTIFIER;
            } else if (tokenValue.matches("[0-9]+\\.?[0-9]*")) {
                tokenType = TokenType.CONSTANT;
            } else if (tokenValue.matches("\\S")) {
                tokenType = TokenType.SEPERATOR;
            } else {
                tokenType = TokenType.UNKNOWN;
            }

            tokens.add(new Token(tokenType, tokenValue));
        }

        return tokens;
    }
    
    
    public static List<List<String>> expressionEvaluation(String str)
    {
    	List<List<String>> lis=new ArrayList<>();
    	List<String> expr=new ArrayList<>();
    	List<String> sol=new ArrayList<>();
    	List<String> iden=new ArrayList<>();
    	String arr[]=str.split("");
    	Stack<String> st=new Stack<String>();

    	int n=0,flag=0;
    	while(n<arr.length){
    	   String s="";
    	   if(arr[n].contains("=")){
    	       iden.add(arr[n-1]);
    	           flag=1;
    	       }      
    	   else if(flag==1){
    	       if(arr[n].contains(";")){
    	           while(!st.empty()){
    	           s+=st.pop();
    	           }
    	           StringBuilder build=new StringBuilder(s);
    	           build.reverse();
    	           flag=0;
    	           expr.add(build.toString());
    	       }
    	       else{
    	           st.push(arr[n]);
    	       }
    	  }
    	  n++;
    	}
    	for(int i=0;i<iden.size();i++){
    		  String res=infixToPostfix(expr.get(i));
    		   sol.add(res);
    		}
    		lis.add(iden);
    		lis.add(expr);
    		lis.add(sol);

    		
    return lis;
    		
    }
    
    static String infixToPostfix(String exp)
    {
        // Initializing empty String for result
        String result = new String("");
 
        // Initializing empty stack
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);
 
            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c))
                result += c;
 
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(')
                stack.push(c);
 
            // If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty()
                       && stack.peek() != '(') {
                    result += stack.peek();
                    stack.pop();
                }
 
                stack.pop();
            }
           
            // An operator is encountered
            else
            {
                while (!stack.isEmpty()
                       && Prec(c) <= Prec(stack.peek())) {
 
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
 
        // Pop all the operators from the stack
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            result += stack.peek();
            stack.pop();
        }
       
        return result;
    }
    static int Prec(char ch)
    {
        switch (ch) {
        case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        case '^':
            return 3;
        }
        return -1;
    }
    
    
   //tree generator
    


  static  class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

        public static boolean isOperator(String token) {
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
        }

        public static Node constructAST(String[] postfix) {
            Stack<Node> stack = new Stack<>();

            for (String token : postfix) {
                if (!isOperator(token)) {
                    Node operand = new Node(token);
                    stack.push(operand);
                } else {
                    Node operator = new Node(token);
                    operator.right = stack.pop();
                    operator.left = stack.pop();
                    stack.push(operator);
                }
            }

            return stack.pop();
        }

        public static String constructASTString(Node root, String prefix) {
            StringBuilder sb = new StringBuilder();

            if (root != null) {
                sb.append(prefix).append(root.value).append("\n");
                if (root.left != null) {
                    sb.append(prefix).append("|__");
                    sb.append(constructASTString(root.left, prefix + "|  "));
                }
                if (root.right != null) {
                    sb.append(prefix).append("|__");
                    sb.append(constructASTString(root.right, prefix + "   "));
                }
            }

            return sb.toString();
        }

        public static String AST(String args) {
            String[] postfix = args.split("");
            Node root = constructAST(postfix);
            String treeString = constructASTString(root, "");
            System.out.println(treeString);
            return treeString;
        }
    
}
    
   
  

 





   
