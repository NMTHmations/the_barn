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
    <form action="/disease_registration" method="post">
        <h1>Betegség Regisztráció</h1>
        <div class="form-group">
            <label for="floatingAnimalId">Állat azonosító [Animal ID]:</label>
            <input type="text" id="floatingAnimalId" name="animalId" style="width: 400px;" required>
        </div>
        <div class="form-group">
            <label for="floatingDiseaseType">Betegség típusa [Disease Type]:</label>
            <select id="floatingDiseaseType" name="diseaseType" required>
                <option value="1">Tuberkulózis</option>
                <option value="2">Paratuberkulózis</option>
                <option value="3">Brucellózis</option>
                <option value="4">Lépfene</option>
                <option value="5">Panaritium</option>
                <option value="6">Szalmonellózis</option>
                <option value="7">Gangraena emphysematosa</option>
                <option value="8">Száj- és körömfájás</option>
                <option value="9">IBR/IPV</option>
                <option value="10">BVD/MD</option>
                <option value="11">Trichophytia</option>
                <option value="12">Ketózis</option>
                <option value="13">Tetánia</option>
                <option value="14">Hipokalcémia</option>
                <option value="15">Tüdőféreg</option>
                <option value="16">Ascaridida</option>
                <option value="17">Dicrocoelium dendriticum</option>
                <option value="18">Clonorchis sinensis</option>
                <option value="19">Kokcidiák</option>
                <option value="20">A hálózatos gyomor idegentest betegsége</option>
                <option value="21">Egyéb idegentest betegség</option>
                <option value="22">Felfúvódás</option>
                <option value="23">A bendő elmozdulása</option>
                <option value="24">Kéknyelv</option>
                <option value="25">Kergemarha-kór (BSE)</option>
                <option value="26">Tarlós-sömör</option>
                <option value="27">Egyéb</option>
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
