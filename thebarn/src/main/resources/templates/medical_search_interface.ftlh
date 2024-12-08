<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/medical_search_interface.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/19314415a0.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <form action="" method="post">
            <div class="container-fluid">
                <!--page header-->
                <div class="row search-header">
                    <div class="col-sm-7 search-header-generic search-header-searchbar">
                        <!--searchbar-->
                        <input type="search" class="searchbar" placeholder="keresés" name="query">
                        <!-- submit (search) button -->
                        <button class="btn-submit"><i class="fa-solid fa-magnifying-glass btn-submit"></i></button>
                    </div>
                    <div class="col-sm-3 search-header-generic">
                        <!--disease dropdown-->
                        <select name="disease" class="dropdown-generic">
                            <option value="all" selected>minden betegség</option>
                            <#list diseaseTypes as diseaseType>
                            <option value="${diseaseType.id}">${diseaseType.diseasetypename}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="col-sm-1 search-header-generic">
                        <!-- dropdown menu -->
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-solid fa-plus"></i></button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" id="disease-search" href="../">Állományadatok</a>
                                <a class="dropdown-item" id="disease-registration" href="../disease_registration">Betegség hozzáadása</a>
                                <#if holding??>
                                    <a class="dropdown-item" id="farm-registration" href="../farm-registration">${holding}</a>
                                </#if>
                                <a class="dropdown-item" id="cattle-registration" href="../cattle_registration">Állat hozzáadása</a>
                                <a class="dropdown-item" id="logout" href="../logout">Kijelentkezés</a>
                                <div class="dropdown-divider"></div>
                                <p class="dropdown-item disabled">Helló, itt ${username!"username"}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div class="container-fluid main-body">
            <div class="container-fluid table-body">
                <!--table header-->
                <div class="row table-header">
                    <div class="col-sm-2">
                        Egyedazonosító
                    </div>
                    <div class="col-sm-2">
                        Állattartó neve
                    </div>
                    <div class="col-sm-2">
                        Tenyészet kódja
                    </div>
                    <div class="col-sm-2">
                        dátum
                    </div>
                    <div class="col-sm-2">
                        betegség típus
                    </div>
                    <div class="col-sm-2">
                        leírás
                    </div>
                </div>

                <!--table rows (search results)-->
                <#list diseaseLogs as diseaseLog>
                <div class="row table-row">
                    <div class="col-sm-2">
                        ${diseaseLog.animalid.id}
                    </div>
                    <div class="col-sm-2">
                        ${diseaseLog.animalid.farmid.farmName}
                    </div>
                    <div class="col-sm-2">
                        ${diseaseLog.animalid.farmid.id}
                    </div>
                    <div class="col-sm-2">
                        ${diseaseLog.date}
                    </div>
                    <div class="col-sm-2">
                        ${diseaseLog.diseaseTypes.diseasetypename}
                    </div>
                    <div class="col-sm-2">
                        ${diseaseLog.description}
                    </div>
                </div>
                <#else>
                    <div>
                        nincs találat
                    </div>
                </#list>
                <!-- end of rows -->
            </div>
        </div>

        <#if error??>
            <div style="color: red; margin-top: 10px;">${error}</div>
        </#if>
    </body>
</html>