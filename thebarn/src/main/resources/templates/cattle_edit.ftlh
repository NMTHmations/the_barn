<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="/css/cattle_registration.css" rel="stylesheet">
    <title>The Barn Cattle Edit</title>
</head>
<body class="text-center">
    <main class="form-signin">
        <form action="/cattle_edit/${animalId}" method="post">
            <h1>Szarvasmarha Szerkesztés</h1>
            <div class="form-group">
                <label for="floatingSelfId">saját azonosító [self number]:</label>
                <input type="text" id="floatingSelfId" name="selfId" value="${animalId!}" style="width: 400px; background-color: lightgray;" disabled>
            </div>
            <div class="form-group">
                <label for="floatingSex">neme [sex]:</label>
                <select id="floatingSex" name="sex">
                    <option value="true" <#if animalSex == true>selected</#if>>hímivar (bika) [Male]</option>
                    <option value="false" <#if animalSex == false>selected</#if>>nőivar (üsző) [Female]</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingBreed">faja,fajtája [breed]:</label>
                <select id="floatingBreed" name="breed">
                    <option value="1" <#if animalBreed == 1>selected</#if>>Aberdeen angus</option>
                    <option value="2" <#if animalBreed == 2>selected</#if>>Ankole-Watusi marha</option>
                    <option value="3" <#if animalBreed == 3>selected</#if>>Brahma marha</option>
                    <option value="4" <#if animalBreed == 4>selected</#if>>Dexter</option>
                    <option value="5" <#if animalBreed == 5>selected</#if>>Fekete angus</option>
                    <option value="6" <#if animalBreed == 6>selected</#if>>Galiciai szőke szarvasmarha</option>
                    <option value="7" <#if animalBreed == 7>selected</#if>>Hanu</option>
                    <option value="8" <#if animalBreed == 8>selected</#if>>Hereford marha</option>
                    <option value="9" <#if animalBreed == 9>selected</#if>>Holstein-fríz</option>
                    <option value="10" <#if animalBreed == 10>selected</#if>>Magyar szürke szarvasmarha</option>
                    <option value="11" <#if animalBreed == 11>selected</#if>>Magyar tarka szarvasmarha</option>
                    <option value="12" <#if animalBreed == 12>selected</#if>>Nelore marha</option>
                    <option value="13" <#if animalBreed == 13>selected</#if>>Skót-felföldi marha</option>
                    <option value="14" <#if animalBreed == 14>selected</#if>>Szarv nélküli Hereford marha</option>
                    <option value="15" <#if animalBreed == 15>selected</#if>>Texasi hosszúszarvú marha</option>
                    <option value="16" <#if animalBreed == 16>selected</#if>>Vörös angus</option>
                    <option value="17" <#if animalBreed == 17>selected</#if>>Vörös Holstein-fríz</option>
                    <option value="18" <#if animalBreed == 18>selected</#if>>Abergele marha</option>
                    <option value="19" <#if animalBreed == 19>selected</#if>>Abesszin rövidszarvú zebu</option>
                    <option value="20" <#if animalBreed == 20>selected</#if>>Abigar marha</option>
                    <option value="21" <#if animalBreed == 21>selected</#if>>Abondance marha</option>
                    <option value="22" <#if animalBreed == 22>selected</#if>>Abruzzoi marha</option>
                    <option value="23" <#if animalBreed == 23>selected</#if>>Acehi marha</option>
                    <option value="24" <#if animalBreed == 24>selected</#if>>Achhami marha</option>
                    <option value="25" <#if animalBreed == 25>selected</#if>>Adamawai marha</option>
                    <option value="26" <#if animalBreed == 26>selected</#if>>Adaptaur marha</option>
                    <option value="27" <#if animalBreed == 27>selected</#if>>Afar marha</option>
                    <option value="28" <#if animalBreed == 28>selected</#if>>Africangus marha</option>
                    <option value="29" <#if animalBreed == 29>selected</#if>>Afrikaner marha</option>
                    <option value="30" <#if animalBreed == 30>selected</#if>>Agerolai marha</option>
                    <option value="31" <#if animalBreed == 31>selected</#if>>Alambadi marha</option>
                    <option value="32" <#if animalBreed == 32>selected</#if>>Alataui marha</option>
                    <option value="33" <#if animalBreed == 33>selected</#if>>Albániai marha</option>
                    <option value="34" <#if animalBreed == 34>selected</#if>>Alberai marha</option>
                    <option value="35" <#if animalBreed == 35>selected</#if>>Albioni kék marha</option>
                    <option value="36" <#if animalBreed == 36>selected</#if>>Alderney marha</option>
                    <option value="37" <#if animalBreed == 37>selected</#if>>Alentejana marha</option>
                    <option value="38" <#if animalBreed == 38>selected</#if>>Aleut-szigeteki vadmarha</option>
                    <option value="39" <#if animalBreed == 39>selected</#if>>Aliad Dinka marha</option>
                    <option value="40" <#if animalBreed == 40>selected</#if>>Alistana-Sanabresa marha</option>
                    <option value="41" <#if animalBreed == 41>selected</#if>>Allmogekor marha</option>
                    <option value="42" <#if animalBreed == 42>selected</#if>>Alur marha</option>
                    <option value="43" <#if animalBreed == 43>selected</#if>>Amerifax marha</option>
                    <option value="44" <#if animalBreed == 44>selected</#if>>Amerikai Angus</option>
                    <option value="45" <#if animalBreed == 45>selected</#if>>Amerikai barna svájci marha</option>
                    <option value="46" <#if animalBreed == 46>selected</#if>>Amerikai hús fríz</option>
                    <option value="47" <#if animalBreed == 47>selected</#if>>Amerikai marha</option>
                    <option value="48" <#if animalBreed == 48>selected</#if>>Amerikai rodeó marha</option>
                    <option value="49" <#if animalBreed == 49>selected</#if>>Amerikai tejelő Devon marha</option>
                    <option value="50" <#if animalBreed == 50>selected</#if>>Amerikai White Park marha</option>
                    <option value="51" <#if animalBreed == 51>selected</#if>>Amrit Mahal marha</option>
                    <option value="52" <#if animalBreed == 52>selected</#if>>Hallikar marhából</option>
                    <option value="53" <#if animalBreed == 53>selected</#if>>Amszterdam-szigeti marha</option>
                    <option value="54" <#if animalBreed == 54>selected</#if>>Anatóliai fekete marha</option>
                    <option value="55" <#if animalBreed == 55>selected</#if>>Andalúziai fekete marha</option>
                    <option value="56" <#if animalBreed == 56>selected</#if>>Avileña-Negra Ibérica marhával</option>
                    <option value="57" <#if animalBreed == 57>selected</#if>>Andalúziai szőke marha</option>
                    <option value="58" <#if animalBreed == 58>selected</#if>>Andalúziai szürke marha</option>
                    <option value="59" <#if animalBreed == 59>selected</#if>>Angelni marha</option>
                    <option value="60" <#if animalBreed == 60>selected</#if>>Angol hosszúszarvú marha</option>
                    <option value="61" <#if animalBreed == 61>selected</#if>>Angoni marha</option>
                    <option value="62" <#if animalBreed == 62>selected</#if>>Ankina marha</option>
                    <option value="63" <#if animalBreed == 63>selected</#if>>Ankole marha</option>
                    <option value="64" <#if animalBreed == 64>selected</#if>>Aquitaniai szőke marha</option>
                    <option value="65" <#if animalBreed == 65>selected</#if>>Aracena marha</option>
                    <option value="66" <#if animalBreed == 66>selected</#if>>Arado marha</option>
                    <option value="67" <#if animalBreed == 67>selected</#if>>Argentín Criollo marha</option>
                    <option value="68" <#if animalBreed == 68>selected</#if>>Argentín fríz</option>
                    <option value="69" <#if animalBreed == 69>selected</#if>>Armoricaine marha</option>
                    <option value="70" <#if animalBreed == 70>selected</#if>>Arouquesa marha</option>
                    <option value="71" <#if animalBreed == 71>selected</#if>>Arsi marha</option>
                    <option value="72" <#if animalBreed == 72>selected</#if>>Asztúriai hegyi marha</option>
                    <option value="73" <#if animalBreed == 73>selected</#if>>Asztúriai völgyi marha</option>
                    <option value="74" <#if animalBreed == 74>selected</#if>>Aubraci marha</option>
                    <option value="75" <#if animalBreed == 75>selected</#if>>Aulie-Ata marha</option>
                    <option value="76" <#if animalBreed == 76>selected</#if>>Aure et Saint-Girons marha</option>
                    <option value="77" <#if animalBreed == 77>selected</#if>>Ausztrál Braford</option>
                    <option value="78" <#if animalBreed == 78>selected</#if>>Ausztrál Brangus</option>
                    <option value="79" <#if animalBreed == 79>selected</#if>>Ausztrál Charbray</option>
                    <option value="80" <#if animalBreed == 80>selected</#if>>Ausztrál Lowline marha</option>
                    <option value="81" <#if animalBreed == 81>selected</#if>>Ausztrál rövidszarvú marha</option>
                    <option value="82" <#if animalBreed == 82>selected</#if>>Ausztrál Sahiwal fríz</option>
                    <option value="83" <#if animalBreed == 83>selected</#if>>Ausztrál tejelő zebu</option>
                    <option value="84" <#if animalBreed == 84>selected</#if>>Avétonou marha</option>
                    <option value="85" <#if animalBreed == 85>selected</#if>>Avileña-Negra Ibérica marha</option>
                    <option value="86" <#if animalBreed == 86>selected</#if>>andalúziai fekete marhával</option>
                    <option value="87" <#if animalBreed == 87>selected</#if>>Aweil Dinka marha</option>
                    <option value="88" <#if animalBreed == 88>selected</#if>>Ayrshire marha</option>
                    <option value="89" <#if animalBreed == 89>selected</#if>>Azaouak marha</option>
                    <option value="90" <#if animalBreed == 90>selected</#if>>Azebuado marha</option>
                    <option value="91" <#if animalBreed == 91>selected</#if>>Azerbajdzsáni zebu</option>
                    <option value="92" <#if animalBreed == 92>selected</#if>>Azori-szigeteki marha</option>
                    <option value="93" <#if animalBreed == 93>selected</#if>>Bachaur marha</option>
                    <option value="94" <#if animalBreed == 94>selected</#if>>Baggara marha</option>
                    <option value="95" <#if animalBreed == 95>selected</#if>>Baherie marha</option>
                    <option value="96" <#if animalBreed == 96>selected</#if>>Bakosi marha</option>
                    <option value="97" <#if animalBreed == 97>selected</#if>>Balancer marha</option>
                    <option value="98" <#if animalBreed == 98>selected</#if>>Gelbvieh marha</option>
                    <option value="100" <#if animalBreed == 100>selected</#if>>Baoule marha</option>
                    <option value="101" <#if animalBreed == 101>selected</#if>>Bargur marha</option>
                    <option value="102" <#if animalBreed == 102>selected</#if>>Barna kaukázusi marha</option>
                    <option value="103" <#if animalBreed == 103>selected</#if>>Barna kárpáti marha</option>
                    <option value="104" <#if animalBreed == 104>selected</#if>>Barna svájci marha</option>
                    <option value="105" <#if animalBreed == 105>selected</#if>>Barrosã marha</option>
                    <option value="106" <#if animalBreed == 106>selected</#if>>Barzona marha</option>
                    <option value="107" <#if animalBreed == 107>selected</#if>>Bazadaise marha</option>
                    <option value="108" <#if animalBreed == 108>selected</#if>>Beefalo</option>
                    <option value="109" <#if animalBreed == 109>selected</#if>>Beefmaker marha</option>
                    <option value="110" <#if animalBreed == 110>selected</#if>>Beefmaster marha</option>
                    <option value="111" <#if animalBreed == 111>selected</#if>>Begayt marha</option>
                    <option value="112" <#if animalBreed == 112>selected</#if>>Belga fehér-vörös marha</option>
                    <option value="113" <#if animalBreed == 113>selected</#if>>Belga vörös marha</option>
                    <option value="114" <#if animalBreed == 114>selected</#if>>Belga vörös tarka marha</option>
                    <option value="115" <#if animalBreed == 115>selected</#if>>Belmont vörös marha</option>
                    <option value="116" <#if animalBreed == 116>selected</#if>>Berni marha</option>
                    <option value="117" <#if animalBreed == 117>selected</#if>>Berrenda marha</option>
                    <option value="118" <#if animalBreed == 118>selected</#if>>Bestuzhev marha</option>
                    <option value="119" <#if animalBreed == 119>selected</#if>>Betizu marha</option>
                    <option value="120" <#if animalBreed == 120>selected</#if>>Béarni marha</option>
                    <option value="121" <#if animalBreed == 121>selected</#if>>Blaarkop marha</option>
                    <option value="122" <#if animalBreed == 122>selected</#if>>Blanca Cacereña marha</option>
                    <option value="123" <#if animalBreed == 123>selected</#if>>Blanco Orejinegro BON marha</option>
                    <option value="124" <#if animalBreed == 124>selected</#if>>Bohuskulla marha</option>
                    <option value="125" <#if animalBreed == 125>selected</#if>>Bonsmarai marha</option>
                    <option value="126" <#if animalBreed == 126>selected</#if>>Boran marha</option>
                    <option value="127" <#if animalBreed == 127>selected</#if>>Boškarin marha</option>
                    <option value="128" <#if animalBreed == 128>selected</#if>>Braford marha</option>
                    <option value="129" <#if animalBreed == 129>selected</#if>>Brahmousin marha</option>
                    <option value="130" <#if animalBreed == 130>selected</#if>>Brangus marha</option>
                    <option value="131" <#if animalBreed == 131>selected</#if>>Brava marha</option>
                    <option value="132" <#if animalBreed == 132>selected</#if>>Bretagnei Pie Noir marha</option>
                    <option value="133" <#if animalBreed == 133>selected</#if>>Brit fehér marha</option>
                    <option value="134" <#if animalBreed == 134>selected</#if>>Brit fríz</option>
                    <option value="135" <#if animalBreed == 135>selected</#if>>Buelingo marha</option>
                    <option value="136" <#if animalBreed == 136>selected</#if>>Burlina marha</option>
                    <option value="137" <#if animalBreed == 137>selected</#if>>Buša marha</option>
                    <option value="138" <#if animalBreed == 138>selected</#if>>Bushuyev marha</option>
                    <option value="139" <#if animalBreed == 139>selected</#if>>Butanai marha</option>
                    <option value="140" <#if animalBreed == 140>selected</#if>>Cabannina marha</option>
                    <option value="141" <#if animalBreed == 141>selected</#if>>Cachena marha</option>
                    <option value="142" <#if animalBreed == 142>selected</#if>>Barrosã marhával</option>
                    <option value="143" <#if animalBreed == 143>selected</#if>>Caldelana marha</option>
                    <option value="144" <#if animalBreed == 144>selected</#if>>Calvanai marha</option>
                    <option value="145" <#if animalBreed == 145>selected</#if>>Camargue marha</option>
                    <option value="146" <#if animalBreed == 146>selected</#if>>Campbell-szigeti marha</option>
                    <option value="147" <#if animalBreed == 147>selected</#if>>Canadienne marha</option>
                    <option value="148" <#if animalBreed == 148>selected</#if>>Canaria marha</option>
                    <option value="149" <#if animalBreed == 149>selected</#if>>Canchim marha</option>
                    <option value="150" <#if animalBreed == 150>selected</#if>>Caracu marha</option>
                    <option value="151" <#if animalBreed == 151>selected</#if>>Cárdena Andaluza marha</option>
                    <option value="152" <#if animalBreed == 152>selected</#if>>Charbray marha</option>
                    <option value="153" <#if animalBreed == 153>selected</#if>>Charolais marha</option>
                    <option value="154" <#if animalBreed == 154>selected</#if>>Chateaubriand marha</option>
                    <option value="155" <#if animalBreed == 155>selected</#if>>Chiangus marha</option>
                    <option value="156" <#if animalBreed == 156>selected</#if>>Chianina marha</option>
                    <option value="157" <#if animalBreed == 157>selected</#if>>Chikso marha</option>
                    <option value="158" <#if animalBreed == 158>selected</#if>>Chillinghami marha</option>
                    <option value="159" <#if animalBreed == 159>selected</#if>>Cholistani marha</option>
                    <option value="160" <#if animalBreed == 160>selected</#if>>Cinisara marha</option>
                    <option value="161" <#if animalBreed == 161>selected</#if>>Coloursided White Back marha</option>
                    <option value="162" <#if animalBreed == 162>selected</#if>>Commercial marha</option>
                    <option value="163" <#if animalBreed == 163>selected</#if>>Corriente marha</option>
                    <option value="164" <#if animalBreed == 164>selected</#if>>Costeño con Cuernos marha</option>
                    <option value="165" <#if animalBreed == 165>selected</#if>>Crioulo Lageano marha</option>
                    <option value="166" <#if animalBreed == 166>selected</#if>>Csedzsu-szigeti fekete marha</option>
                    <option value="167" <#if animalBreed == 167>selected</#if>>Dajal marha</option>
                    <option value="168" <#if animalBreed == 168>selected</#if>>Dangi marha</option>
                    <option value="169" <#if animalBreed == 169>selected</#if>>Dán fekete tarka marha</option>
                    <option value="170" <#if animalBreed == 170>selected</#if>>Dán Jersey marha</option>
                    <option value="171" <#if animalBreed == 171>selected</#if>>Dán vörös marha</option>
                    <option value="172" <#if animalBreed == 172>selected</#if>>Deoni marha</option>
                    <option value="173" <#if animalBreed == 173>selected</#if>>Dél-devoni marha</option>
                    <option value="174" <#if animalBreed == 174>selected</#if>>Dhanni marha</option>
                    <option value="175" <#if animalBreed == 175>selected</#if>>Doayo marha</option>
                    <option value="176" <#if animalBreed == 176>selected</#if>>Doela marha</option>
                    <option value="177" <#if animalBreed == 177>selected</#if>>Drakensbergi marha</option>
                    <option value="178" <#if animalBreed == 178>selected</#if>>Droimeann marha</option>
                    <option value="179" <#if animalBreed == 179>selected</#if>>Droughtmaster marha</option>
                    <option value="180" <#if animalBreed == 180>selected</#if>>Dulong marha</option>
                    <option value="181" <#if animalBreed == 181>selected</#if>>Dølafe marha</option>
                    <option value="182" <#if animalBreed == 182>selected</#if>>Dzo</option>
                    <option value="183" <#if animalBreed == 183>selected</#if>>Dzomo</option>
                    <option value="184" <#if animalBreed == 184>selected</#if>>Enderby-szigeti marha</option>
                    <option value="185" <#if animalBreed == 185>selected</#if>>Ennstaler Bergscheck marha</option>
                    <option value="186" <#if animalBreed == 186>selected</#if>>Erdélyi szürke marha</option>
                    <option value="187" <#if animalBreed == 187>selected</#if>>Eredeti svájci marha</option>
                    <option value="188" <#if animalBreed == 188>selected</#if>>Észak-amerikai piemonti marha</option>
                    <option value="189" <#if animalBreed == 189>selected</#if>>Észak-bengáli szürke marha</option>
                    <option value="190" <#if animalBreed == 190>selected</#if>>Észak-devoni marha</option>
                    <option value="191" <#if animalBreed == 191>selected</#if>>Északi finn marha</option>
                    <option value="192" <#if animalBreed == 192>selected</#if>>Északi kék marha</option>
                    <option value="193" <#if animalBreed == 193>selected</#if>>Északi rövidszarvú marha</option>
                    <option value="194" <#if animalBreed == 194>selected</#if>>Észt bennszülött marha</option>
                    <option value="195" <#if animalBreed == 195>selected</#if>>Észt Holstein marha</option>
                    <option value="196" <#if animalBreed == 196>selected</#if>>Észt vörös marha</option>
                    <option value="197" <#if animalBreed == 197>selected</#if>>Évolène marha</option>
                    <option value="198" <#if animalBreed == 198>selected</#if>>Fehér Cáceres marha</option>
                    <option value="199" <#if animalBreed == 199>selected</#if>>Fehérfejű kazah marha</option>
                    <option value="200" <#if animalBreed == 200>selected</#if>>Fehér Fulani marha</option>
                    <option value="201" <#if animalBreed == 201>selected</#if>>Fehér Lamphun marha</option>
                    <option value="202" <#if animalBreed == 202>selected</#if>>Fehérorosz marha</option>
                    <option value="203" <#if animalBreed == 203>selected</#if>>Fehér-kék belga marha</option>
                    <option value="204" <#if animalBreed == 204>selected</#if>>Fehér tenyésztésű rövidszarvú marha</option>
                    <option value="205" <#if animalBreed == 205>selected</#if>>Fekete Baldy marha</option>
                    <option value="206" <#if animalBreed == 206>selected</#if>>Fekete Hereford marha</option>
                    <option value="207" <#if animalBreed == 207>selected</#if>>Feljavított holland vörös-fehér marha</option>
                    <option value="208" <#if animalBreed == 208>selected</#if>>Feljavított vörös-fehér marha</option>
                    <option value="209" <#if animalBreed == 209>selected</#if>>Fenyőerdei marha</option>
                    <option value="210" <#if animalBreed == 210>selected</#if>>Fēng marha</option>
                    <option value="211" <#if animalBreed == 211>selected</#if>>Ferrandaise marha</option>
                    <option value="212" <#if animalBreed == 212>selected</#if>>Finn Ayrshire marha</option>
                    <option value="213" <#if animalBreed == 213>selected</#if>>Finn Holstein-fríz</option>
                    <option value="214" <#if animalBreed == 214>selected</#if>>Finn marha</option>
                    <option value="215" <#if animalBreed == 215>selected</#if>>Fjäll marha</option>
                    <option value="216" <#if animalBreed == 216>selected</#if>>Fleckvieh marha</option>
                    <option value="217" <#if animalBreed == 217>selected</#if>>Floridai kiváló marha</option>
                    <option value="218" <#if animalBreed == 218>selected</#if>>Fogerai marha</option>
                    <option value="219" <#if animalBreed == 219>selected</#if>>Francia szimmentáli marha</option>
                    <option value="220" <#if animalBreed == 220>selected</#if>>Frankeston vörös marha</option>
                    <option value="221" <#if animalBreed == 221>selected</#if>>Fribourgi marha</option>
                    <option value="222" <#if animalBreed == 222>selected</#if>>Fríz húsmarha</option>
                    <option value="223" <#if animalBreed == 223>selected</#if>>Froment du Léon marha</option>
                    <option value="224" <#if animalBreed == 224>selected</#if>>Fülöp-szigeteki marha</option>
                    <option value="225" <#if animalBreed == 225>selected</#if>>Gallowayi marha</option>
                    <option value="226" <#if animalBreed == 226>selected</#if>>Gallowayi öves marha</option>
                    <option value="227" <#if animalBreed == 227>selected</#if>>Gangatiri marha</option>
                    <option value="228" <#if animalBreed == 228>selected</#if>>Gaolao marha</option>
                    <option value="229" <#if animalBreed == 229>selected</#if>>Garfagnina marha</option>
                    <option value="230" <#if animalBreed == 230>selected</#if>>Garvonesa marha</option>
                    <option value="231" <#if animalBreed == 231>selected</#if>>Gasconi marha</option>
                    <option value="233" <#if animalBreed == 233>selected</#if>>Girolando marha</option>
                    <option value="234" <#if animalBreed == 234>selected</#if>>Glamorgai marha</option>
                    <option value="235" <#if animalBreed == 235>selected</#if>>Glan marha</option>
                    <option value="236" <#if animalBreed == 236>selected</#if>>Gloucesteri marha</option>
                    <option value="237" <#if animalBreed == 237>selected</#if>>Gobra marha</option>
                    <option value="238" <#if animalBreed == 238>selected</#if>>Görög rövidszarvú marha</option>
                    <option value="239" <#if animalBreed == 239>selected</#if>>Görög szteppei marha</option>
                    <option value="240" <#if animalBreed == 240>selected</#if>>Greyman marha</option>
                    <option value="241" <#if animalBreed == 241>selected</#if>>Grúz hegyi marha</option>
                    <option value="242" <#if animalBreed == 242>selected</#if>>Gudali marha</option>
                    <option value="243" <#if animalBreed == 243>selected</#if>>Guernseyi marha</option>
                    <option value="244" <#if animalBreed == 244>selected</#if>>Guzerat marha</option>
                    <option value="245" <#if animalBreed == 245>selected</#if>>Gyr marha</option>
                    <option value="246" <#if animalBreed == 246>selected</#if>>Hallikar marha</option>
                    <option value="247" <#if animalBreed == 247>selected</#if>>Harijánai marha</option>
                    <option value="248" <#if animalBreed == 248>selected</#if>>Hartón del Valle marha</option>
                    <option value="249" <#if animalBreed == 249>selected</#if>>Harzi vörös marha</option>
                    <option value="250" <#if animalBreed == 250>selected</#if>>Hawaii vadmarha</option>
                    <option value="251" <#if animalBreed == 251>selected</#if>>Hays Converter marha</option>
                    <option value="252" <#if animalBreed == 252>selected</#if>>Heck-marha</option>
                    <option value="253" <#if animalBreed == 253>selected</#if>>Heugu marha</option>
                    <option value="254" <#if animalBreed == 254>selected</#if>>Hérens-völgyi marha</option>
                    <option value="255" <#if animalBreed == 255>selected</#if>>Hinterwald marha</option>
                    <option value="256" <#if animalBreed == 256>selected</#if>>Holland-argentín marha</option>
                    <option value="257" <#if animalBreed == 257>selected</#if>>Holland fríz</option>
                    <option value="258" <#if animalBreed == 258>selected</#if>>Holland öves marha</option>
                    <option value="259" <#if animalBreed == 259>selected</#if>>Horro marha</option>
                    <option value="260" <#if animalBreed == 260>selected</#if>>Huáng marha</option>
                    <option value="261" <#if animalBreed == 261>selected</#if>>Hybridmaster marha</option>
                    <option value="262" <#if animalBreed == 262>selected</#if>>Ibériai marha</option>
                    <option value="263" <#if animalBreed == 263>selected</#if>>Illawarrai marha</option>
                    <option value="264" <#if animalBreed == 264>selected</#if>>Indobrazíliai marha</option>
                    <option value="265" <#if animalBreed == 265>selected</#if>>Istobeni marha</option>
                    <option value="266" <#if animalBreed == 266>selected</#if>>Isztriai marha</option>
                    <option value="267" <#if animalBreed == 267>selected</#if>>Izlandi marha</option>
                    <option value="268" <#if animalBreed == 268>selected</#if>>Izraeli Holstein marha</option>
                    <option value="269" <#if animalBreed == 269>selected</#if>>Izraeli vörös marha</option>
                    <option value="270" <#if animalBreed == 270>selected</#if>>Ír szarvatlan marha</option>
                    <option value="271" <#if animalBreed == 271>selected</#if>>Jakutföldi marha</option>
                    <option value="272" <#if animalBreed == 272>selected</#if>>Jamaicai fekete marha</option>
                    <option value="273" <#if animalBreed == 273>selected</#if>>Jamaicai remény marha</option>
                    <option value="274" <#if animalBreed == 274>selected</#if>>Jamaicai vörös marha</option>
                    <option value="275" <#if animalBreed == 275>selected</#if>>Japán barna marha</option>
                    <option value="276" <#if animalBreed == 276>selected</#if>>Japán fekete marha</option>
                    <option value="277" <#if animalBreed == 277>selected</#if>>Japán rövidszarvú marha</option>
                    <option value="278" <#if animalBreed == 278>selected</#if>>Japán szarvatlan marha</option>
                    <option value="279" <#if animalBreed == 279>selected</#if>>Jarmelista marha</option>
                    <option value="280" <#if animalBreed == 280>selected</#if>>Javari marha</option>
                    <option value="281" <#if animalBreed == 281>selected</#if>>Jenpien marha</option>
                    <option value="282" <#if animalBreed == 282>selected</#if>>Jersey marha</option>
                    <option value="283" <#if animalBreed == 283>selected</#if>>Junqueira marha</option>
                    <option value="284" <#if animalBreed == 284>selected</#if>>Jurino marha</option>
                    <option value="285" <#if animalBreed == 285>selected</#if>>Jyllandi marha</option>
                    <option value="286" <#if animalBreed == 286>selected</#if>>Kabin Buri marha</option>
                    <option value="287" <#if animalBreed == 287>selected</#if>>Kalmük marha</option>
                    <option value="288" <#if animalBreed == 288>selected</#if>>Kamphaeng Saen marha</option>
                    <option value="289" <#if animalBreed == 289>selected</#if>>Kanadai Speckle Park marha</option>
                    <option value="290" <#if animalBreed == 290>selected</#if>>Kangayam marha</option>
                    <option value="291" <#if animalBreed == 291>selected</#if>>Kankrej marha</option>
                    <option value="292" <#if animalBreed == 292>selected</#if>>Karan svájci marha</option>
                    <option value="293" <#if animalBreed == 293>selected</#if>>Karintiai Blondvieh marha</option>
                    <option value="294" <#if animalBreed == 294>selected</#if>>Kasaragodi törpe marha</option>
                    <option value="295" <#if animalBreed == 295>selected</#if>>Kathiawadi marha</option>
                    <option value="296" <#if animalBreed == 296>selected</#if>>Kárpáti borzasderes marha</option>
                    <option value="297" <#if animalBreed == 297>selected</#if>>Kelet-anatóliai vörös marha</option>
                    <option value="298" <#if animalBreed == 298>selected</#if>>Keleti finn marha</option>
                    <option value="299" <#if animalBreed == 299>selected</#if>>Keleti vörös szarvatlan marha</option>
                    <option value="300" <#if animalBreed == 300>selected</#if>>Kenana marha</option>
                    <option value="301" <#if animalBreed == 301>selected</#if>>Kenkatha marha</option>
                    <option value="302" <#if animalBreed == 302>selected</#if>>Kerry marha</option>
                    <option value="303" <#if animalBreed == 303>selected</#if>>Kékesszürke marha</option>
                    <option value="304" <#if animalBreed == 304>selected</#if>>Kherigarh marha</option>
                    <option value="305" <#if animalBreed == 305>selected</#if>>Khillari marha</option>
                    <option value="306" <#if animalBreed == 306>selected</#if>>Kholmogory marha</option>
                    <option value="307" <#if animalBreed == 307>selected</#if>>Kínai feketeszínű marha</option>
                    <option value="308" <#if animalBreed == 308>selected</#if>>Korat Wagyu marha</option>
                    <option value="309" <#if animalBreed == 309>selected</#if>>Korzikai marha</option>
                    <option value="310" <#if animalBreed == 310>selected</#if>>Kosztromai marha</option>
                    <option value="311" <#if animalBreed == 311>selected</#if>>Krisna-völgyi marha</option>
                    <option value="312" <#if animalBreed == 312>selected</#if>>Kuchinoshimai marha</option>
                    <option value="313" <#if animalBreed == 313>selected</#if>>Kurgani marha</option>
                    <option value="314" <#if animalBreed == 314>selected</#if>>Kuri marha</option>
                    <option value="315" <#if animalBreed == 315>selected</#if>>La Reina marha</option>
                    <option value="316" <#if animalBreed == 316>selected</#if>>Lampurger marha</option>
                    <option value="317" <#if animalBreed == 317>selected</#if>>Lebedini marha</option>
                    <option value="318" <#if animalBreed == 318>selected</#if>>Lengyel fekete-fehér marha</option>
                    <option value="319" <#if animalBreed == 319>selected</#if>>Lengyel vörös marha</option>
                    <option value="320" <#if animalBreed == 320>selected</#if>>Lett barna marha</option>
                    <option value="321" <#if animalBreed == 321>selected</#if>>Lett dán vörös marha</option>
                    <option value="322" <#if animalBreed == 322>selected</#if>>Lett kék marha</option>
                    <option value="323" <#if animalBreed == 323>selected</#if>>Levantina marha</option>
                    <option value="324" <#if animalBreed == 324>selected</#if>>Limia marha</option>
                    <option value="325" <#if animalBreed == 325>selected</#if>>Limousini marha</option>
                    <option value="326" <#if animalBreed == 326>selected</#if>>Limpurger marha</option>
                    <option value="327" <#if animalBreed == 327>selected</#if>>Lincolni vörös marha</option>
                    <option value="328" <#if animalBreed == 328>selected</#if>>Lineback marha</option>
                    <option value="329" <#if animalBreed == 329>selected</#if>>Litván fehérhátú marha</option>
                    <option value="330" <#if animalBreed == 330>selected</#if>>Litván fekete-fehér marha</option>
                    <option value="331" <#if animalBreed == 331>selected</#if>>Litván világosszürke marha</option>
                    <option value="332" <#if animalBreed == 332>selected</#if>>Litván vörös marha</option>
                    <option value="333" <#if animalBreed == 333>selected</#if>>Lohani marha</option>
                    <option value="334" <#if animalBreed == 334>selected</#if>>Lourdesi marha</option>
                    <option value="335" <#if animalBreed == 335>selected</#if>>Lucerna marha</option>
                    <option value="336" <#if animalBreed == 336>selected</#if>>Luing-szigeti marha</option>
                    <option value="337" <#if animalBreed == 337>selected</#if>>Maas-Rajna-Issel marha</option>
                    <option value="338" <#if animalBreed == 338>selected</#if>>Madagaszkári zebu</option>
                    <option value="339" <#if animalBreed == 339>selected</#if>>Madurai marha</option>
                    <option value="340" <#if animalBreed == 340>selected</#if>>Maine-Anjou marha</option>
                    <option value="341" <#if animalBreed == 341>selected</#if>>Malnad Gidda marha</option>
                    <option value="342" <#if animalBreed == 342>selected</#if>>Malvi marha</option>
                    <option value="343" <#if animalBreed == 343>selected</#if>>Mandalong Special marha</option>
                    <option value="344" <#if animalBreed == 344>selected</#if>>Mantequera Leonesa marha</option>
                    <option value="345" <#if animalBreed == 345>selected</#if>>Marchigiana marha</option>
                    <option value="346" <#if animalBreed == 346>selected</#if>>Maremmai szürke marha</option>
                    <option value="347" <#if animalBreed == 347>selected</#if>>Marinhoa marha</option>
                    <option value="348" <#if animalBreed == 348>selected</#if>>Maronesa marha</option>
                    <option value="349" <#if animalBreed == 349>selected</#if>>Mashona marha</option>
                    <option value="350" <#if animalBreed == 350>selected</#if>>Maszáj marha</option>
                    <option value="351" <#if animalBreed == 351>selected</#if>>Máramarosi barna marha</option>
                    <option value="352" <#if animalBreed == 352>selected</#if>>Menorquina marha</option>
                    <option value="353" <#if animalBreed == 353>selected</#if>>Mertolenga marha</option>
                    <option value="354" <#if animalBreed == 354>selected</#if>>Mewati marha</option>
                    <option value="355" <#if animalBreed == 355>selected</#if>>Minhota marha</option>
                    <option value="356" <#if animalBreed == 356>selected</#if>>Mirandaise marha</option>
                    <option value="357" <#if animalBreed == 357>selected</#if>>Mirandesa marha</option>
                    <option value="358" <#if animalBreed == 358>selected</#if>>Mirkadim marha</option>
                    <option value="359" <#if animalBreed == 359>selected</#if>>Mishima-szigeti marha</option>
                    <option value="360" <#if animalBreed == 360>selected</#if>>Mocăniţă marha</option>
                    <option value="361" <#if animalBreed == 361>selected</#if>>Mocho Nacional marha</option>
                    <option value="362" <#if animalBreed == 362>selected</#if>>Modenesei fehér marha</option>
                    <option value="363" <#if animalBreed == 363>selected</#if>>Modicana marha</option>
                    <option value="364" <#if animalBreed == 364>selected</#if>>Mollie marha</option>
                    <option value="365" <#if animalBreed == 365>selected</#if>>Monchina marha</option>
                    <option value="366" <#if animalBreed == 366>selected</#if>>Mongol marha</option>
                    <option value="367" <#if animalBreed == 367>selected</#if>>Montbéliardi marha</option>
                    <option value="368" <#if animalBreed == 368>selected</#if>>Morucha marha</option>
                    <option value="369" <#if animalBreed == 369>selected</#if>>Mucca Pisana marha</option>
                    <option value="370" <#if animalBreed == 370>selected</#if>>Murboden marha</option>
                    <option value="371" <#if animalBreed == 371>selected</#if>>Murnau-Werdenfels marha</option>
                    <option value="372" <#if animalBreed == 372>selected</#if>>Murray szürke marha</option>
                    <option value="373" <#if animalBreed == 373>selected</#if>>Muturu marha</option>
                    <option value="374" <#if animalBreed == 374>selected</#if>>NDama marha</option>
                    <option value="375" <#if animalBreed == 375>selected</#if>>Nagori marha</option>
                    <option value="376" <#if animalBreed == 376>selected</#if>>Német Angus</option>
                    <option value="377" <#if animalBreed == 377>selected</#if>>Német feketeszínű marha</option>
                    <option value="378" <#if animalBreed == 378>selected</#if>>Német feketeszínű tejelő marha</option>
                    <option value="379" <#if animalBreed == 379>selected</#if>>Német vörösszínű marha</option>
                    <option value="380" <#if animalBreed == 380>selected</#if>>Nguni marha</option>
                    <option value="381" <#if animalBreed == 381>selected</#if>>Niata marha</option>
                    <option value="382" <#if animalBreed == 382>selected</#if>>Nimari marha</option>
                    <option value="383" <#if animalBreed == 383>selected</#if>>Normandiai marha</option>
                    <option value="384" <#if animalBreed == 384>selected</#if>>Norvég vörös marha</option>
                    <option value="385" <#if animalBreed == 385>selected</#if>>Nyugati finn marha</option>
                    <option value="386" <#if animalBreed == 386>selected</#if>>Ongole marha</option>
                    <option value="387" <#if animalBreed == 387>selected</#if>>Oropai Pezzata Rossa marha</option>
                    <option value="388" <#if animalBreed == 388>selected</#if>>Orosz feketeszínű marha</option>
                    <option value="389" <#if animalBreed == 389>selected</#if>>Osztrák szimmentáli marha</option>
                    <option value="390" <#if animalBreed == 390>selected</#if>>Osztrák sárga marha</option>
                    <option value="391" <#if animalBreed == 391>selected</#if>>Østlandi vörös szarvtalanított marha</option>
                    <option value="392" <#if animalBreed == 392>selected</#if>>Pajuna marha</option>
                    <option value="393" <#if animalBreed == 393>selected</#if>>Palmera marha</option>
                    <option value="394" <#if animalBreed == 394>selected</#if>>Pantaneiro marha</option>
                    <option value="395" <#if animalBreed == 395>selected</#if>>Parda Alpina marha</option>
                    <option value="396" <#if animalBreed == 396>selected</#if>>Parthenayi marha</option>
                    <option value="397" <#if animalBreed == 397>selected</#if>>Pasiega marha</option>
                    <option value="398" <#if animalBreed == 398>selected</#if>>Pembroke marha</option>
                    <option value="399" <#if animalBreed == 399>selected</#if>>Pie Rouge des Plaines marha</option>
                    <option value="400" <#if animalBreed == 400>selected</#if>>Piemonti marha</option>
                    <option value="401" <#if animalBreed == 401>selected</#if>>Pinzgaui marha</option>
                    <option value="402" <#if animalBreed == 402>selected</#if>>Pireneusi barna marha</option>
                    <option value="403" <#if animalBreed == 403>selected</#if>>Pireneusi marha</option>
                    <option value="404" <#if animalBreed == 404>selected</#if>>Podolica marha</option>
                    <option value="405" <#if animalBreed == 405>selected</#if>>Podóliai szlavon-szerém marha</option>
                    <option value="406" <#if animalBreed == 406>selected</#if>>Pontremolese marha</option>
                    <option value="407" <#if animalBreed == 407>selected</#if>>Ponwari marha</option>
                    <option value="408" <#if animalBreed == 408>selected</#if>>Preta marha</option>
                    <option value="409" <#if animalBreed == 409>selected</#if>>Pulikulami marha</option>
                    <option value="410" <#if animalBreed == 410>selected</#if>>Punganuri törpe marha</option>
                    <option value="411" <#if animalBreed == 411>selected</#if>>Pustertaler Sprinzen marha</option>
                    <option value="412" <#if animalBreed == 412>selected</#if>>Qinchaun marha</option>
                    <option value="413" <#if animalBreed == 413>selected</#if>>Queenslandi törpe Boran marha</option>
                    <option value="414" <#if animalBreed == 414>selected</#if>>Ramo Grande marha</option>
                    <option value="415" <#if animalBreed == 415>selected</#if>>Randall Lineback marha</option>
                    <option value="416" <#if animalBreed == 416>selected</#if>>Raramuri Criollo marha</option>
                    <option value="417" <#if animalBreed == 417>selected</#if>>Rathi marha</option>
                    <option value="418" <#if animalBreed == 418>selected</#if>>Raya marha</option>
                    <option value="419" <#if animalBreed == 419>selected</#if>>Rätisches Grauvieh marha</option>
                    <option value="420" <#if animalBreed == 420>selected</#if>>Rendena marha</option>
                    <option value="421" <#if animalBreed == 421>selected</#if>>Retinta marha</option>
                    <option value="422" <#if animalBreed == 422>selected</#if>>Ringamålai marha</option>
                    <option value="423" <#if animalBreed == 423>selected</#if>>Ringamålako marha</option>
                    <option value="424" <#if animalBreed == 424>selected</#if>>Rohjan marha</option>
                    <option value="425" <#if animalBreed == 425>selected</#if>>Romagnola marha</option>
                    <option value="426" <#if animalBreed == 426>selected</#if>>Romosinuano marha</option>
                    <option value="427" <#if animalBreed == 427>selected</#if>>Rövidszarvú marha</option>
                    <option value="428" <#if animalBreed == 428>selected</#if>>Rövidszarvú húsmarha</option>
                    <option value="429" <#if animalBreed == 429>selected</#if>>RX3 marha</option>
                    <option value="430" <#if animalBreed == 430>selected</#if>>Sahiwal marha</option>
                    <option value="431" <#if animalBreed == 431>selected</#if>>Salers marha</option>
                    <option value="432" <#if animalBreed == 432>selected</#if>>Salorn marha</option>
                    <option value="433" <#if animalBreed == 433>selected</#if>>Sanga marha</option>
                    <option value="434" <#if animalBreed == 434>selected</#if>>Sanhe marha</option>
                    <option value="435" <#if animalBreed == 435>selected</#if>>Santa Cruz-i marha</option>
                    <option value="436" <#if animalBreed == 436>selected</#if>>Santa Gertrudis marha</option>
                    <option value="437" <#if animalBreed == 437>selected</#if>>Sayaguesa marha</option>
                    <option value="438" <#if animalBreed == 438>selected</#if>>Schwyz marha</option>
                    <option value="439" <#if animalBreed == 439>selected</#if>>Selembu marha</option>
                    <option value="440" <#if animalBreed == 440>selected</#if>>Senepol marha</option>
                    <option value="441" <#if animalBreed == 441>selected</#if>>Sheko marha</option>
                    <option value="442" <#if animalBreed == 442>selected</#if>>Shetlandi marha</option>
                    <option value="443" <#if animalBreed == 443>selected</#if>>Sibi bhagnari zebu</option>
                    <option value="444" <#if animalBreed == 444>selected</#if>>Siboney de Cuba marha</option>
                    <option value="445" <#if animalBreed == 445>selected</#if>>Simbrah marha</option>
                    <option value="446" <#if animalBreed == 446>selected</#if>>Simford marha</option>
                    <option value="447" <#if animalBreed == 447>selected</#if>>Siri marha</option>
                    <option value="448" <#if animalBreed == 448>selected</#if>>Sötétvörös marha</option>
                    <option value="449" <#if animalBreed == 449>selected</#if>>Spanyol viadal marha</option>
                    <option value="450" <#if animalBreed == 450>selected</#if>>Square Meater marha</option>
                    <option value="451" <#if animalBreed == 451>selected</#if>>Sunandini marha</option>
                    <option value="452" <#if animalBreed == 452>selected</#if>>Sussexi marha</option>
                    <option value="453" <#if animalBreed == 453>selected</#if>>Svájci Holstein marha</option>
                    <option value="454" <#if animalBreed == 454>selected</#if>>Svéd fríz</option>
                    <option value="455" <#if animalBreed == 455>selected</#if>>Svéd szarvtalanított marha</option>
                    <option value="456" <#if animalBreed == 456>selected</#if>>Svéd vörös-fehér marha</option>
                    <option value="457" <#if animalBreed == 457>selected</#if>>Svéd vörös szarvtalanított marha</option>
                    <option value="458" <#if animalBreed == 458>selected</#if>>Svéd vörösszínű marha</option>
                    <option value="459" <#if animalBreed == 459>selected</#if>>Szardíniai barna marha</option>
                    <option value="460" <#if animalBreed == 460>selected</#if>>Szardíniai marha</option>
                    <option value="461" <#if animalBreed == 461>selected</#if>>Szardíniai Modicana marha</option>
                    <option value="462" <#if animalBreed == 462>selected</#if>>Szerb sztyeppei marha</option>
                    <option value="463" <#if animalBreed == 463>selected</#if>>Szerb tarka marha</option>
                    <option value="464" <#if animalBreed == 464>selected</#if>>Szimmentáli marha</option>
                    <option value="465" <#if animalBreed == 465>selected</#if>>Szudáni Fuláni marha</option>
                    <option value="466" <#if animalBreed == 466>selected</#if>>Tabapuãi marha</option>
                    <option value="467" <#if animalBreed == 467>selected</#if>>Tarentaisei marha</option>
                    <option value="468" <#if animalBreed == 468>selected</#if>>Tasmaniai szürke marha</option>
                    <option value="469" <#if animalBreed == 469>selected</#if>>Tauros program</option>
                    <option value="470" <#if animalBreed == 470>selected</#if>>Heck-marhaféle</option>
                    <option value="471" <#if animalBreed == 471>selected</#if>>Tejelő rövidszarvú marha</option>
                    <option value="472" <#if animalBreed == 472>selected</#if>>Telemark marha</option>
                    <option value="473" <#if animalBreed == 473>selected</#if>>Terreña marha</option>
                    <option value="474" <#if animalBreed == 474>selected</#if>>Texoni marha</option>
                    <option value="475" <#if animalBreed == 475>selected</#if>>Thai fekete marha</option>
                    <option value="476" <#if animalBreed == 476>selected</#if>>Thai fríz</option>
                    <option value="477" <#if animalBreed == 477>selected</#if>>Thai tejelő zebu</option>
                    <option value="478" <#if animalBreed == 478>selected</#if>>Thai viadal bika</option>
                    <option value="479" <#if animalBreed == 479>selected</#if>>Tharparkari marha</option>
                    <option value="480" <#if animalBreed == 480>selected</#if>>Tipo Carora marha</option>
                    <option value="481" <#if animalBreed == 481>selected</#if>>Tiroli szürke marha</option>
                    <option value="482" <#if animalBreed == 482>selected</#if>>Török sztyeppei szürke marha</option>
                    <option value="483" <#if animalBreed == 483>selected</#if>>Törpe Lulu</option>
                    <option value="484" <#if animalBreed == 484>selected</#if>>Törpe texasi hosszúszarvú marha</option>
                    <option value="485" <#if animalBreed == 485>selected</#if>>Tswana marha</option>
                    <option value="486" <#if animalBreed == 486>selected</#if>>Tudancai marha</option>
                    <option value="487" <#if animalBreed == 487>selected</#if>>Tuli marha</option>
                    <option value="488" <#if animalBreed == 488>selected</#if>>Tulim marha</option>
                    <option value="489" <#if animalBreed == 489>selected</#if>>Tux-Zillertal marha</option>
                    <option value="490" <#if animalBreed == 490>selected</#if>>Ujgur barna marha</option>
                    <option value="491" <#if animalBreed == 491>selected</#if>>Ukrán szürke marha</option>
                    <option value="492" <#if animalBreed == 492>selected</#if>>Umblachery marha</option>
                    <option value="493" <#if animalBreed == 493>selected</#if>>Valdostana Castana marha</option>
                    <option value="494" <#if animalBreed == 494>selected</#if>>Valdostana Pezzata Nera marha</option>
                    <option value="495" <#if animalBreed == 495>selected</#if>>Valdostana Pezzata Rossa marha</option>
                    <option value="496" <#if animalBreed == 496>selected</#if>>Vaynoli marha</option>
                    <option value="497" <#if animalBreed == 497>selected</#if>>Varzese-Ottonese-Tortonese marha</option>
                    <option value="498" <#if animalBreed == 498>selected</#if>>Väneko marha</option>
                    <option value="499" <#if animalBreed == 499>selected</#if>>Vechoori marha</option>
                    <option value="500" <#if animalBreed == 500>selected</#if>>Vestlandet-fjordi marha</option>
                    <option value="501" <#if animalBreed == 501>selected</#if>>Vestlandeti vörös szarvtalanított marha</option>
                    <option value="502" <#if animalBreed == 502>selected</#if>>Vianesa marha</option>
                    <option value="503" <#if animalBreed == 503>selected</#if>>Volinyi húsmarha</option>
                    <option value="504" <#if animalBreed == 504>selected</#if>>Vorderwald marha</option>
                    <option value="505" <#if animalBreed == 505>selected</#if>>Vosgienne marha</option>
                    <option value="506" <#if animalBreed == 506>selected</#if>>Vörös Brangus marha</option>
                    <option value="507" <#if animalBreed == 507>selected</#if>>Vörös csittagongi marha</option>
                    <option value="508" <#if animalBreed == 508>selected</#if>>Vörös-fehér fríz</option>
                    <option value="509" <#if animalBreed == 509>selected</#if>>Vörös Fulani marha</option>
                    <option value="510" <#if animalBreed == 510>selected</#if>>Vörös gorbatovi marha</option>
                    <option value="511" <#if animalBreed == 511>selected</#if>>Vörös Höhenvieh marha</option>
                    <option value="512" <#if animalBreed == 512>selected</#if>>Vörös Kandhari marha</option>
                    <option value="513" <#if animalBreed == 513>selected</#if>>Vörös mingréliai marha</option>
                    <option value="514" <#if animalBreed == 514>selected</#if>>Vörös Sindhi marha</option>
                    <option value="515" <#if animalBreed == 515>selected</#if>>Vörös szarvatlan marha</option>
                    <option value="516" <#if animalBreed == 516>selected</#if>>Vörös tambovi marha</option>
                    <option value="517" <#if animalBreed == 517>selected</#if>>Waguli marha</option>
                    <option value="518" <#if animalBreed == 518>selected</#if>>Wagyu marha</option>
                    <option value="519" <#if animalBreed == 519>selected</#if>>Walesi fekete marha</option>
                    <option value="520" <#if animalBreed == 520>selected</#if>>Wangus marha</option>
                    <option value="521" <#if animalBreed == 521>selected</#if>>White Park marha</option>
                    <option value="522" <#if animalBreed == 522>selected</#if>>Yanhuang marha</option>
                    <option value="523" <#if animalBreed == 523>selected</#if>>Żubroń</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingType">típusa [type]:</label>
                <select id="floatingType" name="type">
                    <option value="1" <#if animalType == 1>selected</#if>>Kettős hasznosítású</option>
                    <option value="2" <#if animalType == 2>selected</#if>>Tejhasznú</option>
                    <option value="3" <#if animalType == 3>selected</#if>>Húshasznú</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingColour">színe [colour]:</label>
                <select id="floatingColour" name="colour">
                    <option value="1" <#if animalColor == 1>selected</#if>>Fekete [Black]</option>
                    <option value="2" <#if animalColor == 2>selected</#if>>Vörös [Red]</option>
                    <option value="3" <#if animalColor == 3>selected</#if>>Sötétbarna-Fehér tarka [Dark Brown & White]</option>
                    <option value="4" <#if animalColor == 4>selected</#if>>Kék [Blue]</option>
                    <option value="5" <#if animalColor == 5>selected</#if>>Tűzöttsárga [Yellow ticking]</option>
                    <option value="6" <#if animalColor == 6>selected</#if>>Vörös-fehér tarka [Red & White]</option>
                    <option value="7" <#if animalColor == 7>selected</#if>>Brindle [Brindle]</option>
                    <option value="8" <#if animalColor == 8>selected</#if>>Fekete-fehér tarka [Black & White]</option>
                    <option value="9" <#if animalColor == 9>selected</#if>>fehér [White]</option>
                    <option value="10" <#if animalColor == 10>selected</#if>>Szürkésbarna [Greyish Brown]</option>
                    <option value="11" <#if animalColor == 11>selected</#if>>kéktarka [Blue & White]</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingBirthdate">születési dátuma [date of birth]:</label>
                <input type="date" id="floatingBirthdate" name="birthDate" value="${animalBirthDate?string('yyyy-MM-dd')}" required>
            </div>
            <div class="form-group">
                <label for="floatingDeathdate">halál dátuma [date of death]:</label>
                <input type="date" id="floatingDeathdate" name="deathDate" <#if animalDeathDate?has_content> value="${animalDeathDate?string('yyyy-MM-dd')}" </#if>>
            </div>
            <div class="form-group">
                <label for="floatingPreviousId">előző (külföldi) azonosító<br>[previous (foreign) countrycode, number]:</label>
                <input type="text" id="floatingPreviousId" name="previousId" value="${animalPrevId!}" style="width: 400px;">
            </div>
            <div class="form-group">
                <label for="floatingMotherId">anya/recipiens azonosító<br>[dam's/recipient's number]:</label>
                <input type="text" id="floatingMotherId" name="motherId" value="${animalMotherId!}" style="width: 400px;">
            </div>
            <div class="form-group">
                <label for="floatingFatherId">apa/recipiens azonosító<br>[sire's/recipient's number]:</label>
                <input type="text" id="floatingFatherId" name="fatherId" value="${animalFatherId!}" style="width: 400px;">
            </div>
            <#if HCinput??>
                <div class="form-group">
                    <label for="floatingHoldingId">Tenyészet kódja [Holding code]:</label>
                    <input type="text" id="floatingHoldingId" name="holdingId" value="${animalHoldingCode!}" style="width: 400px; margin-bottom: 15px" required>
                </div>
            </#if>

            <button type="button"
                    class="btn btn-outline-primary"
                     onclick="document.location='/search_interface'"
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

        <#if error??>
            <div style="color: red; margin-top: 15px;">${error?html}</div>
        </#if>
        <div id="formatError" style="color: red; margin-top: 15px;"></div>

        <script>
            const inputField = document.getElementById('floatingSelfId');
            const errorMessage = document.getElementById('formatError');
            const pattern = /^[A-Z]{2}-\d{5}$/;

            inputField.addEventListener('input', function()
            {
                const inputValue = inputField.value;

                if (!pattern.test(inputValue)) {
                    errorMessage.innerHTML = "Hibás saját azonosító formátum!<br>Helyes formátum: XY-12345";
                }
                else {
                    errorMessage.innerHTML = "";
                }
            });

            document.getElementById('codeForm').addEventListener('submit', function(event)
            {
                if (!pattern.test(inputField.value))
                {
                    event.preventDefault();
                }
            });
        </script>
    </main>
</body>
</html>