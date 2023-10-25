<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }

        form {
            max-width: 450px;
            max-height: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"] {
            width: 95%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            outline: none;
        }

        input[type="text"]:focus {
            border-color: #007BFF;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #76a893;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4c7263;
        }
    </style>
</head>
<body>
    <h1>Insérer votre numéro CIN</h1>
    <form action="TraitementCode" method="post">
        <Label>Numéro CIN</Label>
        <input type="text" name="cin" placeholder="101 000 000 000 000" id="">
        <input type="submit" value="Valider">
    </form>
</body>
</html>

