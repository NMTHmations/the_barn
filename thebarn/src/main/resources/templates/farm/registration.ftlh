<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Farm Registration</title>
    <style>
        body {
            font-family: "Open Sans", "Arial", sans-serif;
            display: flex;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
            margin: 0;
        }

        .form-register {
            width: 100%;
            max-width: 800px;
            padding: 20px;
            margin: auto;
            background-color: #ffffff;
            border: 2px solid #808080;
            border-radius: 20px;
        }

        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .form-group label {
            width: 250px;
            text-align: left;
            margin-right: 15px;
            font-size: 15px;
            color: #000;
        }

        .form-group input {
            flex-grow: 1;
            padding: 5px;
            border: 1px solid #b2afaf;
            border-radius: 3px;
            font-size: 15px;
        }

        button {
            margin-top: 15px;
        }

        .error-message {
            color: red;
            font-size: 0.9em;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<main class="form-register">
    <form id="farmForm" action="/farm-registration" method="post">
        <h1 class="text-center">Tenyészet Regisztráció</h1>

        <#-- Hibaüzenet megjelenítése -->
        <#if errorMessage??>
        <div class="error-message">${errorMessage}</div>
        </#if>

        <div class="form-group">
            <label for="floatingSelfId">Tenyészetkód:</label>
            <input type="text" id="floatingSelfId" name="farmId" required>
        </div>
        <div class="form-group">
            <label for="farmName">Tenyészet Jogi Neve:</label>
            <input type="text" id="farmName" name="farmName" required>
        </div>
        <div class="form-group">
            <label for="zipCode">Irányítószám:</label>
            <input type="number" id="zipCode" name="zipCode" required>
        </div>
        <div class="form-group">
            <label for="settlement">Település:</label>
            <input type="text" id="settlement" name="settlement" required>
        </div>
        <div class="form-group">
            <label for="street">Utca:</label>
            <input type="text" id="street" name="street" required>
        </div>
        <div class="form-group">
            <label for="streetNumber">Házszám:</label>
            <input type="number" id="streetNumber" name="streetNumber" required>
        </div>
        <div class="form-group">
            <label for="username">Felhasználónév:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Jelszó:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="text-center">
            <button type="button" class="btn btn-outline-secondary" onclick="location.href='/'">Mégsem</button>
            <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
    </form>
</main>

<script>
    const farmIdField = document.getElementById('floatingSelfId');
    const farmForm = document.getElementById('farmForm');
    const numberFields = document.querySelectorAll('input[type="number"]');

    farmForm.addEventListener('submit', function (event) {
        const farmIdValue = farmIdField.value;
        const farmIdPattern = /^[A-Z]{2}-\d{5}-\d{5}$/;

        if (!farmIdPattern.test(farmIdValue)) {
            alert("Helytelen tenyészetkód! Helyes formátum: HU-12345-12345");
            event.preventDefault();
        }
    });

    numberFields.forEach(field => {
        field.addEventListener('input', function () {
            field.value = field.value.replace(/[^0-9]/g, '');
        });
    });
</script>
</body>
</html>
