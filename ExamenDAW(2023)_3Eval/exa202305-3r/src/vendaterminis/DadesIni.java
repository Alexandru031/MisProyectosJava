 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendaterminis;

import excep.DNIincorrecteEX;
import excep.EstaBuitEX;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import oovv.Botiga;
import oovv.Client;
import oovv.Producte;
import oovv.Venda;
import oovv.VendaTermini;
import oovv.Venedor;

/**
 *
 * @author Eduardo Silvestre
 */
public class DadesIni {

    /**
     * @return la Botiga amb les dades de les matrius
     */
    public static Botiga creaBotiga() throws EstaBuitEX, DNIincorrecteEX {
        Botiga botiga = new Botiga();
        creaVenedors(botiga);
        creaProductes(botiga);
        creaVendes(botiga);
        creaVendesTermini(botiga);
        return botiga;
    }

    /**
     * crea els venedors.les dades d'obtenen de la matriu dadesVenedors, el DNI,
     * el nom, l'adreça, el telèfon i el codi
     *
     * @param botiga
     * @throws excep.EstaBuitEX
     * @throws excep.DNIincorrecteEX
     */
    public static void creaVenedors(Botiga botiga) throws EstaBuitEX, DNIincorrecteEX {
        String[] dadesVenedors = {
            "62882267-Z", "Raquel Faubel Matamoros", "Luis Vives 12, Valencia", "963730345", "1",
            "98916815-W", "Manolo Mata Moya", "Eras 12, L’ Eliana", "962710345", "11",
            "43252248-N", "Laura Martínez Pastor", "Subida cementerio 13, Valencia", "963330545", "111",
            "19387025-A", "María Sánchez Crespo", "Cuenca 25, Valencia", "963327271", "22",
            "93537545-H", "-", "-", "-", "22",//codi repetit
            "74188651-N", "Concha Boix García", "Rocha 31, Valencia", "962710345", "313",
            "23684141-Y", "Pedro calvo Mateu", "Contador 62, Valencia", "962710345", "123",
            "72805155-N", "Anaïs Angulo Hueso", "Cruces 3, Valencia", "962710345", "444",
            "51811896-A", "Joan Planells Cervera", "Senda Polvorín 46, Valencia", "962710345", "33",
            "87469859-P", "Santiago Vidal Soto", "Turia 2, Mislata", "962573498", "155",
            "87469859-P", "-", "-", "-", "",//codi buit
            "26917764-J", "Rosa Pérez Pastor", "San Antonio 34, Valencia", "963645896", "210",
            "54095070-M", "-", "-", "-", "-",//DNI incorrecte
            "54095070-J", "Francesc Corral Castell", "Alzira 16, Riba-Roja", "962735487", "211",
            "34001997-Q", "Encarna Gómez Lacuesta", "Pelayo 44, Valencia", "963346342", "222",
            "62120767-K", "Dolores Pérez Sanchís", "Santa Teresa Jornet 10, Lliria", "962710345", "131",
            "55245705-G", "Carles Landete Ruíz", "San José 62, Manises", "962710345", "44",
            "55245705-G", "-", "-", "-", "-",//DNI repetit
            "79178775-X", "José Herranz Caballero", "Dr. Marañón 2, Valencia", "962710345", "333"
        };

        Map<String, Venedor> mapVenedor = new HashMap<>();
        String dni = "";
        String nom = "";
        String adreca = "";
        String telefon = "";
        String codi = "";
        int cont = 1;
        int contVen = 1;
        for (int i = 0; i < dadesVenedors.length; i++) {
            if (cont > 5) {
                cont = 1;
            }
            switch (cont) {
                case 1:
                    dni = dadesVenedors[i];
                    break;
                case 2:
                    nom = dadesVenedors[i];
                    break;
                case 3:
                    adreca = dadesVenedors[i];
                    break;
                case 4:
                    telefon = dadesVenedors[i];
                    break;
                case 5:
                    codi = dadesVenedors[i];
                    break;
                default:
                    cont = 0;
                    break;
            }

            if (cont == 5 && !codi.equals("-") && !Muutil.esDNIcorrecte(dni) && !getTeRepetitCodiVenedor(mapVenedor, codi) && !getTeDNIRepetitVenedor(mapVenedor, dni)) {
                mapVenedor.put("Venedor_" + contVen, new Venedor(codi, dni, nom, adreca, telefon));
                cont = 0;
                contVen++;
            }
            cont++;
        }
        botiga.afegir(mapVenedor);
    }

    /**
     * crea els productes. les dades d'obtenen de la matriu dadesProductes, el
     * codi, la marca, la categoria, el nom, la descripció, el preu de compra i
     * el preu de venda
     */
    public static void creaProductes(Botiga botiga) throws EstaBuitEX {
        String[] dadesProductes = {
            "111", "Xiaomi", "Telefonía", "Redmi Note 7, 6.3", "169", "199",
            "126", "Xiaomi", "Telefonía", "Mi 9, 4G, 6.4", "388", "499",
            "199", "Huawei", "Telefonía", "P20 Lite, 5.84", "169", "189",
            "188", "Xiaomi", "Telefonía", "Pocophone F1, 6.2", "227", "331",
            "122", "Sony", "Telefonía", "Xperia 10 Plus, 6.5", "397", "409",
            "177", "Apple", "Telefonía", "iPhone 6s, 4.7", "269", "319",
            "133", "Apple", "Telefonía", "iPhone Xs, 5.8", "979", "1018",
            "144", "Huawei", "Telefonía", "P30 Pro, 6.47", "855", "949",
            "100", "Samsung", "Telefonía", "Galaxy A7, 6", "199", "249",
            "155", "Samsung", "Telefonía", "Galaxy S10+, 6.4", "889", "954",
            "166", "Motorola", "Telefonía", "Moto G7 Plus, 6.2", "239", "289",
            "222", "Yamaha", "HiFi", "Reproductor CDC-600", "289", "339",
            "233", "Yamaha", "HiFi", "Reproductor CDC-300", "209", "259",
            "244", "Denon", "HiFi", "Reproductor DCD-50BK", "269", "319",
            "266", "Denon", "HiFi", "Reproductor DCD-520", "169", "201",
            "299", "Teac", "HiFi", "Reproductor CD-P1260MKII", "169", "181",
            "288", "Sony", "HiFi", "Tocadiscos PS-LX300USB", "97", "152",
            "277", "Sony", "HiFi", "Tocadiscos PS-HX500", "397", "484",
            "255", "Pioneer", "HiFi", "Tocadiscos PL-30", "269", "318",
            "211", "Denon", "HiFi", "Tocadiscos DP-400", "399", "499",
            "200", "Yamaha", "HiFi", "Amplificador R-N303D", "279", "312",
            "286", "Yamaha", "HiFi", "Amplificador AS201", "149", "199",
            "287", "Denon", "HiFi", "Amplificador PMA-520AE", "189", "224",
            "299", "-", "-", "-", "0", "0",//el codi està repetit
            "274", "Pioneer", "HiFi", "Amplificador SX-B", "399", "479",
            "377", "LG", "Hogar", "Lavadora F4JGEY2W, 8.5Kg, 1400rpm", "269", "369",
            "366", "Bosch", "Hogar", "Lavadora WAT24661ES, 8Kg, 1200rpm", "388", "499",
            "399", "Siemens", "Hogar", "Lavadora WM14U940EU, 10Kg, 1400rpm", "1169", "1489",
            "333", "LG", "Hogar", "Friforífico GBB62PZGFN, 419L, 2m, A+++", "627", "729",
            "322", "Samsung", "Hogar", "Friforífico RB37J5325, 367L, 2m, A++", "497", "599",
            "376", "LiebHerr", "Hogar", "Friforífico CNPEL4813, 338L, 2m, A+++", "669", "769",
            "388", "Balay", "Hogar", "Congelador 3GFB642WE, 242L, A++", "479", "559",
            "344", "Delonghi", "Hogar", "Cafetera Nespresso EB80B, 19Bares, 1260W", "55", "69",
            "300", "Krups", "Hogar", "Cafetera Nespresso XN1108, 19Bares, 1310W", "59", "73",
            "355", "Balay", "Hogar", "Encimera 3EB967FRE, inducción, 60cm, 3zonas", "389", "454",
            "359", "Bosch", "Hogar", "Encimera PUJ631BB2E, inducción, 28cm, 3zonas", "289", "379",
            "311", "Balay", "Hogar", "Encimera 3ETGGG3HN, gas, 3fuegos", "189", "279",
            "", "-", "-", "-", "0", "0",//el codi està buit
            "369", "Bosch", "Hogar", "Lavavajillas SMS46FI1E, 13servicios", "539", "639",
            "477", "Lenovo", "Portátil", "Yoga 530-14IKB, I5-8250U, 8GB", "769", "899",
            "466", "Asus", "Portátil", "FX504GE-DM286, I7-8750H, 8GB", "388", "499",
            "499", "Huawei", "Portátil", "Matebook D2018, I5-8250U, 8GB", "169", "189",
            "488", "Lenovo", "Portátil", "Ideapad 330-15IKBR, I5-8250U, 8GB", "555", "629",
            "422", "Lenovo", "Portátil", "Ideapad 330-15IKBR, I7-8550U, 8GB", "597", "699",
            "411", "Apple", "Portátil", "MacBook Air, I5-5350U, 8GB", "769", "899",
            "400", "Apple", "Portátil", "MacBook Air 13, I5-8210Y, 8GB", "1119", "1218",
            "444", "HP", "Portátil", "255 G6, E2-9000e, 4GB", "199", "259",
            "433", "Asus", "Portátil", "X540LA-XX691T, I3-5005U, 8GB", "399", "449",
            "455", "Asus", "Portátil", "R570ZD-DM266, Ryzen 5 2500U, 8GB", "489", "574",
            "533", "Epson", "Proyector", "EH-TW610 full HD", "500", "591",
            "500", "Epson", "Proyector", "EB-X41 XGA", "280", "459",
            "511", "Optoma", "Proyector", "HD27BE full HD", "589", "657",
            "522", "LG", "Proyector", "PH150G HD", "211", "299",
            "633", "Samsung", "Televisión", "TV UE40NU7125 UHD 4K", "271", "379",
            "644", "Samsung", "Televisión", "TV UE49NU7105 UHD 4K", "309", "499",
            "655", "Samsung", "Televisión", "TV UE55NU7105 UHD 4K", "429", "579",
            "666", "Samsung", "Televisión", "TV UE65NU8005 UHD 4K", "781", "999",
            "677", "LG", "Televisión", "TV 70UK6950PLA UHD 4K", "1071", "1299",
            "611", "LG", "Televisión", "TV 43UK6470PLC UHD 4K", "265", "379",
            "622", "Thomson", "Televisión", "TV 65UD6406 UHD 4K", "588", "699",
            "911", "Sony", "Cámara", "Evil ILCE 5100L, 24.3MP, 16-50mm", "397", "410",
            "922", "Sony", "Cámara", "Evil A6000, 24.3MP, 16-50mm", "497", "599",
            "933", "Sony", "Cámara", "Evil A6400, 24.2MP, 16-50mm", "2587", "2652",
            "944", "Nikon", "Cámara", "Evil Z6, 24.5MP, 24-70mm", "397", "484",
            "955", "Canon", "Cámara", "Evil EOS M100, 24.2MP, 15-45mm", "297", "399",
            "966", "Canon", "Cámara", "Reflex EOS 4000D, 18.7MP, 18-55mm", "255", "319",
            "988", "Pentax", "Cámara", "Reflex Peab651, 24MP, 18-135mm", "955", "1099",
            "977", "Panasonic", "Cámara", "Evil Lumix DMC-G7, 16MP, 14-42mm", "457", "532",
            "977", "-", "-", "-", "0", "0",//el codi està repetit
            "918", "Panasonic", "Cámara", "Evil Lumix GX9MEC, 20.3MP, 12-60mm", "697", "784",
            "999", "Nikon", "Cámara", "Reflex D5300, 24.2MP, 18-55mm", "455", "504",
            "900", "Olimpus", "Cámara", "Evil OM-DE-M10, 16.1MP, 14-42mm", "519", "619"
        };
        Map<String, Producte> mapProducte = new HashMap<>();
//        String descripcio = "";
        String nom = "";
        String marca = "";
        String categoria = "";
        String codi = "";
        double preuCompra = 0;
        double preuVenda = 0;
        int cont = 1;
        int contProd = 1;
        for (int i = 0; i < dadesProductes.length; i++) {
            if (cont > 6) {
                cont = 1;
            }
            switch (cont) {
                case 1:
                    codi = dadesProductes[i];
                    break;
                case 2:
                    marca = dadesProductes[i];
                    break;
                case 3:
                    categoria = dadesProductes[i];
                    break;
                case 4:
                    nom = dadesProductes[i];
//                    String cad = dadesProductes[i];
//                    int pos = getPos(cad);
//                    nom = cad.substring(0, pos);
//                    descripcio = cad.substring(pos + 2, cad.length());
                    break;
                case 5:
                    preuCompra = Double.parseDouble(dadesProductes[i]);
                    break;
                case 6:
                    preuVenda = Double.parseDouble(dadesProductes[i]);
                    break;
            }

            if (cont == 6 && !codi.isEmpty() && !getTeRepetitCodiProducte(mapProducte, codi)) {
                mapProducte.put("Producte_" + contProd, new Producte(codi, marca, nom, categoria, preuCompra, preuVenda));
                cont = 0;
                contProd++;
            }
            cont++;
        }
        botiga.afegirProducte(mapProducte);
    }

    /**
     * crea les vendes normals.La data és un dia qualsevol de gener a març, el
 producte és aleatòri, el venedor és aleatòri i el preu de venda al pùblic
 és el 90% del preu de venda del producte.
     * @param botiga
     */
    public static void creaVendes(Botiga botiga) {
//        List<Venda> vendes = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            Producte prod = botiga.getAleatoriProducte();
            double preuVenda = prod.getPreuVenda()*0.9;
            botiga.afegirUnaVenda(new Venda(prod, botiga.getAleatoriVenedor(), getLocaldate(), preuVenda));
//            vendes.add(new Venda(prod, botiga.getAleatoriVenedor(), getLocaldate(), preuVenda));
            
        }
//        botiga.afegirVenda(vendes);
    }

    /**
     * crea les vendes a termini.les dades d'obtenen de la matriu
 dadesVendesTermini, el DNI del client, el nom del client, l’adreça del
 client, el telèfon del client, el nombre de compte del client, el codi
 del producte, el preu de venda al públic del producte, el nombre de
 terminis i la quantia de cada termini.
     * @param botiga
     * @throws excep.EstaBuitEX
     * @throws excep.DNIincorrecteEX
     */
    public static void creaVendesTermini(Botiga botiga) throws EstaBuitEX, DNIincorrecteEX {
        String[] dadesVendesTermini = {
            "99800622-B", "Juan Bello Tatay", "cuenca 25, Valencia", "963993484", "1234-88336", "399", "1299", "21", "30",
            "91666293-T", "Elvira Collado Anguix", "Benimarfull 18, Valencia", "963332893", "0022-93484", "988", "1009", "24", "30.33",
            "40097207-L", "Fernando Ferrer García", "Zamenoff 17, Valencia", "963377877", "577-37777", "155", "889", "12", "65",
            "40097207-X", "-", "-", "-", "-", "-", "0", "0", "0",//DNI incorrecte
            "79240799-A", "Pedro Campos Del Prado", "Quart 88, Valencia", "963974566", "1234-13213", "411", "899", "9", "80",
            "24143083-Y", "Maria Abradelo Bosch", "Goya 111, Valencia", "963670345", "5515-12343", "477", "899", "4", "33.33",
            "24143083-Y", "-", "-", "-", "-", "-", "0", "0", "0",//DNI repetit
            "21250583-D", "Diana Abascal Ávila", "Pio XII 33, Valencia", "963344875", "5515-39387", "322", "579", "8", "24.95",
            "39931659-W", "-", "-", "-", "", "-", "0", "0", "0",//el nombre de compte està buit
            "25847585-R", "Alvaro Aragón Díaz", "Soller 1, Valencia", "963333333", "0033-12323", "211", "499", "23", "26"
        };
        String dni = "";
        String nom = "";
        String adreca = "";
        String telefono = "";
        String codi = "";
        String nomComcepte = "";
        double preuVendaPublic = 0;
        int nombeTerminis = 0;
        double quantia = 0;
        int cont = 1;
        int contVenda = 1;
        for (String dadesVendes : dadesVendesTermini) {
            if (cont > 9) {
                cont = 1;
            }
            switch (cont) {
                case 1:
                    dni = dadesVendes;
                    break;
                case 2:
                    nom = dadesVendes;
                    break;
                case 3:
                    adreca = dadesVendes;
                    break;
                case 4:
                    telefono = dadesVendes;
                    break;
                case 5:
                    nomComcepte = dadesVendes;
                    break;
                case 6:
                    codi = dadesVendes;
                    break;
                case 7:
                    preuVendaPublic = Double.parseDouble(dadesVendes);
                    break;
                case 8:
                    nombeTerminis = Integer.parseInt(dadesVendes);
                    break;
                case 9:
                    quantia = Double.parseDouble(dadesVendes);
                    break;
            }
            if (cont == 9 && !Muutil.esDNIcorrecte(dni) && /*!getTeDNIRepetitVendaTerm(vendaTermi, clients, dni)*/ !botiga.getTeDNIRepetit(dni) && !nomComcepte.isEmpty()) {
                Client client = new Client(nomComcepte, dni, nom, adreca, telefono);
                botiga.afegirUnClient(client);
                botiga.afegirUnaVendaTermini(new VendaTermini(client, nombeTerminis, quantia, botiga.getCodiProducte(codi), botiga.getAleatoriVenedor(), getLocaldate(), preuVendaPublic*0.9));
                cont = 0;
                contVenda++;
            }
            cont++;
        }
    }

    private static LocalDate getLocaldate() {
        return LocalDate.of(2023, 1 + (int) (Math.random() * 3), 1 + (int) (Math.random() * 28));
    }

//    private static int getPos(String cad) {
//        char coma = ',';
//        for (int i = 0; i < cad.length(); i++) {
//            if (cad.charAt(i) == coma) {
//                return i;
//            }
//        }
//        return cad.length();
//    }

    private static boolean getTeRepetitCodiVenedor(Map<String, Venedor> mapVenedor, String codi) {
        for (Map.Entry<String, Venedor> entry : mapVenedor.entrySet()) {
            Venedor val = entry.getValue();
            if (val.getCodi().equals(codi)) {
                return true;
            }
        }
        return false;
    }

    private static boolean getTeDNIRepetitVenedor(Map<String, Venedor> mapVenedor, String dni) {
        for (Map.Entry<String, Venedor> entry : mapVenedor.entrySet()) {
            Venedor val = entry.getValue();
            if (val.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    private static boolean getTeRepetitCodiProducte(Map<String, Producte> mapProducte, String codi) {
        for (Map.Entry<String, Producte> entry : mapProducte.entrySet()) {
            Producte val = entry.getValue();
            if (val.getCodi().equals(codi)) {
                return true;
            }
        }
        return false;
    }

//    private static boolean getTeDNIRepetitVendaTerm(List<Venda> vendaTermi, List<Client> clients, String dni) {
//        boolean estaRepetit = false;
//        for (Iterator<Venda> iterator = vendaTermi.iterator(); iterator.hasNext();) {
//            Venda next = iterator.next();
//            if (next.getVenedor().getDni().equals(dni)) {
//                estaRepetit = true;
//            }
//        }
//        
//        for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
//            Client next = iterator.next();
//            String[] separaDNI = dni.split("-");
//            String otroDNI = next.getDni();
//            String[] separaOtro = otroDNI.split("-");
//            if (separaDNI[0].equals(separaOtro[0])) {
//                estaRepetit = true;
//            }
//        }
//        return estaRepetit;
//    }
}
