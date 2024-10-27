package com.std.ec.mediccenter.ug.controller;

import com.std.ec.mediccenter.ug.util.AppConfigProperty;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import java.util.Map;

@Data
@Named(value = "jasperController")
@ViewScoped
public class JasperController implements Serializable {


    static {
        System.setProperty("java.awt.headless", "true");
    }

    public void generar() {
        try {
            byte[] bytes = JasperRunManager.runReportToPdf(getReportInputStream(), (Map<String, Object>) null, new JREmptyDataSource());
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline; filename=archivo.pdf");
            response.setHeader("Cache-Control", "max-age=30");
            response.setHeader("Pragma", "No-cache");
            response.setDateHeader("Expires", 0);

            response.setContentLength(bytes.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(bytes, 0, bytes.length);
            outStream.flush();
            outStream.close();

            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
            System.out.println("error jasper 1: " + ex.getMessage());
        } catch (JRException ex) {
            System.out.println("error jasper 2: " + ex.getMessage());
        }
    }

    protected InputStream getReportInputStream() {
        String rutaJasper = AppConfigProperty.getPropiedad("ruta.jasper");
        return this.getClass().getResourceAsStream(rutaJasper);
    }

}
