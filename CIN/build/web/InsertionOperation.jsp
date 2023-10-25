<%@page import="devise.Devise"%>
<%@page import="model.Transactions"%>
<%
    Transactions[] trans = (Transactions[]) request.getAttribute("transaction");
    String cin =(String)request.getAttribute("cin");
    Devise [] devise =(Devise[])request.getAttribute("devise");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion Operation</title>
</head>
<body>
    <h1>Insertion Operation</h1>
    <form action="TraitementOperation" method="post">
        <label for="">Inserer Type Operation</label>
        <select name="transaction" id="">
            <option>Choisir le type de Transaction</option>
            <% for(int i =0; i<trans.length;i++){%>
             <option value="<%= trans[i].getIdTransactions()%>"> <%= trans[i].getNomTransactions()%> </option>
             <% }%>
        </select>
        <br>
        <label for="devise">Inserer Type Devise</label>
        <select name="devise" id="">
            <option>Choisir le type de Devise</option>
            <% for(int i =0; i<devise.length;i++){%>
             <option value="<%= devise[i].getIdDevise()%>"> <%= devise[i].getNomDevise()%> </option>
             <% }%>
        </select>
        <br>        <br>

        <label for="">Cin de l'envoyeur</label>
        <input type="text" name="cinE" id="">
        <input type="hidden" name="cinR" value="<%= cin%>">
        <br>        <br>

        <label for="">Montant</label>
        <input type="number" name="montant" id="">
        <br>        <br>

        <label for="">Date</label>
        <input type="datetime-local" name="dates" id="">
        <br>        <br>

        <input type="submit" value="Valider">
    </form>
    
</body>
</html>