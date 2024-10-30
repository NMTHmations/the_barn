<!DOCTYPE html>
<html  lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="css/login.css" rel="stylesheet">
    <title>The Barn Login</title>
</head>
<body class="text-center">
<main class="form-signin">
    <form action="/login" method="post" style="width: 375px;">
        <h1>BELÉPÉS</h1>
        <div class="form-floating">
            <input type="text" id="floatingInput" name="Email" style="width: 70%; float: inline-end;">
            <label for="floatingInput" style="padding-left: 0; float: inline-start;">E-mail:</label>
        </div>
        <div class="form-floating">
            <input type="password" id="floatingPassword" name="Password" style="width: 70%; float: inline-end;">
            <label for="floatingPassword" style="padding-left: 0; float: inline-start; margin-top: 54px;">Jelszó:</label>
        </div>
        <button type="submit"
                class="btn btn-primary"
                style="background-color: rgb(29,72,114);
                               border-color: rgb(29,72,114);
                               float: inline-start;
                               margin-top: 57px;">
            Belépés
        </button>
    </form>
    <div style="content: '';  clear: both; display: table;"></div>
    <#if error??>
        <div style="color: red; margin-top: 10px;">${error}</div>
    </#if>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
