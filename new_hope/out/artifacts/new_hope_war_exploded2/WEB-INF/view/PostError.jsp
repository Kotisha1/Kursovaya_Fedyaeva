<%--
  Created by IntelliJ IDEA.
  User: Муся
  Date: 21.04.2020
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Error</title>
  </head>
  <style type="text/css">
          .blockEr {
          align: center
          width: 70%;
          height: 150px;
          padding: 5px;
          padding-right: 20px;
          border: solid 2px red;
          }
          </style>
        </head>
    <body>
        <div class="blockEr" >
         <h2 align=center>Error! This table field is used in table "Contract".</h2>
         <h2 align=center>Please delete the table field in table "Contract" where the ID of the client being deleted is used.</h2>
        </div>

           <h3><a href="http://localhost:8080/posts">Go back</a></h3>
    </body>
  </html>