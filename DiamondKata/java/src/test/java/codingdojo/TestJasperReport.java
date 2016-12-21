package codingdojo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class TestJasperReport {

	@Test
	public void tryingToLoadReport() throws JRException, FileNotFoundException {

		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(
				"target/compiledReports/Credit_Note.jasper"));
//		JasperReport jasperReport = JasperCompileManager
//				.compileReport("src/main/webapp/com/skilrock/lms/web/reportsMgmt/rawReports/Debit_Note.jrxml");
		JRLoader.loadObject(bufferedInputStream);
	}
}
