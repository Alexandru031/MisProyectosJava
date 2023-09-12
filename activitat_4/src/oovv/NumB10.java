/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oovv;

/**
 *
 * @author usuario
 */
public class NumB10 {

    private int num;

    /**
     * constructor de NumB10. número en base 10
     *
     * @param num valor del número en base 10
     */
    public NumB10(int num) {
        this.num = num;
    }

    /**
     * assigna el valor al número.
     *
     * @param num valor a assignar
     */
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString(String num) {
        return num; // (error 1)
    }

    /**
     * canvia el número de base. accepta des de base 2 fins a 24.
     *
     * @param base a la qual es vol canviar el número
     * @return cadena que representa el número en la base indicada
     * @throws ArithmeticException si la base no està entre 2 i 24
     */
    public String canviaABase(int base) {
        if (base < 2 || base > 24) {
            throw new ArithmeticException("la base va de 2 a 24");
        }
        String digits = "0123456789ABCDEFGHIJKLMN"; // (error 2)
        String cad = "";
        while (num > 0) {  // (error 3)
            cad = cad + digits.charAt(num % base);
            num = num / base;
        }
        return alReves(cad); // crida al mètode alReves
    }

    /**
     * inverteix una cadena. inverteix l'ordre dels caràcters
     *
     * @param cad la cadena original
     * @return la cadena invertida
     */
    private String alReves(String cad) {
        String reves = ""; // (error 4)
        int i = cad.length() - 1;
        while (i >= 0) {
            reves = reves + cad.charAt(i);
            i--;
        }; // (error 5)
        return reves; // (error 6)
    }

    /**
* transforma el número a notació romana.
*
* @return la cadena en notació romana
* @throws ArithmeticException si el número no està entre 1 i 9999
*/

    public String canviaARoma() throws ArithmeticException {
        if (num < 1 || num > 9999) { // (error 7)
 throw new ArithmeticException("sols per a números entre 1 i 9999");
        }
        String[][] caracters = { // blocs de caràcters
            {"M", "W", "Ñ"}, // caràcters per als milers: 1000, 5000, 10000
            {"C", "D", "M"}, // caràcters per a les centenes: 100, 500, 1000
            {"X", "L", "C"}, // caràcters per a les desenes: 10, 50, 100
            {"I", "V", "X"} // caràcters per a les unitats: 1, 5, 10
        };
        int div = 1000; // primer divisor els milers
        int iBloc = 0; // índex per al bloc de caràcters
        String numR = ""; // cadena on es va a construir el número romà
        while (div > 0) {
            int digito = num / div; // obté el dígit superior del número
            String digitR = ""; // cadena on es construeix el dígit romà
            switch (digito) {
                case 9: // el primer caràcter del bloc seguit del tercer
                    digitR = caracters[iBloc][0] + caracters[iBloc][2];
                    break;
                case 8: // afegeix el primer caràcter del bloc
                    digitR = digitR + caracters[iBloc][0];
                case 7:
                    digitR = digitR + caracters[iBloc][0];
                case 6:
                    digitR = digitR + caracters[iBloc][0];
                case 5: // el segon caràcter del bloc va davant
                    digitR = caracters[iBloc][1] + digitR;
                    break;
                case 4: // el primer caràcter del bloc seguit del segon
                    digitR = caracters[iBloc][0] + caracters[iBloc][1];
                    break;
                case 3: // afegeix el primer caràcter del bloc
                    digitR = digitR + caracters[iBloc][0];
                case 2:
                    digitR = digitR + caracters[iBloc][0];
                case 1:
                    digitR = digitR + caracters[iBloc][0]; // (error 8)
                    break;
            }
            numR = numR + digitR; // afegeix el dígit al número romà
            iBloc++; // canvia de bloc de caràcters
            num = num % div; // elimina el dígit superior del número(el que hem tractat)
            div = div / 10; // canvia el divisor
        }
        return numR;
    }
}
