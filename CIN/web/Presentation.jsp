<%@page import="foncier.Foncier"%>
<%@page import="model.Operation"%>
<%@page import="personne.Sante"%>
<%@page import="personne.Olona"%>
<%
    Olona olona=(Olona)request.getAttribute("Olona");
    Sante sante =(Sante) request.getAttribute("sante");
    Operation [] opera = (Operation[]) request.getAttribute("operation");
    Foncier[] foncier = (Foncier[])request.getAttribute("foncier");
   String cin = (String) request.getAttribute("cin");
%>
<!DOCTYPE html>
<html>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .header {
            background-color: #76a893;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 28px;
            color: #333;
            margin: 0;
        }

        h2 {
            font-size: 24px;
            color: #76a893;
            margin-top: 20px;
        }

        h3 {
            font-size: 20px;
            color: #333;
            margin-top: 10px;
        }

        .medical-info {
            background-color: #fff;
            padding: 20px;
            margin-top: 20px;
            border-radius:10px;
            width:300px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-left:7%;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        ul li {
            margin-bottom: 10px;
        }

        span {
            color: #76a893;
        }
        .operation{
            display:flex;
        }
    </style>
<body>
    <div class="header">
        <h1>Information</h1>
    </div>
    <div class="container">
        <h2>Numéro CIN: <span><%= cin %></span></h2>
        <h3>Nom: <span><%= olona.getNom() %></span></h3>
        <h3>Prénom: <span><%= olona.getPrenom() %></span></h3>
        <h3>Date de naissance: <span><%= olona.getDtn() %></span></h3>
        <h3>Adresse: <span><%= olona.getAdresse() %></span></h3>
    </div>
    <div class="operation">
        <div class="medical-info">
            <h2>Résultat Médical</h2>
            <h3>Hérédité: <span><%= sante.getNomMaladie() %></span></h3>
            <h3>Opérations:</h3>
            <ul>
                <li>Nom de l'opération: <span><%= sante.getNomOperation() %></span></li>
                <li>Dépense: <span><%= sante.getDepense() %></span></li>
                <li>Date de traitement: <span><%= sante.getDatedetraitement() %></span></li>
            </ul>
        </div>
        <div class="medical-info">
            <h2>Résultat Bancaire</h2>
            <h3>Opérations:</h3>
            <ul>
                <%for(int i =0; i<opera.length; i++){%>
                    <li>Transaction: <span><%= opera[i].getNomTransaction()%></span></li>
                    <li>Montant: <span><%= opera[i].getMontant() %></span></li>
                    <li>Date de traitement: <span><%= opera[i].getDates()%></span></li>
                                <h3>**********************</h3>
                <%}%>
            </ul>
            <a href="AffichageTransaction">Inserer des Transactions</a>
        </div>
        <div class="medical-info">
            <h2>Résultat Foncier</h2>
            <h3>Opérations:</h3>
            <ul>
                <%for(int i =0; i<foncier.length; i++){%>
                    <li>Localisation: <span><%= foncier[i].getLocalisation()%></span></li>
                    <li>Superficie: <span><%= foncier[i].getSuperficie()%></span></li>
                    <li>Prix: <span><%= foncier[i].getPrix()%></span></li>
                    <a href="AfficheMap?idTerrain=<%=foncier[i].getIdTerrain()%>">Voir sur le Map</a>
                                <h3>**********************</h3>
                <%}%>
            </ul>
            <a href="TerrainController">Inserer Proprietes</a>
        </div>
    </div>
</body>
</html>

