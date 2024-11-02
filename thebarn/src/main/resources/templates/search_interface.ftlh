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
                    <button class="btn-submit"><i class="fa-solid fa-magnifying-glass btn-submit"></i></button>
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- option 1 checkbox -->
                    <input type="checkbox" class="checkbox" name="option1">
                    <label class="checkbox-label">üsző</label>
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- option 2 checkbox -->
                    <input type="checkbox" class="checkbox" name="option2">
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
                        <option value="${type.id}}">${type.name}</option>
                        </#list>
                    </select>
                </div>
                <div class="col-sm-1 search-header-generic">
                    <!-- new button -->
                    <div>
                        <button class="btn-new"><i class="fa-solid fa-plus btn-new-label"></i></button>
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
                <!-- table rows -->
                 <!-- todo: 'sex' is boolean but what do 0 and 1 refer to exactly? (temp: 1-üsző, 0-bika) -->
                 <!-- todo: állattartó neve = Users.UserId / Farms.FarmName ? -->
                 <!-- todo: shorten dynamic values longer than x characters -->
                <#list animals as animal>
                <div class="row table-row">
                    <div class="col-sm-2">
                        ${animal.id}
                    </div>
                    <div class="col-sm-2">
                        ${animal.farmId.farmName}
                    </div>
                    <div class="col-sm-2">
                        ${animal.farmId.id}
                    </div>
                    <div class="col-sm-2">
                        ${animal.birthDate}
                    </div>
                    <div class="col-sm-1">
                        ${animal.sex?string('üsző','bika')}
                    </div>
                    <div class="col-sm-2">
                        ${animal.breed}
                    </div>
                    <div class="col-sm-1">
                        ${animal.type}
                    </div>
                </div>
                <#else>
                    <div>
                        nincs találat
                    </div>
                </#list>
                <!-- row end -->
                </div>
            </div>
        </div>

        <#if error??>
            <div style="color: red; margin-top: 10px;">${error}</div>
        </#if>
    </body>
</html>