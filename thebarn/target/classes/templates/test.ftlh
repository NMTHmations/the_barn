<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Animals List</title>
</head>
<body>
    <h1>List of Animals</h1>
    <ul>
        <#list animalsList as animal>
            <li>
                <a href="/cattle-data/${animal.id}">${animal.id}</a>
            </li>
        </#list>
    </ul>
</body>
</html>
