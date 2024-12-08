<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search_interface.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/19314415a0.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <form action="" method="post">
        <div class="container-fluid">
            <!-- page header -->
            <div class="row search-header">
                <div class="col-sm-5 search-header-generic search-header-searchbar">
                    <!-- searchbar -->
                    <input type="search" class="searchbar" placeholder="keresés" name="query">
                    <!-- submit (search) button -->
                    <button id="go-search" class="btn-submit"><i class="fa-solid fa-magnifying-glass btn-submit"></i></button>
                    <!--<input type="submit" value="fa-solid fa-magnifying-glass btn-submit" class="btn-submit">-->
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- option 1 checkbox -->
                    <input type="checkbox" checked class="checkbox" name="option1">
                    <label class="checkbox-label">üsző</label>
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- option 2 checkbox -->
                    <input type="checkbox" checked class="checkbox" name="option2">
                    <label class="checkbox-label">bika</label>
                </div>
                <div class="col-sm-2 search-header-generic">
                    <!--breed dropdown options-->
                    <select name="breed" class="dropdown-generic">
                        <option value="all" selected>minden fajta</option>
                        <#list breeds as breed>
                        <option value="${breed.id}">${breed.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="col-sm-2 search-header-generic">
                    <!--type dropdown options-->
                    <select name="type" class="dropdown-generic">
                        <option value="all" selected>minden típus</option>
                        <#list types as type>
                        <option value="${type.id}">${type.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- dropdown menu -->
                    <div class="btn-group">
                        <button type="button" id="plus_main" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa-solid fa-plus"></i></button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" id="disease-search" href="../medical_search_interface">Kórelőzmény</a>
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
        </form>
            <div class="container-fluid main-body">
                <div class="container-fluid table-body">
                    <!-- table header -->
                    <div class="row table-header">
                        <div class="col-sm-2">
                            ENAR azonosító
                        </div>
                        <div class="col-sm-2">
                            Állattartó neve
                        </div>
                        <div class="col-sm-2">
                            Tenyészet kódja
                        </div>
                        <div class="col-sm-2">
                            születési dátum
                        </div>
                        <div class="col-sm-1">
                            nem
                        </div>
                        <div class="col-sm-2">
                            fajta, fajtája
                        </div>
                        <div class="col-sm-1">
                            típus
                        </div>
                    </div>
                <!-- table rows (search results) -->
                <#list animals as animal>
                <div class="row table-row">
                    <div class="col-sm-2">
                        <a href="/cattle-data/${animal.id}">${animal.id}</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="/cattle-data/${animal.id}">${animal.farmid.farmName}</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="/cattle-data/${animal.id}">${animal.farmid.id}</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="/cattle-data/${animal.id}">${animal.birthDate}</a>
                    </div>
                    <div class="col-sm-1">
                        <a href="/cattle-data/${animal.id}">${animal.sex?string('bika','üsző')}</a>
                    </div>
                    <div class="col-sm-2">
                        <a href="/cattle-data/${animal.id}">${animal.breed.name}</a>
                    </div>
                    <div class="col-sm-1">
                        <a href="/cattle-data/${animal.id}">${animal.type.name}</a>
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
        </div>

        <div>

        </div>

        <#if error??>
            <div style="color: red; margin-top: 10px;">${error}</div>
        </#if>
    </body>
</html>