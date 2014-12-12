package lab.aikibo.reporting;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import lab.aikibo.util.BoneCPDS;

public class KlasifikasiNjop {
	
	private String thnPajak;
	private String kdKecamatan;
	private String kdKelurahan;
	private HashMap<String, Object> parameters;
	private Connection conn;
	private JasperPrint jasperPrint;
	
	public KlasifikasiNjop(String thnPajak, String kdKecamatan, String kdKelurahan) throws JRException {
		init(thnPajak, kdKecamatan, kdKelurahan);
	}
	
	public void init(String thnPajak, String kdKecamatan, String kdKelurahan) throws JRException {
		parameters = new HashMap<String,Object>();
		parameters.put("thn_pajak", thnPajak);
		parameters.put("kd_kecamatan", kdKecamatan);
		parameters.put("kd_kelurahan", kdKelurahan);
		
		conn = new BoneCPDS().getBoneCPConn();
		fillInReport();
	}
	
	public void fillInReport() throws JRException {
		jasperPrint = JasperFillManager.fillReport("report/lamp_sk_klasifikasi_njop.jasper",
				parameters, conn);
	}
	
	public void runReport() {
		JRViewer viewer = new JRViewer(jasperPrint);
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		c.add(viewer);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.setVisible(true);
	}

}
