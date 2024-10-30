<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Regisztráció</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 400px;
            margin-top: 50px;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 class="text-success mb-3">Regisztráció</h3>
    <hr>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Jelszó:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Regisztráció</button>
        <a href="/login" class="btn btn-outline-secondary ml-2">Vissza a Belépéshez</a>
    </form>
</div>

</body>
</html>
