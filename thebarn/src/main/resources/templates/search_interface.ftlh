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
                        <option value="######">######</option>
                    </select>
                </div>
                <div class="col-sm-2 search-header-generic">
                    <!--type dropdown options-->
                    <select name="type" class="dropdown-generic">
                        <option value="all" selected>minden típus</option>
                        <option value="######">######</option>
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
                <!-- table row -->
                    <#assign n = rowCount>
                    <#if rowCount==0>
                    	nincs találat
                    </#if>
                    <#list 0..<n as i>
                    <div class="row table-row">
                        <div class="col-sm-2">
                            animalID
                        </div>
                        <div class="col-sm-2">
                            animalKeeper
                        </div>
                        <div class="col-sm-2">
                            farmID
                        </div>
                        <div class="col-sm-2">
                            birthDate
                        </div>
                        <div class="col-sm-1">
                            sex
                        </div>
                        <div class="col-sm-2">
                            breed
                        </div>
                        <div class="col-sm-1">
                            type
                        </div>
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