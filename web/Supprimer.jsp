<%-- 
    Document   : Supprimer
    Created on : 28 mai 2013, 19:29:42
    Author     : Maxime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supprimer operateur</title>
   <form name="Supprimer" action="ServletSupprimer" method="post">           
                   <input type="text" name="IdOperateurSupprimer">
                   <input type="submit" name="Supprimer" value="Supprimer">
    </form>
</html>
