package lab.aikibo.test;

import lab.aikibo.util.Parsing;

public class ParsingTest {
	
	public static void main(String args[]) {
		Parsing parse = new Parsing("012014010001");
		System.out.println("Isinya : ");
		System.out.println("Tahun Pajak - " + parse.getThnPajak());
		System.out.println("Kode Kecamatan - " + parse.getKdKecamatan());
		System.out.println("Kode Kelurahan - " + parse.getKdKelurahan());
	}

}
