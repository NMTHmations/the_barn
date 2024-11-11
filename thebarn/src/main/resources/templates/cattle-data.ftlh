<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="/css/cattle_data.css" rel="stylesheet">
    <title>The Barn Cattle Data</title>
</head>
<body class="text-center">
    <main class="form-signin">
        <button type="button"
                    class="btn btn-primary"
                    onclick="document.location='search_interface'"
                    style="background-color: rgb(128,128,128);
                    border-color: rgb(128,128,128);
                    float: inline-start;
                    margin-bottom: 15px;
                    margin-left: 5px;">
            vissza
        </button>
        <button type="button"
                    class="btn btn-outline-primary"
                    onclick="document.location='medical_history_search'"
                    style="border: 2px solid rgb(128,128,128);
                    color: rgb(128,128,128);
                    margin-bottom: 15px;">
                kórelőzmény
        </button>
        <button type="button"
                    class="btn btn-primary"
                    onclick="document.location='cattle_edit'"
                    style="background-color: rgb(128,128,128);
                    border-color: rgb(128,128,128);
                    float: inline-end;
                    margin-bottom: 15px;
                    margin-right: 5px;">
            módosítás
        </button>
        <div class="form">
            <h1>Szarvasmarha ${id}</h1>
            <div class="form-group">
                <p class="label">neme [sex]:</p>
                <p class="data">${sex}</p>
            </div>
            <div class="form-group">
                <p class="label">faja,fajtája [breed]:</p>
                <p class="data">${breed}</p>
            </div>
            <div class="form-group">
                <p class="label">típusa [type]:</p>
                <p class="data">${type}</p>
            </div>
            <div class="form-group">
                <p class="label">színe [colour]:</p>
                <p class="data">${colour}</p>
            </div>
            <div class="form-group">
                <p class="label">születési dátuma [date of birth]:</p>
                <p class="data">${birthDate}</p>
            </div>
            <div class="form-group">
                <p class="label">halál dátuma [date of death]:</p>
                <p class="data">${deathDate}</p>
            </div>
            <div class="form-group">
                <p class="label">előző (külföldi) azonosító<br>[previous (foreign) countrycode, number]:</p>
                <p class="data">${prevId}</p>
            </div>
            <div class="form-group">
                <p class="label">anya/recipiens azonosító<br>[dam's/recipient's number]:</p>
                <p class="data">${motherId}</p>
            </div>
            <div class="form-group">
                <p class="label">apa/recipiens azonosító<br>[sire's/recipient's number]:</p>
                <p class="data">${fatherId}</p>
            </div>
            <div class="form-group">
                <p class="label">Állattartó [Animal keeper]:</p>
                <p class="data">${farmName}</p>
            </div>
            <div class="form-group">
                <p class="label">Tenyészet kódja [Holding code]:</p>
                <p class="data">${farmId}</p>
            </div>
            <div class="form-group">
                <p class="label">címe [adress]:</p>
                <p class="data">${ZIPCode} ${settlement} ${street} ${streetNumber}</p>
            </div>
            <div class="form-group" style="align-items: flex-start;">
                <p class="label">ivadék(ok) azonosítója<br>[offspring(s) number]:</p>
                <ul class="list-unstyled">
                    <#if offspringsIds?size == 1 && offspringsIds[0] == "-">
                        <li>-</li>
                    <#else>
                        <#list offspringsIds as offspringsId>
                            <li>
                                <a href="/cattle-data/${offspringsId}">${offspringsId}</a>
                            </li>
                        </#list>
                    </#if>
                </ul>
            </div>
        </div>
    </main>
</body>
</html>