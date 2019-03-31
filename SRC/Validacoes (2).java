import javax.swing.JOptionPane;

//Classe para validação de qualquer tipo de dados

public class Validacoes {
	public Validacoes() {
	}

	// a é minimo, b é maximo
	public byte valByte(byte a, byte b, String instrucoes) {
		byte c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Byte.parseByte(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public int valInt(int a, int b, String instrucoes) {
		int c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Integer.parseInt(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public short valShort(short a, short b, String instrucoes) {
		short c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Short.parseShort(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public long valLong(long a, long b, String instrucoes) {
		long c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Long.parseLong(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public float valFloat(float a, float b, String instrucoes) {
		float c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Float.parseFloat(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public double valDouble(double a, double b, String instrucoes) {
		double c = 0;
		String aux = "";
		try {
			do {
				aux = JOptionPane.showInputDialog(instrucoes);
				c = Double.parseDouble(aux);
				if (c < a || c > b) {
					JOptionPane.showMessageDialog(null,
							"!Entrada de dados invalida!\n");
				}
			} while (c < a || c > b);
		} catch (NumberFormatException nfe) {
			System.out.println(nfe.getMessage());
		}
		return c;
	}

	// a é minimo, b é maximo
	public String valString(int a, int b, String instrucoes) {
		String c = null;
		do {
			c = JOptionPane.showInputDialog(instrucoes);
			if (c.length() < a || c.length() > b) {
				JOptionPane.showMessageDialog(null,
						"!Entrada de dados invalida!\n");
			}
		} while (c.length() < a || c.length() > b);
		return c;
	}

	// valida o tipo de contrato/tipoarea/nivelAcademico
	public String valTipoContratoNivelSector(String instrucoes, String a,
			String b, String d) {
		String c = "";
		do {
			c = JOptionPane.showInputDialog(instrucoes);
			if (c.equalsIgnoreCase(a) || c.equalsIgnoreCase(b)
					|| c.equalsIgnoreCase(d)) {
				JOptionPane.showMessageDialog(null, "" + c);
			} else
				JOptionPane.showMessageDialog(null,
						"!Entrada de dados invalida!\n");
		} while (c.equalsIgnoreCase(a) || c.equalsIgnoreCase(b)
				|| c.equalsIgnoreCase(d));
		return c;
	}

	// valida o BI
	public String valBI() {
		char t = ' ';
		String last = "";
		String bi = "";
		String num = "";
		boolean number = false;
		boolean letra = false;
		bi = valString(13, 13, "Introduza o numero bilhete de identificação\n");
		char l[] = { 'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f',
				'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l',
				'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r',
				'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x',
				'X', 'y', 'Y', 'z', 'Z' }, x[] = { '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9' };
		t = bi.charAt(bi.length() - 1);

		do {

			for (int i = 0; i < l.length; i++) {
				if (t == l[i]) {
					letra = true;
					last = "" + bi.charAt(bi.length() - 1);
					last = last.toUpperCase();
					t = last.charAt(0);
				}
			}
			if (letra == false)
				t = validarChar(l,
						"Introduza a letra do bilhete de identificação\n");

		} while (letra == false);
		for (int i = 0; i < bi.length() - 1; i++) {
			number = false;
			for (int j = 0; j < x.length; j++) {
				if (bi.charAt(i) == x[j]) {
					number = true;
					num += "" + x[j];
				}
			}
			if (number == false)
				num += validarChar(x, "Introduza o " + (i + 1) + "º digito\n");

		}
		return num + "" + t;
	}

	public char validarChar(char a[], String x) {
		boolean y = false;
		String subir = " ";
		char b = ' ';
		do {
			subir = valString(1, 1, x);
			subir = subir.toUpperCase();
			b = subir.charAt(0);
			for (short i = 0; i < a.length; i++)
				if (b == a[i]) {
					y = true;
				}
		} while (y == false);
		return b;
	}

	// a e b são caracteres minusculos e maiusculos de um tipo, c e d para outro
	public char valChar(char a, char b, char c, char d, String instrucoes) {
		char e = 0;
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog(instrucoes);
			e = aux.charAt(0);
			if (e != a && e != b && e != c && e != d) {
				JOptionPane.showMessageDialog(null,
						"!Entrada de dados invalida!\n");
			}
		} while (e != a && e != b && e != c && e != d);
		return e;
	}

	// a é maximo, b é minimo
	public String valEmail(int a, int b, String instrucoes) {
		String c = null;
		do {
			c = JOptionPane.showInputDialog(instrucoes);
			if (c.isEmpty() || c.length() < a || c.length() > b
					|| c.indexOf("@") == -1 || c.indexOf(".") == -1) {
				JOptionPane.showMessageDialog(null, "!Email invalido!\n");
			}
		} while (c.isEmpty() || c.length() < a || c.length() > b
				|| c.indexOf("@") == -1 || c.indexOf(".") == -1);
		return c;
	}

	public boolean valBoolean(String instrucoes) {
		boolean b = false;
		char e = 0;
		String aux = "";
		do {
			aux = JOptionPane.showInputDialog(instrucoes
					+ "\nV-Verdadeiro\nF-Falso");
			e = aux.charAt(0);
			if (e != 'f' && e != 'F' && e != 'v' && e != 'V') {
				JOptionPane.showMessageDialog(null,
						"!Entrada de dados invalida!\n");
			}
		} while (e != 'f' && e != 'F' && e != 'v' && e != 'V');
		if (e == 'v' || e == 'V')
			b = true;
		return b;
	}
}