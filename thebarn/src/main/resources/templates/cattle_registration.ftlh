<!DOCTYPE html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="/css/cattle_registration.css" rel="stylesheet">
    <title>The Barn Cattle Registration</title>
</head>
<body class="text-center">
    <main class="form-signin">
        <form action="/cattle_registration" method="post" onsubmit="return validateForm()">
            <h1>Szarvasmarha Regisztráció</h1>
            <div class="form-group">
                <label for="floatingSelfId">saját azonosító [self number]:</label>
                <input type="text" id="floatingSelfId" name="selfId" style="width: 400px;" required>
            </div>
            <div class="form-group">
                <label for="floatingSex">neme [sex]:</label>
                <select id="floatingSex" name="sex">
                    <option value="true">hímivar (bika) [Male]</option>
                    <option value="false">nőivar (üsző) [Female]</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingBreed">faja,fajtája [breed]:</label>
                <select id="floatingBreed" name="breed">
                    <option value="1">Aberdeen angus</option>
                    <option value="2">Ankole-Watusi marha</option>
                    <option value="3">Brahma marha</option>
                    <option value="4">Dexter</option>
                    <option value="5">Fekete angus</option>
                    <option value="6">Galiciai szőke szarvasmarha</option>
                    <option value="7">Hanu</option>
                    <option value="8">Hereford marha</option>
                    <option value="9">Holstein-fríz</option>
                    <option value="10">Magyar szürke szarvasmarha</option>
                    <option value="11">Magyar tarka szarvasmarha</option>
                    <option value="12">Nelore marha</option>
                    <option value="13">Skót-felföldi marha</option>
                    <option value="14">Szarv nélküli Hereford marha</option>
                    <option value="15">Texasi hosszúszarvú marha</option>
                    <option value="16">Vörös angus</option>
                    <option value="17">Vörös Holstein-fríz</option>
                    <option value="18">Abergele marha</option>
                    <option value="19">Abesszin rövidszarvú zebu</option>
                    <option value="20">Abigar marha</option>
                    <option value="21">Abondance marha</option>
                    <option value="22">Abruzzoi marha</option>
                    <option value="23">Acehi marha</option>
                    <option value="24">Achhami marha</option>
                    <option value="25">Adamawai marha</option>
                    <option value="26">Adaptaur marha</option>
                    <option value="27">Afar marha</option>
                    <option value="28">Africangus marha</option>
                    <option value="29">Afrikaner marha</option>
                    <option value="30">Agerolai marha</option>
                    <option value="31">Alambadi marha</option>
                    <option value="32">Alataui marha</option>
                    <option value="33">Albániai marha</option>
                    <option value="34">Alberai marha</option>
                    <option value="35">Albioni kék marha</option>
                    <option value="36">Alderney marha</option>
                    <option value="37">Alentejana marha</option>
                    <option value="38">Aleut-szigeteki vadmarha</option>
                    <option value="39">Aliad Dinka marha</option>
                    <option value="40">Alistana-Sanabresa marha</option>
                    <option value="41">Allmogekor marha</option>
                    <option value="42">Alur marha</option>
                    <option value="43">Amerifax marha</option>
                    <option value="44">Amerikai Angus</option>
                    <option value="45">Amerikai barna svájci marha</option>
                    <option value="46">Amerikai hús fríz</option>
                    <option value="47">Amerikai marha</option>
                    <option value="48">Amerikai rodeó marha</option>
                    <option value="49">Amerikai tejelő Devon marha</option>
                    <option value="50">Amerikai White Park marha</option>
                    <option value="51">Amrit Mahal marha</option>
                    <option value="52">Hallikar marhából</option>
                    <option value="53">Amszterdam-szigeti marha</option>
                    <option value="54">Anatóliai fekete marha</option>
                    <option value="55">Andalúziai fekete marha</option>
                    <option value="56">Avileña-Negra Ibérica marhával</option>
                    <option value="57">Andalúziai szőke marha</option>
                    <option value="58">Andalúziai szürke marha</option>
                    <option value="59">Angelni marha</option>
                    <option value="60">Angol hosszúszarvú marha</option>
                    <option value="61">Angoni marha</option>
                    <option value="62">Ankina marha</option>
                    <option value="63">Ankole marha</option>
                    <option value="64">Aquitaniai szőke marha</option>
                    <option value="65">Aracena marha</option>
                    <option value="66">Arado marha</option>
                    <option value="67">Argentín Criollo marha</option>
                    <option value="68">Argentín fríz</option>
                    <option value="69">Armoricaine marha</option>
                    <option value="70">Arouquesa marha</option>
                    <option value="71">Arsi marha</option>
                    <option value="72">Asztúriai hegyi marha</option>
                    <option value="73">Asztúriai völgyi marha</option>
                    <option value="74">Aubraci marha</option>
                    <option value="75">Aulie-Ata marha</option>
                    <option value="76">Aure et Saint-Girons marha</option>
                    <option value="77">Ausztrál Braford</option>
                    <option value="78">Ausztrál Brangus</option>
                    <option value="79">Ausztrál Charbray</option>
                    <option value="80">Ausztrál Lowline marha</option>
                    <option value="81">Ausztrál rövidszarvú marha</option>
                    <option value="82">Ausztrál Sahiwal fríz</option>
                    <option value="83">Ausztrál tejelő zebu</option>
                    <option value="84">Avétonou marha</option>
                    <option value="85">Avileña-Negra Ibérica marha</option>
                    <option value="86">andalúziai fekete marhával</option>
                    <option value="87">Aweil Dinka marha</option>
                    <option value="88">Ayrshire marha</option>
                    <option value="89">Azaouak marha</option>
                    <option value="90">Azebuado marha</option>
                    <option value="91">Azerbajdzsáni zebu</option>
                    <option value="92">Azori-szigeteki marha</option>
                    <option value="93">Bachaur marha</option>
                    <option value="94">Baggara marha</option>
                    <option value="95">Baherie marha</option>
                    <option value="96">Bakosi marha</option>
                    <option value="97">Balancer marha</option>
                    <option value="98">Gelbvieh marha</option>
                    <option value="100">Baoule marha</option>
                    <option value="101">Bargur marha</option>
                    <option value="102">Barna kaukázusi marha</option>
                    <option value="103">Barna kárpáti marha</option>
                    <option value="104">Barna svájci marha</option>
                    <option value="105">Barrosã marha</option>
                    <option value="106">Barzona marha</option>
                    <option value="107">Bazadaise marha</option>
                    <option value="108">Beefalo</option>
                    <option value="109">Beefmaker marha</option>
                    <option value="110">Beefmaster marha</option>
                    <option value="111">Begayt marha</option>
                    <option value="112">Belga fehér-vörös marha</option>
                    <option value="113">Belga vörös marha</option>
                    <option value="114">Belga vörös tarka marha</option>
                    <option value="115">Belmont vörös marha</option>
                    <option value="116">Berni marha</option>
                    <option value="117">Berrenda marha</option>
                    <option value="118">Bestuzhev marha</option>
                    <option value="119">Betizu marha</option>
                    <option value="120">Béarni marha</option>
                    <option value="121">Blaarkop marha</option>
                    <option value="122">Blanca Cacereña marha</option>
                    <option value="123">Blanco Orejinegro BON marha</option>
                    <option value="124">Bohuskulla marha</option>
                    <option value="125">Bonsmarai marha</option>
                    <option value="126">Boran marha</option>
                    <option value="127">Boškarin marha</option>
                    <option value="128">Braford marha</option>
                    <option value="129">Brahmousin marha</option>
                    <option value="130">Brangus marha</option>
                    <option value="131">Brava marha</option>
                    <option value="132">Bretagnei Pie Noir marha</option>
                    <option value="133">Brit fehér marha</option>
                    <option value="134">Brit fríz</option>
                    <option value="135">Buelingo marha</option>
                    <option value="136">Burlina marha</option>
                    <option value="137">Buša marha</option>
                    <option value="138">Bushuyev marha</option>
                    <option value="139">Butanai marha</option>
                    <option value="140">Cabannina marha</option>
                    <option value="141">Cachena marha</option>
                    <option value="142">Barrosã marhával</option>
                    <option value="143">Caldelana marha</option>
                    <option value="144">Calvanai marha</option>
                    <option value="145">Camargue marha</option>
                    <option value="146">Campbell-szigeti marha</option>
                    <option value="147">Canadienne marha</option>
                    <option value="148">Canaria marha</option>
                    <option value="149">Canchim marha</option>
                    <option value="150">Caracu marha</option>
                    <option value="151">Cárdena Andaluza marha</option>
                    <option value="152">Charbray marha</option>
                    <option value="153">Charolais marha</option>
                    <option value="154">Chateaubriand marha</option>
                    <option value="155">Chiangus marha</option>
                    <option value="156">Chianina marha</option>
                    <option value="157">Chikso marha</option>
                    <option value="158">Chillinghami marha</option>
                    <option value="159">Cholistani marha</option>
                    <option value="160">Cinisara marha</option>
                    <option value="161">Coloursided White Back marha</option>
                    <option value="162">Commercial marha</option>
                    <option value="163">Corriente marha</option>
                    <option value="164">Costeño con Cuernos marha</option>
                    <option value="165">Crioulo Lageano marha</option>
                    <option value="166">Csedzsu-szigeti fekete marha</option>
                    <option value="167">Dajal marha</option>
                    <option value="168">Dangi marha</option>
                    <option value="169">Dán fekete tarka marha</option>
                    <option value="170">Dán Jersey marha</option>
                    <option value="171">Dán vörös marha</option>
                    <option value="172">Deoni marha</option>
                    <option value="173">Dél-devoni marha</option>
                    <option value="174">Dhanni marha</option>
                    <option value="175">Doayo marha</option>
                    <option value="176">Doela marha</option>
                    <option value="177">Drakensbergi marha</option>
                    <option value="178">Droimeann marha</option>
                    <option value="179">Droughtmaster marha</option>
                    <option value="180">Dulong marha</option>
                    <option value="181">Dølafe marha</option>
                    <option value="182">Dzo</option>
                    <option value="183">Dzomo</option>
                    <option value="184">Enderby-szigeti marha</option>
                    <option value="185">Ennstaler Bergscheck marha</option>
                    <option value="186">Erdélyi szürke marha</option>
                    <option value="187">Eredeti svájci marha</option>
                    <option value="188">Észak-amerikai piemonti marha</option>
                    <option value="189">Észak-bengáli szürke marha</option>
                    <option value="190">Észak-devoni marha</option>
                    <option value="191">Északi finn marha</option>
                    <option value="192">Északi kék marha</option>
                    <option value="193">Északi rövidszarvú marha</option>
                    <option value="194">Észt bennszülött marha</option>
                    <option value="195">Észt Holstein marha</option>
                    <option value="196">Észt vörös marha</option>
                    <option value="197">Évolène marha</option>
                    <option value="198">Fehér Cáceres marha</option>
                    <option value="199">Fehérfejű kazah marha</option>
                    <option value="200">Fehér Fulani marha</option>
                    <option value="201">Fehér Lamphun marha</option>
                    <option value="202">Fehérorosz marha</option>
                    <option value="203">Fehér-kék belga marha</option>
                    <option value="204">Fehér tenyésztésű rövidszarvú marha</option>
                    <option value="205">Fekete Baldy marha</option>
                    <option value="206">Fekete Hereford marha</option>
                    <option value="207">Feljavított holland vörös-fehér marha</option>
                    <option value="208">Feljavított vörös-fehér marha</option>
                    <option value="209">Fenyőerdei marha</option>
                    <option value="210">Fēng marha</option>
                    <option value="211">Ferrandaise marha</option>
                    <option value="212">Finn Ayrshire marha</option>
                    <option value="213">Finn Holstein-fríz</option>
                    <option value="214">Finn marha</option>
                    <option value="215">Fjäll marha</option>
                    <option value="216">Fleckvieh marha</option>
                    <option value="217">Floridai kiváló marha</option>
                    <option value="218">Fogerai marha</option>
                    <option value="219">Francia szimmentáli marha</option>
                    <option value="220">Frankeston vörös marha</option>
                    <option value="221">Fribourgi marha</option>
                    <option value="222">Fríz húsmarha</option>
                    <option value="223">Froment du Léon marha</option>
                    <option value="224">Fülöp-szigeteki marha</option>
                    <option value="225">Gallowayi marha</option>
                    <option value="226">Gallowayi öves marha</option>
                    <option value="227">Gangatiri marha</option>
                    <option value="228">Gaolao marha</option>
                    <option value="229">Garfagnina marha</option>
                    <option value="230">Garvonesa marha</option>
                    <option value="231">Gasconi marha</option>
                    <option value="233">Girolando marha</option>
                    <option value="234">Glamorgai marha</option>
                    <option value="235">Glan marha</option>
                    <option value="236">Gloucesteri marha</option>
                    <option value="237">Gobra marha</option>
                    <option value="238">Görög rövidszarvú marha</option>
                    <option value="239">Görög szteppei marha</option>
                    <option value="240">Greyman marha</option>
                    <option value="241">Grúz hegyi marha</option>
                    <option value="242">Gudali marha</option>
                    <option value="243">Guernseyi marha</option>
                    <option value="244">Guzerat marha</option>
                    <option value="245">Gyr marha</option>
                    <option value="246">Hallikar marha</option>
                    <option value="247">Harijánai marha</option>
                    <option value="248">Hartón del Valle marha</option>
                    <option value="249">Harzi vörös marha</option>
                    <option value="250">Hawaii vadmarha</option>
                    <option value="251">Hays Converter marha</option>
                    <option value="252">Heck-marha</option>
                    <option value="253">Heugu marha</option>
                    <option value="254">Hérens-völgyi marha</option>
                    <option value="255">Hinterwald marha</option>
                    <option value="256">Holland-argentín marha</option>
                    <option value="257">Holland fríz</option>
                    <option value="258">Holland öves marha</option>
                    <option value="259">Horro marha</option>
                    <option value="260">Huáng marha</option>
                    <option value="261">Hybridmaster marha</option>
                    <option value="262">Ibériai marha</option>
                    <option value="263">Illawarrai marha</option>
                    <option value="264">Indobrazíliai marha</option>
                    <option value="265">Istobeni marha</option>
                    <option value="266">Isztriai marha</option>
                    <option value="267">Izlandi marha</option>
                    <option value="268">Izraeli Holstein marha</option>
                    <option value="269">Izraeli vörös marha</option>
                    <option value="270">Ír szarvatlan marha</option>
                    <option value="271">Jakutföldi marha</option>
                    <option value="272">Jamaicai fekete marha</option>
                    <option value="273">Jamaicai remény marha</option>
                    <option value="274">Jamaicai vörös marha</option>
                    <option value="275">Japán barna marha</option>
                    <option value="276">Japán fekete marha</option>
                    <option value="277">Japán rövidszarvú marha</option>
                    <option value="278">Japán szarvatlan marha</option>
                    <option value="279">Jarmelista marha</option>
                    <option value="280">Javari marha</option>
                    <option value="281">Jenpien marha</option>
                    <option value="282">Jersey marha</option>
                    <option value="283">Junqueira marha</option>
                    <option value="284">Jurino marha</option>
                    <option value="285">Jyllandi marha</option>
                    <option value="286">Kabin Buri marha</option>
                    <option value="287">Kalmük marha</option>
                    <option value="288">Kamphaeng Saen marha</option>
                    <option value="289">Kanadai Speckle Park marha</option>
                    <option value="290">Kangayam marha</option>
                    <option value="291">Kankrej marha</option>
                    <option value="292">Karan svájci marha</option>
                    <option value="293">Karintiai Blondvieh marha</option>
                    <option value="294">Kasaragodi törpe marha</option>
                    <option value="295">Kathiawadi marha</option>
                    <option value="296">Kárpáti borzasderes marha</option>
                    <option value="297">Kelet-anatóliai vörös marha</option>
                    <option value="298">Keleti finn marha</option>
                    <option value="299">Keleti vörös szarvatlan marha</option>
                    <option value="300">Kenana marha</option>
                    <option value="301">Kenkatha marha</option>
                    <option value="302">Kerry marha</option>
                    <option value="303">Kékesszürke marha</option>
                    <option value="304">Kherigarh marha</option>
                    <option value="305">Khillari marha</option>
                    <option value="306">Kholmogory marha</option>
                    <option value="307">Kínai feketeszínű marha</option>
                    <option value="308">Korat Wagyu marha</option>
                    <option value="309">Korzikai marha</option>
                    <option value="310">Kosztromai marha</option>
                    <option value="311">Krisna-völgyi marha</option>
                    <option value="312">Kuchinoshimai marha</option>
                    <option value="313">Kurgani marha</option>
                    <option value="314">Kuri marha</option>
                    <option value="315">La Reina marha</option>
                    <option value="316">Lampurger marha</option>
                    <option value="317">Lebedini marha</option>
                    <option value="318">Lengyel fekete-fehér marha</option>
                    <option value="319">Lengyel vörös marha</option>
                    <option value="320">Lett barna marha</option>
                    <option value="321">Lett dán vörös marha</option>
                    <option value="322">Lett kék marha</option>
                    <option value="323">Levantina marha</option>
                    <option value="324">Limia marha</option>
                    <option value="325">Limousini marha</option>
                    <option value="326">Limpurger marha</option>
                    <option value="327">Lincolni vörös marha</option>
                    <option value="328">Lineback marha</option>
                    <option value="329">Litván fehérhátú marha</option>
                    <option value="330">Litván fekete-fehér marha</option>
                    <option value="331">Litván világosszürke marha</option>
                    <option value="332">Litván vörös marha</option>
                    <option value="333">Lohani marha</option>
                    <option value="334">Lourdesi marha</option>
                    <option value="335">Lucerna marha</option>
                    <option value="336">Luing-szigeti marha</option>
                    <option value="337">Maas-Rajna-Issel marha</option>
                    <option value="338">Madagaszkári zebu</option>
                    <option value="339">Madurai marha</option>
                    <option value="340">Maine-Anjou marha</option>
                    <option value="341">Malnad Gidda marha</option>
                    <option value="342">Malvi marha</option>
                    <option value="343">Mandalong Special marha</option>
                    <option value="344">Mantequera Leonesa marha</option>
                    <option value="345">Marchigiana marha</option>
                    <option value="346">Maremmai szürke marha</option>
                    <option value="347">Marinhoa marha</option>
                    <option value="348">Maronesa marha</option>
                    <option value="349">Mashona marha</option>
                    <option value="350">Maszáj marha</option>
                    <option value="351">Máramarosi barna marha</option>
                    <option value="352">Menorquina marha</option>
                    <option value="353">Mertolenga marha</option>
                    <option value="354">Mewati marha</option>
                    <option value="355">Minhota marha</option>
                    <option value="356">Mirandaise marha</option>
                    <option value="357">Mirandesa marha</option>
                    <option value="358">Mirkadim marha</option>
                    <option value="359">Mishima-szigeti marha</option>
                    <option value="360">Mocăniţă marha</option>
                    <option value="361">Mocho Nacional marha</option>
                    <option value="362">Modenesei fehér marha</option>
                    <option value="363">Modicana marha</option>
                    <option value="364">Mollie marha</option>
                    <option value="365">Monchina marha</option>
                    <option value="366">Mongol marha</option>
                    <option value="367">Montbéliardi marha</option>
                    <option value="368">Morucha marha</option>
                    <option value="369">Mucca Pisana marha</option>
                    <option value="370">Murboden marha</option>
                    <option value="371">Murnau-Werdenfels marha</option>
                    <option value="372">Murray szürke marha</option>
                    <option value="373">Muturu marha</option>
                    <option value="374">NDama marha</option>
                    <option value="375">Nagori marha</option>
                    <option value="376">Német Angus</option>
                    <option value="377">Német feketeszínű marha</option>
                    <option value="378">Német feketeszínű tejelő marha</option>
                    <option value="379">Német vörösszínű marha</option>
                    <option value="380">Nguni marha</option>
                    <option value="381">Niata marha</option>
                    <option value="382">Nimari marha</option>
                    <option value="383">Normandiai marha</option>
                    <option value="384">Norvég vörös marha</option>
                    <option value="385">Nyugati finn marha</option>
                    <option value="386">Ongole marha</option>
                    <option value="387">Oropai Pezzata Rossa marha</option>
                    <option value="388">Orosz feketeszínű marha</option>
                    <option value="389">Osztrák szimmentáli marha</option>
                    <option value="390">Osztrák sárga marha</option>
                    <option value="391">Østlandi vörös szarvtalanított marha</option>
                    <option value="392">Pajuna marha</option>
                    <option value="393">Palmera marha</option>
                    <option value="394">Pantaneiro marha</option>
                    <option value="395">Parda Alpina marha</option>
                    <option value="396">Parthenayi marha</option>
                    <option value="397">Pasiega marha</option>
                    <option value="398">Pembroke marha</option>
                    <option value="399">Pie Rouge des Plaines marha</option>
                    <option value="400">Piemonti marha</option>
                    <option value="401">Pinzgaui marha</option>
                    <option value="402">Pireneusi barna marha</option>
                    <option value="403">Pireneusi marha</option>
                    <option value="404">Podolica marha</option>
                    <option value="405">Podóliai szlavon-szerém marha</option>
                    <option value="406">Pontremolese marha</option>
                    <option value="407">Ponwari marha</option>
                    <option value="408">Preta marha</option>
                    <option value="409">Pulikulami marha</option>
                    <option value="410">Punganuri törpe marha</option>
                    <option value="411">Pustertaler Sprinzen marha</option>
                    <option value="412">Qinchaun marha</option>
                    <option value="413">Queenslandi törpe Boran marha</option>
                    <option value="414">Ramo Grande marha</option>
                    <option value="415">Randall Lineback marha</option>
                    <option value="416">Raramuri Criollo marha</option>
                    <option value="417">Rathi marha</option>
                    <option value="418">Raya marha</option>
                    <option value="419">Rätisches Grauvieh marha</option>
                    <option value="420">Rendena marha</option>
                    <option value="421">Retinta marha</option>
                    <option value="422">Ringamålai marha</option>
                    <option value="423">Ringamålako marha</option>
                    <option value="424">Rohjan marha</option>
                    <option value="425">Romagnola marha</option>
                    <option value="426">Romosinuano marha</option>
                    <option value="427">Rövidszarvú marha</option>
                    <option value="428">Rövidszarvú húsmarha</option>
                    <option value="429">RX3 marha</option>
                    <option value="430">Sahiwal marha</option>
                    <option value="431">Salers marha</option>
                    <option value="432">Salorn marha</option>
                    <option value="433">Sanga marha</option>
                    <option value="434">Sanhe marha</option>
                    <option value="435">Santa Cruz-i marha</option>
                    <option value="436">Santa Gertrudis marha</option>
                    <option value="437">Sayaguesa marha</option>
                    <option value="438">Schwyz marha</option>
                    <option value="439">Selembu marha</option>
                    <option value="440">Senepol marha</option>
                    <option value="441">Sheko marha</option>
                    <option value="442">Shetlandi marha</option>
                    <option value="443">Sibi bhagnari zebu</option>
                    <option value="444">Siboney de Cuba marha</option>
                    <option value="445">Simbrah marha</option>
                    <option value="446">Simford marha</option>
                    <option value="447">Siri marha</option>
                    <option value="448">Sötétvörös marha</option>
                    <option value="449">Spanyol viadal marha</option>
                    <option value="450">Square Meater marha</option>
                    <option value="451">Sunandini marha</option>
                    <option value="452">Sussexi marha</option>
                    <option value="453">Svájci Holstein marha</option>
                    <option value="454">Svéd fríz</option>
                    <option value="455">Svéd szarvtalanított marha</option>
                    <option value="456">Svéd vörös-fehér marha</option>
                    <option value="457">Svéd vörös szarvtalanított marha</option>
                    <option value="458">Svéd vörösszínű marha</option>
                    <option value="459">Szardíniai barna marha</option>
                    <option value="460">Szardíniai marha</option>
                    <option value="461">Szardíniai Modicana marha</option>
                    <option value="462">Szerb sztyeppei marha</option>
                    <option value="463">Szerb tarka marha</option>
                    <option value="464">Szimmentáli marha</option>
                    <option value="465">Szudáni Fuláni marha</option>
                    <option value="466">Tabapuãi marha</option>
                    <option value="467">Tarentaisei marha</option>
                    <option value="468">Tasmaniai szürke marha</option>
                    <option value="469">Tauros program</option>
                    <option value="470">Heck-marhaféle</option>
                    <option value="471">Tejelő rövidszarvú marha</option>
                    <option value="472">Telemark marha</option>
                    <option value="473">Terreña marha</option>
                    <option value="474">Texoni marha</option>
                    <option value="475">Thai fekete marha</option>
                    <option value="476">Thai fríz</option>
                    <option value="477">Thai tejelő zebu</option>
                    <option value="478">Thai viadal bika</option>
                    <option value="479">Tharparkari marha</option>
                    <option value="480">Tipo Carora marha</option>
                    <option value="481">Tiroli szürke marha</option>
                    <option value="482">Török sztyeppei szürke marha</option>
                    <option value="483">Törpe Lulu</option>
                    <option value="484">Törpe texasi hosszúszarvú marha</option>
                    <option value="485">Tswana marha</option>
                    <option value="486">Tudancai marha</option>
                    <option value="487">Tuli marha</option>
                    <option value="488">Tulim marha</option>
                    <option value="489">Tux-Zillertal marha</option>
                    <option value="490">Ujgur barna marha</option>
                    <option value="491">Ukrán szürke marha</option>
                    <option value="492">Umblachery marha</option>
                    <option value="493">Valdostana Castana marha</option>
                    <option value="494">Valdostana Pezzata Nera marha</option>
                    <option value="495">Valdostana Pezzata Rossa marha</option>
                    <option value="496">Vaynoli marha</option>
                    <option value="497">Varzese-Ottonese-Tortonese marha</option>
                    <option value="498">Väneko marha</option>
                    <option value="499">Vechoori marha</option>
                    <option value="500">Vestlandet-fjordi marha</option>
                    <option value="501">Vestlandeti vörös szarvtalanított marha</option>
                    <option value="502">Vianesa marha</option>
                    <option value="503">Volinyi húsmarha</option>
                    <option value="504">Vorderwald marha</option>
                    <option value="505">Vosgienne marha</option>
                    <option value="506">Vörös Brangus marha</option>
                    <option value="507">Vörös csittagongi marha</option>
                    <option value="508">Vörös-fehér fríz</option>
                    <option value="509">Vörös Fulani marha</option>
                    <option value="510">Vörös gorbatovi marha</option>
                    <option value="511">Vörös Höhenvieh marha</option>
                    <option value="512">Vörös Kandhari marha</option>
                    <option value="513">Vörös mingréliai marha</option>
                    <option value="514">Vörös Sindhi marha</option>
                    <option value="515">Vörös szarvatlan marha</option>
                    <option value="516">Vörös tambovi marha</option>
                    <option value="517">Waguli marha</option>
                    <option value="518">Wagyu marha</option>
                    <option value="519">Walesi fekete marha</option>
                    <option value="520">Wangus marha</option>
                    <option value="521">White Park marha</option>
                    <option value="522">Yanhuang marha</option>
                    <option value="523">Żubroń</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingType">típusa [type]:</label>
                <select id="floatingType" name="type">
                    <option value="1">Kettős hasznosítású</option>
                    <option value="2">Tejhasznú</option>
                    <option value="3">Húshasznú</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingColour">színe [colour]:</label>
                <select id="floatingColour" name="colour">
                    <option value="1">Fekete [Black]</option>
                    <option value="2">Vörös [Red]</option>
                    <option value="3">Sötétbarna-Fehér tarka [Dark Brown & White]</option>
                    <option value="4">Kék [Blue]</option>
                    <option value="5">Tűzöttsárga [Yellow ticking]</option>
                    <option value="6">Vörös-fehér tarka [Red & White]</option>
                    <option value="7">Brindle [Brindle]</option>
                    <option value="8">Fekete-fehér tarka [Black & White]</option>
                    <option value="9">fehér [White]</option>
                    <option value="10">Szürkésbarna [Greyish Brown]</option>
                    <option value="11">kéktarka [Blue & White]</option>
                </select>
            </div>
            <div class="form-group">
                <label for="floatingBirthdate">születési dátuma [date of birth]:</label>
                <input type="date" id="floatingBirthdate" name="birthDate" required>
            </div>
            <div class="form-group">
                <label for="floatingMotherId">anya/recipiens azonosító<br>[dam's/recipient's number]:</label>
                <input type="text" id="floatingMotherId" name="motherId" style="width: 400px;">
            </div>
            <div class="form-group">
                <label for="floatingFatherId">apa/recipiens azonosító<br>[sire's/recipient's number]:</label>
                <input type="text" id="floatingFatherId" name="fatherId" style="width: 400px;">
            </div>
            <#if HCinput??>
                <div class="form-group">
                    <label for="floatingHoldingId">Tenyészet kódja [Holding code]:</label>
                    <input type="text" id="floatingHoldingId" name="holdingId" style="width: 400px; margin-bottom: 15px" required>
                </div>
            </#if>

            <button type="button"
                    class="btn btn-outline-primary"
                     onclick="document.location='/'"
                     style="border: 2px solid rgb(128,128,128);
                     color: rgb(128,128,128);
                     float: inline-start;
                     margin-top: 15px;"
                    name="cancel-button">
                Mégse
            </button>
            <button type="submit"
                    class="btn btn-primary"
                    style="background-color: rgb(128,128,128);
                    border-color: rgb(128,128,128);
                    float: inline-end;
                    margin-top: 15px;"
                    name="submit-button">
                Mentés
            </button>
        </form>

        <#if CDerror??>
            <div style="color: red; margin-top: 15px;">${CDerror}</div>
        </#if>
        <#if SIerror??>
           <div style="color: red; margin-top: 15px;">${SIerror}</div>
        </#if>
        <#if HCerror??>
           <div style="color: red; margin-top: 15px;">${HCerror}</div>
        </#if>
        <#if MIerror??>
            <div style="color: red; margin-top: 15px;">${MIerror?html}</div>
        </#if>
        <#if FIerror??>
            <div style="color: red; margin-top: 15px;">${FIerror?html}</div>
        </#if>
        <#if Derror??>
            <div style="color: red; margin-top: 15px;">${Derror}</div>
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

            function validateForm() {
                const inputValue = inputField.value;

                if (!pattern.test(inputValue)) {
                    return false;
                }

                else {
                    return true;
                }
            }
        </script>
    </main>
</body>
</html>