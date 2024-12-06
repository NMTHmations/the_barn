<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tenyészet regisztráció</title>
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
    <h3 class="text-success mb-3">Tenyészet regisztráció</h3>
    <hr>
    <form action="/farm-registration" method="POST">
        <div class="form-group">
            <label for="Username">Felhasználónév:</label>
            <input type="text" class="form-control" id="Username" name="Username" required>
        </div>
        <div class="form-group">
            <label for="password">Jelszó:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="farmId">Tenyészetkód:</label>
            <input type="text" class="form-control" id="farmId" name="farmId" required>
        </div>
        <div class="form-group">
            <label for="FarmName">Tenyészet Neve:</label>
            <input type="text" class="form-control" id="FarmName" name="FarmName" required>
        </div>
        <div class="form-group">
            <label for="ZIPCode">Irányítószám:</label>
            <input type="text" class="form-control" id="ZIPCode" name="ZIPCode" required>
        </div>
        <div class="form-group">
            <label for="Settlement">Település:</label>
            <input type="text" class="form-control" id="Settlement" name="Settlement" required>
        </div>
        <div class="form-group">
            <label for="Street">Utca:</label>
            <input type="text" class="form-control" id="Street" name="Street" required>
        </div>
        <div class="form-group">
            <label for="StreetNumber">Házszám:</label>
            <input type="text" class="form-control" id="StreetNumber" name="StreetNumber" required>
        </div>
        <button type="submit" class="btn btn-primary">Regisztráció</button>
        <a href="/" class="btn btn-outline-secondary ml-2">Vissza a főoldalra</a>
    </form>
</div>

</body>
</html>
