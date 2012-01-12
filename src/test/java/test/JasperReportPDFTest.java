package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.junit.Test;

public class JasperReportPDFTest {
    @Test
    public void should_convert_jrxml_to_pdf() throws Exception {
        InputStream input = new FileInputStream(new File("src/test/example/example1.jrxml"));
        JasperDesign design = JRXmlLoader.load(input);
        JasperReport report = JasperCompileManager.compileReport(design);
        JasperPrint print = JasperFillManager.fillReport(report, new HashMap<String, Object>(), new JREmptyDataSource());
        OutputStream output = new FileOutputStream(new File("/tmp/JasperReport.pdf"));
        JasperExportManager.exportReportToPdfStream(print, output);
        output.close();
    }
}
