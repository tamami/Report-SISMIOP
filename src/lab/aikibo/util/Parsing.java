package lab.aikibo.util;

public class Parsing {
	public static final String SK_KLASIFIKASI_NJOP = "01";
	
	private String jnsLaporan;
	private String thnPajak;
	private String kdKecamatan;
	private String kdKelurahan;
	
	public Parsing(String text) {
		jnsLaporan = text.substring(0,2);
		if(jnsLaporan.equals(SK_KLASIFIKASI_NJOP) &&
				text.length() == 12) {
			thnPajak = text.substring(2,6);
			kdKecamatan = text.substring(6,9);
			kdKelurahan = text.substring(9,12);
		} else {
			System.out.println("kode jenis laporan atau panjang kode text salah.");
		}
	}
	
	// setter and getter
	
	public String getJnsLaporan() {
		return jnsLaporan;
	}
	
	public String getThnPajak() {
		return thnPajak;
	}
	
	public String getKdKecamatan() {
		return kdKecamatan;
	}
	
	public String getKdKelurahan() {
		return kdKelurahan;
	}

}
