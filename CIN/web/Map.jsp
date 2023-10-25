<%@page import="foncier.Propriete"%>
<%
    Propriete[] props = (Propriete[]) request.getAttribute("propriete");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Les Proprieters</title>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
    <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>

    <style>
        /* Style pour d�finir la taille de la carte */
        #map {
            height: 400px;
            width: 100%;
        }
    </style>
</head>
<body>
 <div id="map"></div>
<script>
    var map = L.map('map').setView([<%= props[0].getLongitude()%>, <%= props[0].getLatitude()%>], 14); // Centrez la carte sur les coordonn�es sp�cifi�es

    var tileLayer = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
    }).addTo(map);
        var boundaryCoordinates = [
        <%
            for (Propriete data : props) {
        %>
            [<%= data.getLongitude()%>, <%= data.getLatitude()%>], 
        <% }%>
    ];

    // Cr�ez un polygone en utilisant les coordonn�es des bornes
    var polygon = L.polygon(boundaryCoordinates, { color: 'blue' }).addTo(map);
    var marker = L.marker([-18.97930936407922, 47.54333487558698]).addTo(map);
//    marker.bindPopup("Ceci est un popup.").openPopup();
</script>
</body>
</html>
