package lab.aikibo.main;

import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JFrame;

import lab.aikibo.reporting.KlasifikasiNjop;
import lab.aikibo.util.BoneCPDS;
import lab.aikibo.util.ConnectorUtil;
import lab.aikibo.util.Parsing;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

public class MainApp {
	
	private HashMap<String, Object> parameters;
	private Connection conn;
	private String kodeReport;
	
	public MainApp(String param) throws JRException {
		init(param);
		//JasperPrint jasperPrint = JasperFillManager.fillReport("report/lamp_sk_klasifikasi_njop.jasper",
		//		parameters, conn);
		//JasperExportManager.exportReportToPdfFile(jasperPrint, "klasifikasi_njop.pdf");
		
		//JRViewer viewer = new JRViewer(jasperPrint);
		//JFrame frame = new JFrame();
		//Container c = frame.getContentPane();
		//c.add(viewer);
		//frame.setSize(new Dimension(800, 600));
		//frame.setVisible(true);
	}
	
	private void init(String param) {
		Parsing parse = new Parsing(param);
		
		if(parse.getJnsLaporan().equals(Parsing.SK_KLASIFIKASI_NJOP)) {
			getSkKlasifikasiNjop(parse.getThnPajak(), parse.getKdKecamatan(), 
					parse.getKdKelurahan());
		}
		
		//parameters = new HashMap<String, Object>();
		//parameters.put("thn_pajak", param);
		//parameters.put("kd_kecamatan", "160");
		//parameters.put("kd_kelurahan", "018");
		//conn = new BoneCPDS().getBoneCPConn();
	}
	
	public void getSkKlasifikasiNjop(String thnPajak, String kdKecamatan, String kdKelurahan) {
		try {
			KlasifikasiNjop klasi = new KlasifikasiNjop(thnPajak, kdKecamatan, kdKelurahan);
			klasi.runReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) throws JRException, IOException {
		// just for debugging, is the report.jasper in the location path
		//String current = new java.io.File(".").getCanonicalPath();
		//System.out.println("Posisi : " + current);
		MainApp app = new MainApp(args[0]);
		System.out.println("Selesai.");
	}

}
