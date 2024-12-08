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
        .strength-meter {
            font-size: 0.9em;
            margin-top: 5px;
        }
        .strength-meter span {
            display: block;
        }
        .strength-meter .weak {
            color: red;
        }
        .strength-meter .medium {
            color: orange;
        }
        .strength-meter .strong {
            color: green;
        }
    </style>
</head>
<body>

<div class="container">
    <h3 class="text-success mb-3">Telepítés - Regisztráció</h3>
    <hr>
    <!-- Hibaüzenet csak akkor jelenik meg, ha a felhasználó próbálkozott a regisztrációval -->
    <#if attempted?? && attempted == true>
    <#if error??>
        <div class="alert alert-danger">${error}</div>
    </#if>
    </#if>
    <form action="/register" method="POST">
        <div class="form-group">
            <label for="email">E-mail:</label>
            <input type="email" class="form-control" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="password">Jelszó:</label>
            <input type="password" class="form-control" id="password" name="password" required>
            <div id="password-strength" class="strength-meter"></div>
        </div>
        <button type="submit" class="btn btn-primary">Regisztráció</button>
    </form>
</div>



<script>
    const passwordInput = document.getElementById('password');
    const strengthMeter = document.getElementById('password-strength');

    passwordInput.addEventListener('input', () => {
        const password = passwordInput.value;
        let strength = checkPasswordStrength(password);
        updateStrengthMeter(strength);
    });

    function checkPasswordStrength(password) {
        const strongRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*(),.?":{}|<>])[A-Za-z\d!@#$%^&*(),.?":{}|<>]{8,}$/;
        const mediumRegex = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d!@#$%^&*(),.?":{}|<>]{6,}$/;

        if (strongRegex.test(password)) {
            return 'strong';
        } else if (mediumRegex.test(password)) {
            return 'medium';
        } else {
            return 'weak';
        }
    }

    function updateStrengthMeter(strength) {
        strengthMeter.innerHTML = '';

        let strengthText = document.createElement('span');
        if (strength === 'strong') {
            strengthText.textContent = 'Erős jelszó';
            strengthText.classList.add('strong');
        } else if (strength === 'medium') {
            strengthText.textContent = 'Közepes jelszó';
            strengthText.classList.add('medium');
        } else {
            strengthText.textContent = 'Gyenge jelszó';
            strengthText.classList.add('weak');
        }

        strengthMeter.appendChild(strengthText);
    }
</script>

</body>
</html>
