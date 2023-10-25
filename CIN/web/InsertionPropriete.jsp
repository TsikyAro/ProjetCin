<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insertion Nouvelle Propriete</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            margin-top: 10px;
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            margin: 0 auto;
            max-width: 600px;       
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        .form-row {
            display: flex;
            justify-content: space-between;
        }

        input[type="text"] {
            flex: 1;
            padding: 10px;
            margin-left: 10px;
            border-left:none;
            border-top:none;
            border-right:none;
            border-radius: 3px;
        }

        input[type="submit"] {
            margin-left:40%;
            background-color:#76a893;
            color: #fff;
            padding: 10px 50px;
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
    
    <form action="InsertionPropriete" method="POST">
        <h1>Insertion Nouvelle Propriete</h1>
        <div class="form-row">
            <label for="borne1">Borne1</label>
            <input type="text" name="longitude1" placeholder="Longitude">
            <input type="text" name="latitude1" placeholder="Latitude">
            <!--<input type="submit" value="Insérer">-->
        </div>
        <br> <br>
        <div class="form-row">
            <label for="borne1">Borne2</label>
            <input type="text" name="longitude2" placeholder="Longitude">
            <input type="text" name="latitude2" placeholder="Latitude">
        </div>
        <br> <br>
        <div class="form-row">
            <label for="borne1">Borne3</label>
            <input type="text" name="longitude3" placeholder="Longitude">
            <input type="text" name="latitude3" placeholder="Latitude">
        </div>
        <br> <br>
        <input type="submit" value="Insérer">
    </form>
</body>
</html>
