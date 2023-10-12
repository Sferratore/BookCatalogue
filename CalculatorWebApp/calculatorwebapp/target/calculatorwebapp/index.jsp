<html>
<body>
<h2>Calculator</h2>

<form action="Calculate" method="GET"> <!--Do not do "/Calculate" otherwise standard url of the project gets rewritten from localhost.-->
    <label for="number1">Number 1:</label>
    <input type="number" id="number1" name="number1"><br><br>

    <label for="number2">Number 2:</label>
    <input type="number" id="number2" name="number2"><br><br>

    <label for="operation">Choose operation:</label>
    <select id="operation" name="operation">
        <option value="sum">Sum</option>
        <option value="subt">Subtraction</option>
        <option value="mult">Multiplication</option>
        <option value="split">Division</option>
    </select><br><br>

    <input type="submit" value="Calculate">
</form>
</body>
</html>
