/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Miri
 */
public class Validaciones {


    //VALIDACIONES STRINGS
    public boolean validarTextoSinEspacio(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;
            if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarCadena(String text) {

        if (text.isEmpty()) {
            return false;
        } else {
            text = text.trim();
            if (text.matches("^[a-zA-Z\\s]*")) {
                return true;
            }
        }
        return false;
    }

    public boolean validarCadenaSinCaracteres(String text) {

        if (text.isEmpty()) {
            return false;
        } else {
            text = text.trim();
            if (text.matches("^[a-zA-Z\\s]*")) {
                return true;
            }
        }
        return false;
    }

    public boolean ValidarTextoConEspacio(String texto) {
        String cadena = texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        if (cadena.length() >= 3 && cadena.length() <= 20 && cadena.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "    Incorrecto");
            JOptionPane.showMessageDialog(null, "    No de un espacio al final, y no use numeros o caracteres especiales");
            return false;
        }
    }

    public boolean validarNumeros(String x) {
        try {
            double n = Double.parseDouble(x);
            if (n < 0) {
                return false;
            } else {
                if (n >= 1) {
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public boolean validarTelefono(String tel) {
        if (tel.isEmpty()) {
            return false;
        } else {
            if (tel.matches("^[0-9]*$")) {
                if (tel.length() == 7 || tel.length() == 10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validarAnio(int anio) {
        Date dt = new Date();
        int year = dt.getYear();
        int anioActual = year + 1900;
        boolean valida = false;
        if (anio >= 1900 && anio <= anioActual) {

            valida = true;
        }
        return valida;
    }

    public boolean validar_email(String mail) {
        if (mail.isEmpty()) {
            return false;
        } else {
            boolean val = false;
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(mail);
            val = mather.find();

            return val;
        }
    }

    public boolean validar_emailEasy(String mail) {
        return mail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public boolean validarDirec(String code) {
        return code.matches("[a-zA-Z\\d\\s\\-\\,\\#\\.\\+]+") && code.length() <= 100;
    }

    public boolean validarEstrato(String est) {
        if (est.equalsIgnoreCase("ALTO") || est.equalsIgnoreCase("MEDIO") || est.equalsIgnoreCase("BAJO")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCedula(String cedula) {
        boolean val = false;
        //Divide la cadena en los 10 numeros
        //Integer.parseInt sirve para transformar una cadena a entero. 
        //subString es un metodo de string(Desde, hasta)
        if (cedula.matches("\\d{10}")) {
            int d1 = Integer.parseInt(cedula.substring(0, 1));
            int d2 = Integer.parseInt(cedula.substring(1, 2));
            int d3 = Integer.parseInt(cedula.substring(2, 3));
            int d4 = Integer.parseInt(cedula.substring(3, 4));
            int d5 = Integer.parseInt(cedula.substring(4, 5));
            int d6 = Integer.parseInt(cedula.substring(5, 6));
            int d7 = Integer.parseInt(cedula.substring(6, 7));
            int d8 = Integer.parseInt(cedula.substring(7, 8));
            int d9 = Integer.parseInt(cedula.substring(8, 9));
            int d10 = Integer.parseInt(cedula.substring(9));

            //Multiplica todas la posciones impares * 2 y las posiciones pares se multiplica 1
            d1 = d1 * 2;
            if (d1 > 9) {
                d1 = d1 - 9;
            }

            d3 = d3 * 2;
            if (d3 > 9) {
                d3 = d3 - 9;
            }

            d5 = d5 * 2;
            if (d5 > 9) {
                d5 = d5 - 9;
            }

            d7 = d7 * 2;
            if (d7 > 9) {
                d7 = d7 - 9;
            }

            d9 = d9 * 2;
            if (d9 > 9) {
                d9 = d9 - 9;
            }

            // SUMA TODOS LOS  NUMEROS PARES E IMPARES
            int sumpar = d2 + d4 + d6 + d8;
            int sumimp = d1 + d3 + d5 + d7 + d9;
            int total = sumpar + sumimp;

            //DIVIDO MI DECENA SUPERIRO PARA 10 Y SI EL RESULTADO ES DIFERENTE DE 0 SUMA 1
            double decenasuperior = total;
            while (decenasuperior % 10 != 0) {
                decenasuperior = decenasuperior + 1;
            }

            if ((decenasuperior - total) == d10) {
                val = true;
            }
        }
        return val;
    }

//    public boolean validarDetalle(String txto) {
//        if (txto.matches("^[A-Z]\\s\\d")) {
//            return true;
//        }
//        return false;
//    }
    public boolean validarFechaNacimiento(String dia, String mes, String anio) {

        dia = dia.replaceAll("\\s", "");
        mes = mes.replaceAll("\\s", "");
        anio = anio.replaceAll("\\s", "");
        int diaI, mesI, anioI;
        boolean validarFecha = false;
        Date dt = new Date();
        int year = dt.getYear();
        int anioActual = year + 1900;

        if (!dia.isEmpty() && !mes.isEmpty() && !anio.isEmpty()) {
            if (dia.matches("[0-9]{1,}") && mes.matches("[0-9]{1,}") && anio.matches("[0-9]{1,}")) {
                diaI = Integer.parseInt(dia);
                mesI = Integer.parseInt(mes);
                anioI = Integer.parseInt(anio);

                if (anioI > 1937 && anioI <= (anioActual - 18)) {

                    if (mesI >= 1 || mesI <= 12) {

                        if (mesI == 2) {
                            if (anioI % 4 == 0 && anioI % 100 != 0) {
                                if (diaI >= 1 && diaI <= 29) {

                                    validarFecha = true;
                                } else {
                                    if (diaI >= 1 && diaI <= 28) {

                                        validarFecha = true;
                                    }
                                }
                            }
                        } else {
                            if (mesI == 1 || mesI == 3 || mesI == 5 || mesI == 7 || mesI == 8 || mesI == 10 || mesI == 12) {
                                if (diaI >= 1 && diaI <= 31) {

                                    validarFecha = true;
                                }
                            } else {
                                if (mesI == 4 || mesI == 6 || mesI == 9 || mesI == 11) {
                                    if (diaI >= 1 && diaI <= 30) {
                                        validarFecha = true;

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return validarFecha;
    }

    //VALIDACIONES PARA LOGIN
    public boolean validarUsuario(String usuario) {
        boolean validar = usuario.matches("^[a-zA-Z]{3,}[\\d]*$");
        //puede ser texto con numero ejm: Organizacion12, o solo texto
        return validar;
    }

    public boolean validarContrasena(String password) {
        boolean validar = false;
        String expresion = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%.!%-_^*&+=()])(?=\\S+$).{8,20}$";//MINIMO 1 mayus y 1 minus , 1 caract especial, minimo 8 y max 20
        //min 1 letra mayus | min 1 letra minus | min 1 caract especial | min 1 numero | minimo 8 caracteres max 20
        validar = password.matches(expresion);
        return validar;
    }
}
