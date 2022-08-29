<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Simple Directory Web App</title>
        <link rel="stylesheet" type="text/css"href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css"href="webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    </head>
    <body>
        <div class="container theme-showcase" role="main">
            <div class="jumbotron">
                <h1>Timekeeping</h1>
                <p>A simple Rest API Spring MVC application</p>
            </div>
            <div class="page-header">
                <h1>API</h1>
                <ul>
                    <li><a href="api/states">Current States</a></li>
                    <li><a href="api/categories">Current categories</a></li>
                    <li><a href="api/users">Current users</a></li>
                    <li><a href="api/administrators">Current Administrators</a></li>
                    <li><a href="api/clients">Current Clients</a></li>
                    <li><a href="api/activities">Current Activities</a></li>
                </ul>
            </div>
        </div>
    </body>
</html>