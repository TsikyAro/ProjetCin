<%@page import="foncier.TypeTerrain"%>
<%
    TypeTerrain[] types = (TypeTerrain[]) request.getAttribute("type");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion Terrain</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            margin: 0 auto;
            max-width: 400px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        select, input[type="text"], input[type="date"] {
            width: 90%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #76a893;
            color: #fff;
            padding: 10px 70px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4c7263;
        }
    </style>
</head>
<body>
   
    <form action="TerrainController" method="post">
         <h1>Insertion Operation</h1>
        <label for="type">Inserer type Terrain</label>
        <select name="type" id="type">
            <option>Choisir le type de Terrain</option>
            <% for(int i = 0; i < types.length; i++) { %>
                <option value="<%= types[i].getIdTypeTerrain()%>"><%= types[i].getNomType()%></option>
            <% } %>
        </select>

        <label for="localisation">Localisation</label>
        <input type="text" name="localisation" id="localisation">

        <label for="prix">Prix</label>
        <input type="text" name="prix" id="prix">

        <label for="superficie">Superficie</label>
        <input type="text" name="superficie" id="superficie">

        <label for="date">Date de Traitement</label>
        <input type="date" name="date" id="date">

        <input type="submit" value="Valider">
    </form>
</body>
</html>
