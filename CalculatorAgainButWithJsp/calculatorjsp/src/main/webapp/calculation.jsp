<html>
    <head></head>
    <body>
        <%
            String operation = request.getParameter("operation");
            int num1 = Integer.parseInt(request.getParameter("number1"));
            int num2 = Integer.parseInt(request.getParameter("number2"));
            String result;
            try{
                if(operation.equals("sum")){
                    result = String.valueOf(num1 + num2);
                }
                else if(operation.equals("subt")){
                    result = String.valueOf(num1 - num2);
                }
                else if(operation.equals("mult")){
                    result = String.valueOf(num1 * num2);
                }
                else if(operation.equals("split")){
                    result = String.valueOf(num1 / num2);
                }
                else{
                    throw new IllegalArgumentException("Invalid operation specified: " + operation);
                }
            }
            catch(ArithmeticException e){
                result = "Have you just tried to divide by zero or something? :-P";
            }
            catch(NumberFormatException e) {
                result = "Please enter valid numbers.";
            }
            catch(IllegalArgumentException e) {
                result = e.getMessage();
            }
        %>

        <h2>Result: <%=result%></h2>

    </body>
</html>
