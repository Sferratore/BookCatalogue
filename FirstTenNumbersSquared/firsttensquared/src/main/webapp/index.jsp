<!DOCTYPE html>
<html>
<head>
    <title>Number Squared Table</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px 12px;
        }
    </style>
</head>
<body>
    <% 
        int squared;
    %>
    <table>
        <thead>
            <tr>
                <th>Number</th>
                <th>Squared</th>
            </tr>
        </thead>
        <tbody>
            <%
                for(int i=1; i!=11; i++){
                    squared = i*i;
            %>
                    <tr>
                        <td><%=i%></td>
                        <td><%=squared%></td>
                    </tr>
            <%
                }
            %>

        </tbody>
    </table>
</body>
</html>
