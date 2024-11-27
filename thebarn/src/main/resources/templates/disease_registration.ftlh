<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="/css/cattle_registration.css" rel="stylesheet">
    <title>Betegség Regisztráció</title>
</head>
<body class="text-center">
<main class="form-signin">
    <form action="/disease-registration" method="post">
        <h1>Betegség Regisztráció</h1>
        <div class="form-group">
            <label for="floatingAnimalId">Állat azonosító [Animal ID]:</label>
            <select id="floatingAnimalId" name="animalId" required>
                <#list animals as animal>
                <option value="${animal.id}">${animal.name} (${animal.id})</option>
            </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="floatingDiseaseType">Betegség típusa [Disease Type]:</label>
            <select id="floatingDiseaseType" name="diseaseType" required>
                <#list diseaseTypes as diseaseType>
                <option value="${diseaseType.id}">${diseaseType.name}</option>
            </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="floatingDate">Dátum [Date]:</label>
            <input type="date" id="floatingDate" name="date" required>
        </div>
        <div class="form-group">
            <label for="floatingDescription">Leírás [Description]:</label>
            <textarea id="floatingDescription" name="description" style="width: 400px;" rows="3"></textarea>
        </div>
        <button type="button"
                class="btn btn-outline-primary"
                onclick="document.location='/'"
                style="border: 2px solid rgb(128,128,128);
                    color: rgb(128,128,128);
                    float: inline-start;
                    margin-top: 15px;">
            Mégse
        </button>
        <button type="submit"
                class="btn btn-primary"
                style="background-color: rgb(128,128,128);
                    border-color: rgb(128,128,128);
                    float: inline-end;
                    margin-top: 15px;">
            Mentés
        </button>
    </form>
</main>
</body>
</html>
